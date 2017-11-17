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
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author apple
 */
@ManagedBean(name = "searchBean")
@RequestScoped
public class SearchBean {

    @EJB
    private ejb.AuthBean authBean;
    @EJB
    private ejb.CartBean cartBean;
    @EJB
    private ejb.GameBean gameBean;
    @EJB
    private ejb.UserBean userBean;
    
    HttpServletRequest request;
    String get_keyword;
    String get_c;
    int get_category;
    int MAXNUM;
    List<Myitem> result = null;

    public SearchBean() {
        request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        MAXNUM = 12;
    }
    
    public String getKeyword() {
        return request.getParameter("keyword");
    }
    
    public Integer getCategoryId() {
        String categoryId = request.getParameter("category");
        if (categoryId == null) {
            return 0;
        } else {
            return Integer.parseInt(categoryId);
        }
    }
    
    public Gameclass getCategory() {
        return gameBean.getCategory(getCategoryId());
    }

    public List<Myitem> getResult() {
        if (result != null) {
            return result;
        }
        this.get_keyword = request.getParameter("keyword");
        this.get_c = request.getParameter("category");
        if (get_c == null) {
            result = gameBean.searchNoCate(get_keyword, MAXNUM);
        } else {
            this.get_category = Integer.parseInt(get_c);
            result = gameBean.searchWithCate(get_keyword, get_category, MAXNUM);
        }
        return result;
    }
}
