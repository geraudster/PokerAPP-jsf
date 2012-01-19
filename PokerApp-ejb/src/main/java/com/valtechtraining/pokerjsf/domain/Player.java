/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valtechtraining.pokerjsf.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Training
 */
@Entity
public class Player implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long ID;

    public Player() {
    }

    public Player(String name, String firstName, int age, int solde, String username, String password) {
        this.name = name;
        this.firstName = firstName;
        this.age = age;
        this.solde = solde;
        this.username = username;
        this.password = password;
    }
    private String name;
    private String firstName;
    private int age;
    private int solde;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    private String password;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the solde
     */
    public int getSolde() {
        return solde;
    }

    /**
     * @param solde the solde to set
     */
    public void setSolde(int solde) {
        this.solde = solde;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
    
    @OneToMany(mappedBy="player",cascade= CascadeType.ALL)
    private List<Gain> gains;

    public List<Gain> getGains() {
        return gains;
    }

    public void setGains(List<Gain> gains) {
        this.gains = gains;
    }
    
    public void addGain(Gain g){
        if(gains == null) gains = new ArrayList<Gain>();
        gains.add(g);
        g.setPlayer(this);
    }
}
