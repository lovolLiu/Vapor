/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.ejb;

import entity.Gamedeveloper;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Beta
 */
@Stateless
public class GamedeveloperFacade extends AbstractFacade<Gamedeveloper> {
    @PersistenceContext(unitName = "VaporPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GamedeveloperFacade() {
        super(Gamedeveloper.class);
    }
    
}
