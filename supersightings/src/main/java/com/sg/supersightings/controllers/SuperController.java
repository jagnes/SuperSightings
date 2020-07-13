/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.controllers;

import com.sg.supersightings.dtos.Organization;
import com.sg.supersightings.dtos.Power;
import com.sg.supersightings.dtos.Super;
import com.sg.supersightings.services.SuperService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class SuperController {

    @Autowired
    SuperService service;

    @GetMapping("supers")
    public String getAllSupers(Model pageModel) {
        pageModel.addAttribute("allSupers", service.getAllSupers());

        return "supers";
    }

    @GetMapping("superdetails/{id}")
    public String getSuperById(@PathVariable Integer id, Model pageModel) {
        Super toGet = service.getSuperById(id);
        Power toAdd = service.getPowerById(toGet.getPowerId());
        Organization org = service.getOrgbySuper(id);
        pageModel.addAttribute("power", toAdd);
        pageModel.addAttribute("superId", id);
        pageModel.addAttribute("super", toGet);
        pageModel.addAttribute("organization", org);

        return "superdetails";
    }

    @GetMapping("addsuper")
    public String displayAddSuper(Model pageModel) {
        List<Power> allPowers = service.getAllPowers();
        pageModel.addAttribute("powers", allPowers);
        
        List<Organization> allOrgs = service.getAllOrganizations();
        pageModel.addAttribute("orgs", allOrgs);

        return "addsuper";
    }

    @PostMapping("addsuper")
    public String addSuper(HttpServletRequest request, Super toAdd) {
        Integer id = Integer.parseInt(request.getParameter("powerId"));
        Integer orgId = Integer.parseInt(request.getParameter("orgId"));
        Organization org = service.getOrgById(orgId);
        toAdd.setPowerId(id);
        service.addSuper(toAdd, org);

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
        pageModel.addAttribute("superId", id);
        
        Power toChange = service.getPowerById(toEdit.getPowerId());
        pageModel.addAttribute("power", toChange);
        
        List<Power> allPowers = service.getAllPowers();
        pageModel.addAttribute("powers", allPowers);

        return "editsuper";
    }

    @PostMapping("editsuper")
    public String editSuper(HttpServletRequest request, Super toEdit) {
        Integer id = Integer.parseInt(request.getParameter("powerId"));
        toEdit.setPowerId(id);
        
        service.editSuper(toEdit);

        return "redirect:/superdetails/" + toEdit.getSuperId();
    }
}
