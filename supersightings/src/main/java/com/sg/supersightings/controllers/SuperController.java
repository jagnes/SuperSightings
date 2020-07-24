/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.controllers;

import com.sg.supersightings.dtos.Organization;
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
public class SuperController {

    @Autowired
    SuperService service;

    Set<ConstraintViolation<Super>> violations = new HashSet<>();

    @GetMapping("supers")
    public String getAllSupers(Model pageModel) {
        pageModel.addAttribute("allSupers", service.getAllSupers());

        return "supers";
    }

    @GetMapping("superdetails/{id}")
    public String getSuperById(@PathVariable Integer id, Model pageModel) {
        Super toGet = service.getSuperById(id);
        Power toAdd = service.getPowerById(toGet.getPowerId());
        List<Organization> orgs = service.getOrgsbySuper(id);
        List<Sighting> sightings = service.getSightingsBySuper(id);
        pageModel.addAttribute("power", toAdd);
        pageModel.addAttribute("superId", id);
        pageModel.addAttribute("super", toGet);
        pageModel.addAttribute("orgs", orgs);
        pageModel.addAttribute("sightings", sightings);
        for (Sighting s : sightings) {
            s.setLocSighted(service.getLocById(s.getLocSighted().getLocId()));
        }

        return "superdetails";
    }

    @GetMapping("addsuper")
    public String displayAddSuper(Model pageModel) {
        List<Power> allPowers = service.getAllPowers();
        pageModel.addAttribute("powers", allPowers);
        pageModel.addAttribute("errors", violations);
        return "addsuper";
    }

    @PostMapping("addsuper")
    public String addSuper(HttpServletRequest request, Super toAdd, Model pageModel) {
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(toAdd);

        if (!violations.isEmpty()) {
            List<Power> allPowers = service.getAllPowers();
            pageModel.addAttribute("powers", allPowers);
            pageModel.addAttribute("errors", violations);
            return "addsuper";
        }
        Integer id = Integer.parseInt(request.getParameter("powerId"));
        toAdd.setPowerId(id);
        service.addSuper(toAdd);

        return "redirect:/supers";
    }

    @GetMapping("deletesuper")
    public String deleteSuper(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));

        service.deleteSuperById(id);

        return "redirect:/supers";
    }

    @GetMapping("editsuper")
    public String displayEditSuper(HttpServletRequest request, Model pageModel) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Super toEdit = service.getSuperById(id);

        pageModel.addAttribute("super", toEdit);

        Power toChange = service.getPowerById(toEdit.getPowerId());
        pageModel.addAttribute("power", toChange);

        List<Power> allPowers = service.getAllPowers();
        pageModel.addAttribute("powers", allPowers);

        return "editsuper";
    }

    @PostMapping("editsuper")
    public String editSuper(@Valid Super toEdit, BindingResult br, HttpServletRequest request, Model pageModel) {
        if (br.hasErrors()) {
            pageModel.addAttribute("super", toEdit);
            Power toChange = service.getPowerById(toEdit.getPowerId());
            pageModel.addAttribute("power", toChange);
            List<Power> allPowers = service.getAllPowers();
            pageModel.addAttribute("powers", allPowers);
            return "editsuper";
        }
        Integer id = Integer.parseInt(request.getParameter("powerId"));
        toEdit.setPowerId(id);

        service.editSuper(toEdit);

        return "redirect:/superdetails/" + toEdit.getSuperId();
    }
}
