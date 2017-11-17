/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.Gameclass;
import entity.Myitem;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gao
 */
@ManagedBean(name = "itemBean")
@SessionScoped
public class ItemBean {

    @EJB
    private ejb.AuthBean authBean;
    @EJB
    private ejb.CartBean cartBean;
    @EJB
    private ejb.GameBean gameBean;
    @EJB
    private ejb.UserBean userBean;
    
    private int itemId = -1;
    
    public int getItemId() {
        HttpServletRequest request = (HttpServletRequest)
                FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String value = request.getParameter("id");
        if (request.getParameter("id") != null) {
            itemId = Integer.parseInt(request.getParameter("id"));
        }
        return itemId;
    }
    
    /*  从网址中提取item_id，获取item实体   */
    public Myitem getItem() {
        return gameBean.getItem(getItemId());
    }

    /*   加入购物车   */
    public String addToCart() {
        if (!authBean.checkLoginState()) {
            return "login?faces-redirect=true";
        }
        int userId = authBean.getLoggedInUserId();
        cartBean.addToCart(userId, getItem().getId());
        return "cart?faces-redirect=true";
    }
    
    public Boolean getIsInCart(){
        int userId = authBean.getLoggedInUserId();
        return cartBean.isinCart(userId, getItemId());
    }
    
    public boolean getHasBeenBought() {
        int userId = authBean.getLoggedInUserId();
        return userBean.hasBought(getItemId(), userId);
    }

}
