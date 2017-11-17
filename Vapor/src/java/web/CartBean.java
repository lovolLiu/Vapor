/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.Cart;
import java.text.DecimalFormat;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author apple
 */

@ManagedBean(name = "cart")
@RequestScoped
public class CartBean {
    @EJB
    private ejb.AuthBean authBean;
    @EJB
    private ejb.CartBean cartBean;
    @EJB
    private ejb.GameBean gameBean;
    @EJB
    private ejb.UserBean userBean;
    
    private int userId;
    private List<Cart> items = null;
    private float totalPrice = 0;
    
    public CartBean() {
    }
     
    /*  获取购物车信息 */
    public List<Cart> getItems(){
        userId = authBean.getLoggedInUserId();
        if (items == null) {
            items = cartBean.displayCartInfo(userId);
        }
        
        return items;
    }
    
    public Float getTotalPrice() {
        if (items == null) {
            items = getItems();
        }
        
        totalPrice = 0;
        for (Cart cartItem : items) {
            totalPrice += cartItem.getMyItemid().getPrice();
        }
        
        return totalPrice;
    }
    
    public String getTotalPriceText() {
        DecimalFormat decimalFormat=new DecimalFormat(".00");
        return decimalFormat.format(getTotalPrice());
    }
    
    /*  删除购物车 */
    public String removeItem(int itemID){
        userId = authBean.getLoggedInUserId();
        cartBean.removeFromCart(userId, itemID);
        
        return "cart?faces-redirect=true";
    }
    
    /* 结算  */
    public String checkOut(){
        userId = authBean.getLoggedInUserId();
        List<Cart> cart = cartBean.getAllCart(userId);
        cartBean.addAllToOrder(cart, userId);
        return "cart?faces-redirect=true";
    }
    
    public boolean getIsBalanceSufficient() {
        return userBean.getUserCharge(authBean.getLoggedInUserId()) >= getTotalPrice();
    }
    
}
