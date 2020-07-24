/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.controllers;

import com.sg.supersightings.dtos.Location;
import com.sg.supersightings.dtos.Power;
import com.sg.supersightings.dtos.Sighting;
import com.sg.supersightings.dtos.Super;
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
public class SightingController {

    @Autowired
    SuperService service;

    Set<ConstraintViolation<Sighting>> violations = new HashSet<>();

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
        pageModel.addAttribute("supers", service.getAllSupers());
        pageModel.addAttribute("locations", service.getAllLocations());
        pageModel.addAttribute("errors", violations);
        return "addsighting";
    }

    @PostMapping("addsighting")
    public String addSighting(Sighting toAdd, HttpServletRequest request, Model pageModel) {
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(toAdd);

        if (!violations.isEmpty()) {
            pageModel.addAttribute("supers", service.getAllSupers());
            pageModel.addAttribute("locations", service.getAllLocations());
            pageModel.addAttribute("errors", violations);
            return "addsighting";
        }
        Integer superId = Integer.parseInt(request.getParameter("superId"));
        Integer locId = Integer.parseInt(request.getParameter("locId"));
        Super s = service.getSuperById(superId);
        Location l = service.getLocById(locId);
        toAdd.setSuperSighted(s);
        toAdd.setLocSighted(l);
        service.addSighting(toAdd);
        return "redirect:/sightings";
    }

    @GetMapping("deletesighting")
    public String deleteSighting(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));

        service.deleteSightingById(id);

        return "redirect:/sightings";
    }

    @GetMapping("editsighting")
    public String displayEditSighting(HttpServletRequest request, Model pageModel) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        pageModel.addAttribute("sighting", service.getSightingById(id));
        pageModel.addAttribute("supers", service.getAllSupers());
        pageModel.addAttribute("locations", service.getAllLocations());

        return "editsighting";
    }

    @PostMapping("editsighting")
    public String editSighting(HttpServletRequest request, Model pageModel, @Valid Sighting toEdit, BindingResult br) {
        if (br.hasErrors()) {
            Integer superId = Integer.parseInt(request.getParameter("superId"));
            toEdit.setSuperSighted(service.getSuperById(superId));
            Integer locId = Integer.parseInt(request.getParameter("locId"));
            toEdit.setLocSighted(service.getLocById(locId));
            pageModel.addAttribute("sighting", toEdit);
            pageModel.addAttribute("supers", service.getAllSupers());
            pageModel.addAttribute("locations", service.getAllLocations());
            return "editsighting";
        }
        Integer id = Integer.parseInt(request.getParameter("sightingId"));
        toEdit.setSightingId(id);
        Integer superId = Integer.parseInt(request.getParameter("superId"));
        toEdit.setSuperSighted(service.getSuperById(superId));
        Integer locId = Integer.parseInt(request.getParameter("locId"));
        toEdit.setLocSighted(service.getLocById(locId));
        service.editSighting(toEdit);

        return "redirect:/sightingdetails/" + toEdit.getSightingId();
    }
}
