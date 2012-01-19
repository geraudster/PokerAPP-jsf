/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valtechtraining.pokerjsf.service;

import com.valtechtraining.pokerjsf.domain.Player;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Training
 */
@Stateless
public class TartampionBean implements Tartampion {

    @PersistenceContext(unitName="PokerJSFPU")
    private EntityManager em;

    @Override
    public Player getPlayer(){
        System.out.println("In tartampion, finding player...");
        Player p = em.find(Player.class, 1L);
        System.out.println("Exiting tartampion, player found...");
        return p;
    }
}
