/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.controllers;

import com.sg.supersightings.dtos.Power;
import com.sg.supersightings.services.SuperService;
import java.util.HashSet;
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
public class PowerController {

    @Autowired
    SuperService service;

    Set<ConstraintViolation<Power>> violations = new HashSet<>();

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
        pageModel.addAttribute("supers", service.getSupersByPower(id));
        return "powerdetails";
    }

    @GetMapping("addpower")
    public String displayAddPower(Model pageModel) {

        pageModel.addAttribute("errors", violations);
        return "addpower";
    }

    @PostMapping("addpower")
    public String addPower(Power toAdd, Model pageModel) {
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        violations = validate.validate(toAdd);

        if (!violations.isEmpty()) {
            pageModel.addAttribute("errors", violations);
            return "addpower";
        }
        service.addPower(toAdd);

        return "redirect:/powers";
    }

    @GetMapping("deletepower")
    public String deletePower(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));

        service.deletePowerById(id);

        return "redirect:/powers";
    }

    @GetMapping("editpower")
    public String displayEditPower(HttpServletRequest request, Model pageModel) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Power toEdit = service.getPowerById(id);
        pageModel.addAttribute("power", toEdit);

        return "editpower";
    }

    @PostMapping("editpower")
    public String editPower(@Valid Power toEdit, BindingResult br, Model pageModel) {
        if (br.hasErrors()) {
            pageModel.addAttribute("power", toEdit);
            return "editpower";
        }
        service.editPower(toEdit);

        return "redirect:/powerdetails/" + toEdit.getPowerId();
    }
}
