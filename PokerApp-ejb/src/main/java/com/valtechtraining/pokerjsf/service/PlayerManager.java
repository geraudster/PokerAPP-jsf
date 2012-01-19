/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valtechtraining.pokerjsf.service;

import com.valtechtraining.pokerjsf.domain.Player;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Training
 */
@Local
public interface PlayerManager {

    Player authenticate(String username, String password);

    void createPlayer(Player player);

    Player getPlayerDetails(String username);

    List<Player> getPlayers();
    
}
