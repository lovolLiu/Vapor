/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Beta
 */
@ManagedBean(name = "registerBean")
@RequestScoped
public class RegisterBean {
    
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
    private String passwordAgain;
    private String email;
    private String tel;
    
    public String userRegister() {
        if (username != null && password != null && passwordAgain != null &&
                email != null && tel != null && !username.isEmpty() &&
                !password.isEmpty() && !passwordAgain.isEmpty() &&
                !email.isEmpty() && !tel.isEmpty()) {
            if (password.equals(passwordAgain)) {
                if (authBean.userRegister(username, password, email, tel)) {
                    return "login?faces-redirect=true";
                } else {
                    return "";
                }
            } else {
                return "";
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
    
    public String getPasswordAgain() {
        return passwordAgain;
    }
    
    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTel() {
        return tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    
}
