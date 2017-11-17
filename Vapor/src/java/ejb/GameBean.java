/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Gameclass;
import entity.Myitem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * An EJB for fetching game list and info.
 */
@Stateless
public class GameBean {

    @PersistenceContext
    private EntityManager em;

    /* 得到所有类的对象 */
    public List<Gameclass> getCategories() {
        return em.createNamedQuery("Gameclass.findAll").getResultList();
    }
    
    public Gameclass getCategory(int categoryId) {
        return (Gameclass) em.createNamedQuery("Gameclass.findById")
                .setParameter("id", categoryId)
                .getSingleResult();
    }

    /*  根据id得到一个item  */
    public Myitem getItem(int id) {
        return (Myitem) em.createNamedQuery("Myitem.findById").setParameter("id", id).getSingleResult();
    }

    /*search without category*/
    public List<Myitem> searchNoCate(String keyword, int MAXNUM) {
        //MAXNUM=12
        //define NULL
        String default_str = "";
        try {
            if (keyword.equals(default_str) || keyword == null) {
                /* exception ???*/
                //return first 12 items or error
                return null;
            } else {
                String part = "%";
                for (int i = 0; i < keyword.length(); i++) {
                    part += keyword.charAt(i) + "%";
                }
                Query q = em.createQuery("SELECT i FROM Myitem i where i.name LIKE :part");
                List<Myitem> result = q.setMaxResults(MAXNUM).setFirstResult(0).setParameter("part", part).getResultList();
                return result;
            }
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }

    /*search with keyword and category*/
    public List<Myitem> searchWithCate(String keyword, int category, int MAXNUM) {
        try {
            if (keyword == null) {
                keyword = "";
            }
            
            String part = "%";
            for (int i = 0; i < keyword.length(); i++) {
                part += keyword.charAt(i) + "%";
            }

            Gameclass gameClass = (Gameclass) em.createNamedQuery("Gameclass.findById")
                    .setParameter("id", category)
                    .getSingleResult();

            if (keyword.isEmpty()) {
                List<Myitem> result = em.createQuery("SELECT i FROM Myitem i where i.gameClassid=:category")
                        .setFirstResult(0)
                        .setParameter("category", gameClass)
                        .getResultList();
                return result;
            } else {
                List<Myitem> result = em.createQuery("SELECT i FROM Myitem i where i.name LIKE :part AND i.gameClassid=:category")
                        .setFirstResult(0)
                        .setParameter("part", part)
                        .setParameter("category", gameClass)
                        .getResultList();
                return result;
            }
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }

    public List<Myitem> getNewestThreeGames() {
        List<Myitem> myitem = em.createNamedQuery("Myitem.findAll").getResultList();
        Myitem m = new Myitem();
        List<Myitem> getThreeGames = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = new Date();
        Date d2 = new Date();
        long diff;

        for (int i = 1; i < myitem.size(); i++) {
            d1 = myitem.get(0).getPubTime();
            d2 = myitem.get(i).getPubTime();
            diff = d1.getTime() - d2.getTime();
            if (diff < 0) {
                m = myitem.get(0);
                myitem.set(0, myitem.get(i));
                myitem.set(i, m);
            }
        }

        for (int i = 2; i < myitem.size(); i++) {
            d1 = myitem.get(1).getPubTime();
            d2 = myitem.get(i).getPubTime();
            diff = d1.getTime() - d2.getTime();
            if (diff < 0) {
                m = myitem.get(1);
                myitem.set(1, myitem.get(i));
                myitem.set(i, m);
            }
        }

        for (int i = 3; i < myitem.size(); i++) {
            d1 = myitem.get(2).getPubTime();
            d2 = myitem.get(i).getPubTime();
            diff = d1.getTime() - d2.getTime();
            if (diff < 0) {
                m = myitem.get(2);
                myitem.set(2, myitem.get(i));
                myitem.set(i, m);
            }
        }

        getThreeGames.add(myitem.get(0));
        getThreeGames.add(myitem.get(1));
        getThreeGames.add(myitem.get(2));

        return getThreeGames;
    }

    public List<Myitem> getHotestThreeGames() {
        List<Myitem> hottestGames = em.createNamedQuery("Myitem.getHottestGames").getResultList();
        List<Myitem> hottestThreeGames = new ArrayList<>();
        
        hottestThreeGames.add(hottestGames.get(0));
        hottestThreeGames.add(hottestGames.get(1));
        hottestThreeGames.add(hottestGames.get(2));
        
        return hottestThreeGames;
    }

}
