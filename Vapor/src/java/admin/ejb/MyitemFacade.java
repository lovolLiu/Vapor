/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.ejb;

import entity.Myitem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Beta
 */
@Stateless
public class MyitemFacade extends AbstractFacade<Myitem> {
    @PersistenceContext(unitName = "VaporPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MyitemFacade() {
        super(Myitem.class);
    }
    
}
