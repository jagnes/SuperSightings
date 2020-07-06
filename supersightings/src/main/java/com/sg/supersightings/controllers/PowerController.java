/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.controllers;

import com.sg.supersightings.dtos.Power;
import com.sg.supersightings.services.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author jweez
 */
@Controller
public class PowerController {
    
    @Autowired
    SuperService service;
    
    @GetMapping("powers")
    public String getAllPowers(Model pageModel) {
        pageModel.addAttribute("allPowers", service.getAllPowers());
        
        return "powers";
    }
    
    @GetMapping("powerdetails/{id}")
    public String getPowerDetails(@PathVariable Integer id, Model pageModel) {
        Power toGet = service.getPowerById(id);
        pageModel.addAttribute("power", toGet);
        pageModel.addAttribute("powerId", toGet.getPowerId());
        
        return "powerdetails";
    }
    
    @GetMapping("addpower")
    public String displayAddPower() {
        
        return "addpower";
    }
    
    @PostMapping("addpower")
    public String addPower(Power toAdd, Model pageModel) {
        Power toReturn = service.addPower(toAdd);
        pageModel.addAttribute("newpower", toReturn);
        
        return "redirect:/powers";
    }
    
}