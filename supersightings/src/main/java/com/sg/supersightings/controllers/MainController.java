/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.controllers;

import com.sg.supersightings.services.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author jweez
 */
@Controller
public class MainController {
    
    @Autowired
    SuperService service;
    
    @GetMapping("/")
    public String displayHomepage() {
        return "index";
    }
    
}
