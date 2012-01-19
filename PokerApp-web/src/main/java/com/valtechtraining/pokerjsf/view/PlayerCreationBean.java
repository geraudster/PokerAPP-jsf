/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valtechtraining.pokerjsf.view;

import com.valtechtraining.pokerjsf.domain.Player;
import com.valtechtraining.pokerjsf.service.PlayerManager;
import com.valtechtraining.pokerjsf.service.PlayerManagerBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Training
 */
@ManagedBean
@SessionScoped
public class PlayerCreationBean implements Serializable{
    private String username;
    private String password;
    @EJB
    private PlayerManager playerService;

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Creates a new instance of PlayerCreationBean
     */
    public PlayerCreationBean() {
        System.out.println("Creating new PlayerCreationBean");
    }
    
    
    public void createPlayer() {
        Player p = new Player(name, firstName, age, solde, username, password);
        playerService.createPlayer(p);
        System.out.println("Creation of player [" + name + ", " + firstName + ", " + age + ", " + solde + "]");
    }
    
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    private String name;
    private String firstName;
    private int age;
    private int solde;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public void removeAllPlayers() {
//        this.players.clear();
    }
}
