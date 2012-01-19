/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valtechtraining.pokerjsf.service;

import com.valtechtraining.pokerjsf.domain.Player;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Training
 */
@Stateless
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class PlayerManagerBean implements PlayerManager {
    @PersistenceContext(unitName="PokerJSFPU")
    private EntityManager em;
    public PlayerManagerBean(){
        
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Player> getPlayers (){
        List<Player> players = em.createQuery("select p from Player p").getResultList();
        return players;
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Player authenticate(String username, String password){
        Query q = em.createQuery("select p from Player p where p.username = :username and p.password = :password");
        q.setParameter("username", username).setParameter("password", password);
        List<Player> players = q.getResultList();
        if(players.size() != 1) return null;
        return players.get(0);
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createPlayer(Player player){
        em.persist(player);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Player getPlayerDetails(String username) {
        List<Player> players = em.createQuery("select p from Player p Join fetch p.gains g where p.username=:username")
                .setParameter("username", username).getResultList();

        if(players.isEmpty()) return null;
        return players.get(0);
    }
}
