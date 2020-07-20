/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.daos;

import com.sg.supersightings.dtos.Power;
import java.util.List;

/**
 *
 * @author jweez
 */
public interface PowerDao {

    Power addPower(Power toAdd);

    void deletePowerById(Integer id);

    void editPower(Power toEdit);

    List<Power> getAllPowers();

    Power getPowerById(Integer id);
    
}
