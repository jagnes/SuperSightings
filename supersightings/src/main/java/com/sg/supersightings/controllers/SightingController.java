/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.controllers;

import com.sg.supersightings.dtos.Sighting;
import com.sg.supersightings.services.SuperService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author jweez
 */
@Controller
public class SightingController {
    
    @Autowired
    SuperService service;

    @GetMapping("sightings")
    public String getAllSightings(Model pageModel) {
        List<Sighting> sightings = service.getAllSightings();
        pageModel.addAttribute("allSightings", sightings);
        
        return "sightings";
    }
    
    @GetMapping("sightingdetails/{id}")
    public String getSightingDetails(@PathVariable Integer id, Model pageModel) {
        Sighting toGet = service.getSightingById(id);
        pageModel.addAttribute("sighting", toGet);
        
        return "sightingdetails";
    }
    
    @GetMapping("addsighting")
    public String addSighting(Model pageModel) {
        
        return "addsighting";
    }
}
