/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Cart;
import entity.Myitem;
import entity.Myorder;
import entity.Myuser;
import entity.OrderItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * An EJB for fetching and managing the cart.
 */
@Stateful
public class CartBean {
    
    @PersistenceContext
    private EntityManager em;
    
    /*  把商品加到购物车中  */
    public void addToCart(int userID, int itemID) {
        try {
            Myuser user = em.find(Myuser.class, userID);
            Myitem item = em.find(Myitem.class, itemID);
            Cart cart = new Cart();
            cart.setMyItemid(item);
            cart.setMyUserid(user);
            em.persist(cart);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    /*  把商品从购物车中移除  */
    public void removeFromCart(int userID, int itemID) {
        try {
            Myuser user = em.find(Myuser.class, userID);
            Myitem item = em.find(Myitem.class, itemID);

            Cart cart = (Cart) em.createNamedQuery("Cart.findByUserID_ItemID")
                    .setParameter("myItemid", item)
                    .setParameter("myUserid", user)
                    .getSingleResult();

            em.remove(cart);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    /*   查看购物车信息 */
    public List<Cart> displayCartInfo(int userID) {
        try {
            Myuser user = em.find(Myuser.class, userID);
            return em.createNamedQuery("Cart.findByUser").setParameter("user", user).getResultList();

        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
    /*  结账时，把商品从购物车中移除，放到订单中  */
    public List<Cart> getAllCart(int userID) {
        try {
            Myuser user = em.find(Myuser.class, userID);
            List<Cart> cart = em.createNamedQuery("Cart.findByUser").setParameter("user", user).getResultList();
            return cart;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    /*  结账时，把商品从购物车中移除，放到订单中  */
    public boolean addAllToOrder(List<Cart> cart,int userID){
        Myuser myuser = (Myuser)em.createNamedQuery("Myuser.findById").setParameter("id", userID).getSingleResult();
        
        Myorder myorder = new Myorder();
        myorder.setState(2);
        myorder.setTime(new Date());
        myorder.setUserId(myuser);
        em.persist(myorder);
        
        int i;
        float price = 0;
        for(i = 0; i < cart.size(); i++){
            price = price + cart.get(i).getMyItemid().getPrice();
        }
        if(price<=myuser.getCharge()){
            for (i = 0; i < cart.size(); i++) {
                Myitem item = em.find(Myitem.class, cart.get(i).getMyItemid().getId());
                item.setTimesOfBuy(item.getTimesOfBuy() + 1);
                
                OrderItem orderItem = new OrderItem();
                orderItem.setMyItemid(cart.get(i).getMyItemid());
                orderItem.setMyOrderid(myorder);

                removeFromCart(cart.get(i).getMyUserid().getId(), cart.get(i).getMyItemid().getId());
                em.persist(orderItem);
            }
            myuser.setCharge(myuser.getCharge() - price);
            em.persist(myuser);
            
            em.flush();
            em.clear();
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean isinCart(int userID,int itemID){
        Myuser user = em.find(Myuser.class, userID);
        Myitem item = em.find(Myitem.class, itemID);
        if (em.createNamedQuery("Cart.findByUserID_ItemID")
                    .setParameter("myItemid", item)
                    .setParameter("myUserid", user).getResultList().size() == 0) {
            return false;
        } else {
            return true;
        }
    }
    
}
