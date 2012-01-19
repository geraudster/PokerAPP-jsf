/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valtechtraining.pokerjsf.view;

import com.valtechtraining.pokerjsf.domain.Player;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Training
 */
@ManagedBean
@SessionScoped
public class ProfileBean implements Serializable{
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    /**
     * Creates a new instance of ProfileBean
     */
    public ProfileBean() {
        this.player = new Player();
        this.authenticated = false;
    }
    private boolean authenticated;

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean isAuthenticated) {
        this.authenticated = isAuthenticated;
    }
    
}
