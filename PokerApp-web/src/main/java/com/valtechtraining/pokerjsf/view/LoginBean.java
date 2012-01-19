/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valtechtraining.pokerjsf.view;

import com.valtechtraining.pokerjsf.service.PlayerManagerBean;
import com.valtechtraining.pokerjsf.domain.Player;
import com.valtechtraining.pokerjsf.service.PlayerManager;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Training
 */
@ManagedBean
@RequestScoped
public class LoginBean {
    @EJB
    private PlayerManager playerManager;

    @ManagedProperty(value="#{profileBean}")
    private ProfileBean profileBean;

    public void setProfileBean(ProfileBean profileBean) {
        this.profileBean = profileBean;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    private String username;
    private String password;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String login() {
        if (username == null) return "errorLogin";
        if ("admin".equals(username)) {
            profileBean.setAuthenticated(true);
            Player adminPlayer = new Player();
            adminPlayer.setUsername("admin");
            profileBean.setPlayer(adminPlayer);
            return "welcomeAdmin";
        }
        Player player = playerManager.authenticate(username, password);
        if (player !=null){
            profileBean.setAuthenticated(true);
            profileBean.setPlayer(player);
            return "welcomePlayer";
        }
        return "errorLogin";
    }
    
    public String logout(){
        profileBean.setAuthenticated(false);
        return "login";
    }
}
