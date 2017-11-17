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
import javax.faces.event.ActionEvent;

/**
 *
 * @author Beta
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {
    
    @EJB
    private ejb.AuthBean authBean;
    @EJB
    private ejb.CartBean cartBean;
    @EJB
    private ejb.GameBean gameBean;
    @EJB
    private ejb.UserBean userBean;
    
    private String username;
    private String password;
    
    public String userLogin() {
        if (username != null && !username.isEmpty() &&
                password != null && !password.isEmpty()) {
            Myuser user = authBean.userLogin(username, password);
            if (user == null) {
                // Login failed.
                // Should have some prompt here.
                return "";
            } else {
                return "index?faces-redirect=true";
            }
        } else {
            return "";
        }
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
}
