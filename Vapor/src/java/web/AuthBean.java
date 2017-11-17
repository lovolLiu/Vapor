/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.Myuser;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Beta
 */
@ManagedBean(name = "authBean")
@RequestScoped
public class AuthBean {
    
    @EJB
    private ejb.AuthBean authBean;
    @EJB
    private ejb.CartBean cartBean;
    @EJB
    private ejb.GameBean gameBean;
    @EJB
    private ejb.UserBean userBean;
    
    
    public boolean getLoginState() {
        return authBean.checkLoginState();
    }
    
    public Myuser getLoggedInUser() {
        if (getLoginState() == false) {
            return null;
        }
        int userId = authBean.getLoggedInUserId();
        return userBean.displayUserInfo(userId);
    }
    
    public String getEmailMd5(String email) {
        return authBean.getMd5(email);
    }
    
    public String logout() {
        authBean.userLogout(authBean.getLoggedInUserId());
        return "index?faces-redirect=true";
    }
    
}
