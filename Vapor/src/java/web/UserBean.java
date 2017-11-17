/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.List;
import entity.Myitem;
import entity.Myuser;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author GilbertCui
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

    @EJB
    private ejb.AuthBean authBean;
    @EJB
    private ejb.CartBean cartBean;
    @EJB
    private ejb.GameBean gameBean;
    @EJB
    private ejb.UserBean userBean;
    
    private float addBalanceCount;
    
    public float getAddBalanceCount() {
        return addBalanceCount;
    }
    
    public void setAddBalanceCount(float addBalanceCount) {
        this.addBalanceCount = addBalanceCount;
    }

    /* 充值  */
    public void addCharge() {
        userBean.addtoCharge(authBean.getLoggedInUserId(), addBalanceCount);
    }
    
    public List<Myitem> getGames() {
        return userBean.getAllGames(authBean.getLoggedInUserId());
    }
    
    public Myuser getCurrentUser() {
        return userBean.displayUserInfo(authBean.getLoggedInUserId());
    }
}
