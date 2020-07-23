/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.controllers;

import com.sg.supersightings.dtos.Sighting;
import com.sg.supersightings.services.SuperService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String displayHomepage(Model pageModel) {
        List<Sighting> sightings = service.getAllSightings();
        sightings.sort(Comparator.comparing(o -> o.getSightingDate()));
        Collections.reverse(sightings);
        List<Sighting> lastTen = sightings.stream().limit(10).collect(Collectors.toList());
        pageModel.addAttribute("sightings", lastTen);

        return "index";
    }

}
