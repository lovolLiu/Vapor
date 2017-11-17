/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.Gameclass;
import entity.Myitem;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author apple
 */
@ManagedBean(name = "homePage")
@RequestScoped
public class HomePageBean {

    @EJB
    private ejb.AuthBean authBean;
    @EJB
    private ejb.CartBean cartBean;
    @EJB
    private ejb.GameBean gameBean;
    @EJB
    private ejb.UserBean userBean;

    /*  返回分类实体 */
    public List<Gameclass> getCategories() {
        return gameBean.getCategories();
    }

    public List<Myitem> getNewestGames() {
        return gameBean.getNewestThreeGames();
    }

    public List<Myitem> getHotestGames() {
        return gameBean.getHotestThreeGames();
    }
    
    public String navigateToLibrary() {
        if (authBean.checkLoginState()) {
            return "user-library?faces-redirect=true";
        } else {
            return "";
        }
    }

}
