/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.services;

import com.sg.supersightings.daos.PowerDao;
import com.sg.supersightings.dtos.Power;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jweez
 */
@Service
public class SuperService {
    
    @Autowired
    PowerDao pDao;

    public List<Power> getAllPowers() {
        return pDao.getAllPowers();
    } 

    public Power getPowerById(Integer id) {
        return pDao.getPowerById(id);
    }

    public Power addPower(Power toAdd) {
        return pDao.addPower(toAdd);
    }
    
    
}
