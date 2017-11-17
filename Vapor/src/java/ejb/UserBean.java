/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Myitem;
import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateful;
import entity.Myorder;
import entity.Myuser;
import entity.OrderItem;
import java.util.ArrayList;
import java.util.List;

/**
 * An EJB for fetching and managing user info.
 */
@Stateful
public class UserBean {

    @PersistenceContext
    private EntityManager em;

    /*      充值     */
    public void addtoCharge(int userID, float money) {
        try {
            Myuser user = em.find(Myuser.class, userID);
            user.setCharge(user.getCharge() + money);
            em.persist(user);
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }
    
    /*      消费    */
    public void useCharge(int userID, float money) {
        try {
            Myuser user = em.find(Myuser.class, userID);
            user.setCharge(user.getCharge() - money);
            em.persist(user);
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }

    /*   展示用户信息  */
    public Myuser displayUserInfo(int userID) {
        try {
            Myuser user = em.find(Myuser.class, userID);
            return user;

        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }

    }
    
    /*  根据用户id找到所有订单  */
    public List<Myorder> getAllOrders(int user_id) {
        return em.createNamedQuery("Myorder.findByUser")
                .setParameter("user", displayUserInfo(user_id))
                .getResultList();
    }
    
    /*  根据订单返回游戏库  */
    public List<OrderItem> getAllOrderItems(List<Myorder> order) {
        List<OrderItem> oItem = new ArrayList<>();
        for (Myorder o : order) {
            List<OrderItem> Orders = em.createNamedQuery("OrderItem.findItemByOrderId")
                    .setParameter("myOrderId", o)
                    .getResultList();
            for (OrderItem oI : Orders) {
                oItem.add(oI);
            }
        }
        return oItem;
    }
    
    public List<Myitem> getAllGames(int userId) {
        List<Myorder> orders = getAllOrders(userId);
        List<Myitem> games = new ArrayList<>();
        List<OrderItem> orderItems = getAllOrderItems(orders);
        
        for (OrderItem orderItem : orderItems) {
            games.add(orderItem.getMyItemid());
        }
        
        return games;
    }
    
    /*  查询余额  */
    public float getUserCharge(int userID) {
        try {
            Myuser user = em.find(Myuser.class, userID);
            return user.getCharge();
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }

    /*  判断已购项目  */
    public boolean hasBought(int item_id, int user_id) {
        List<Myorder> myOrder = getAllOrders(user_id);
        
        System.out.println("===========================================");
        System.out.println("===========================================");
        for (Myorder order : myOrder) {
            for (OrderItem item : order.getOrderItemCollection()) {
                System.out.println(item.getMyItemid().getName());
                if (item.getMyItemid().getId() == item_id) {
                    return true;
                }
            }
        }
        System.out.println("===========================================");
        System.out.println("===========================================");
        return false;
    }
    
        /*
     结账时，把商品从购物车中移除，放到订单中
    
     public void addToOrder(int userID,int itemID){
     try{
     Myuser user = em.find(Myuser.class,userID);
     Myitem item = em.find(Myitem.class, itemID);
     removeFromCart(userID,itemID);
     Myorder order  = new Myorder();
     order.setUserId(user);
     OrderItem orderItem = new OrderItem();
     orderItem.setMyOrderid(order);
     orderItem.setMyItemid(item);
     em.persist(order);
     em.persist(orderItem);
     }catch(Exception e ){
     throw new EJBException(e.getMessage());
     }
     }
     */
    
    
       
}
