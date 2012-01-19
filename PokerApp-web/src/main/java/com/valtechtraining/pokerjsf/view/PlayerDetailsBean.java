/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valtechtraining.pokerjsf.view;

import com.valtechtraining.pokerjsf.domain.Player;
import com.valtechtraining.pokerjsf.service.PlayerManager;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Training
 */
@ManagedBean
@SessionScoped
public class PlayerDetailsBean {
    @EJB
    private PlayerManager playerManager;
    /**
     * Creates a new instance of PlayerDetailsBean
     */
    public PlayerDetailsBean() {
    }

    private String username;

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    private Player player;

    /**
     * Get the value of player
     *
     * @return the value of player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Set the value of player
     *
     * @param player new value of player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void searchPlayer(){
        player = playerManager.getPlayerDetails(username);
    }

}
