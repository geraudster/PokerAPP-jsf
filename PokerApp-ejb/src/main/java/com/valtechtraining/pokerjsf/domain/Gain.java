/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valtechtraining.pokerjsf.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Training
 */
@Entity
public class Gain implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long ID;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID  = ID;
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date gameDate;

    /**
     * Get the value of gameDate
     *
     * @return the value of gameDate
     */
    public Date getGameDate() {
        return gameDate;
    }

    /**
     * Set the value of gameDate
     *
     * @param gameDate new value of gameDate
     */
    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }
    
    private int amount;

    /**
     * Get the value of amount
     *
     * @return the value of amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Set the value of amount
     *
     * @param amount new value of amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @ManyToOne
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

}
