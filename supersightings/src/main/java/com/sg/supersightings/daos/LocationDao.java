/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.daos;

import com.sg.supersightings.dtos.Location;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jweez
 */
@Repository
public interface LocationDao {

    void addLocation(Location toAdd);

    void deleteLocById(Integer id);

    void editLocation(Location toEdit);

    List<Location> getAllLocations();

    Location getLocById(Integer id);
    
}
