/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.controllers;

import com.sg.supersightings.dtos.Location;
import com.sg.supersightings.dtos.Power;
import com.sg.supersightings.dtos.Sighting;
import com.sg.supersightings.services.SuperService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author jweez
 */
@Controller
public class LocationController {

    @Autowired
    SuperService service;

    Set<ConstraintViolation<Location>> violations = new HashSet<>();

    @GetMapping("locations")
    public String getAllLocations(Model pageModel) {
        pageModel.addAttribute("allLocations", service.getAllLocations());

        return "locations";
    }

    @GetMapping("locdetails/{id}")
    public String displayLocationDetails(@PathVariable Integer id, Model pageModel) {
        Location loc = service.getLocById(id);
        pageModel.addAttribute("loc", loc);
        List<Sighting> sightings = service.getSightingsByLocation(id);
        pageModel.addAttribute("sightings", sightings);
        for (Sighting s : sightings) {
            s.setSuperSighted(service.getSuperById(s.getSuperSighted().getSuperId()));
        }
        return "locdetails";
    }

    @GetMapping("addlocation")
    public String displayAddLocation(Model pageModel) {
        pageModel.addAttribute("errors", violations);
        return "addlocation";
    }

    @PostMapping("addlocation")
    public String addLocation(Location toAdd, Model pageModel) {
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(toAdd);
        if (!violations.isEmpty()) {
            pageModel.addAttribute("errors", violations);
            return "addlocation";
        }
        service.addLocation(toAdd);

        return "redirect:/locations";
    }

    @GetMapping("deletelocation")
    public String deleteLocation(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));

        service.deleteLocById(id);

        return "redirect:/locations";
    }

    @GetMapping("editlocation")
    public String displayEditLocation(HttpServletRequest request, Model pageModel) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Location loc = service.getLocById(id);
        pageModel.addAttribute("location", loc);

        return "editlocation";
    }

    @PostMapping("editlocation")
    public String editLocation(@Valid Location toEdit, BindingResult br, Model pageModel) {
        if (br.hasErrors()) {
            pageModel.addAttribute("location", toEdit);
            return "editlocation";
        }
        service.editLocation(toEdit);

        return "redirect:/locdetails/" + toEdit.getLocId();
    }
}
