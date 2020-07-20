/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.daos;

import com.sg.supersightings.dtos.Sighting;
import java.util.List;

/**
 *
 * @author jweez
 */
public interface SightingDao {

    void addSighting(Sighting toAdd);

    void deleteSightingById(Integer id);

    void editSighting(Sighting toEdit);

    List<Sighting> getAllSightings();

    Sighting getSightingById(Integer id);
    
}
