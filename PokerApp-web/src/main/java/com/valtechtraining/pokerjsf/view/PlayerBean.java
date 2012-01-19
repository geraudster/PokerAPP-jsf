/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valtechtraining.pokerjsf.view;

import com.valtechtraining.pokerjsf.domain.Player;
import com.valtechtraining.pokerjsf.service.PlayerManager;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Training
 */
@ManagedBean
public class PlayerBean {
    @EJB
    private PlayerManager playerService;

    public PlayerBean() {
    }

    public List<Player> getPlayers() {
       return playerService.getPlayers();
    }
}
