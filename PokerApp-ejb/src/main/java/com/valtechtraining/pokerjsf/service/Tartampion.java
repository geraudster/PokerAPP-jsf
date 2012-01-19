/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valtechtraining.pokerjsf.service;

import com.valtechtraining.pokerjsf.domain.Player;
import javax.ejb.Local;

/**
 *
 * @author Training
 */
@Local
public interface Tartampion {

    Player getPlayer();
    
}
