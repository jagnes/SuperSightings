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
import java.util.ArrayList;
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
public class OrganizationController {

    @Autowired
    SuperService service;

    @GetMapping("organizations")
    public String getAllOrganizations(Model pageModel) {
        pageModel.addAttribute("allOrganizations", service.getAllOrganizations());

        return "organizations";
    }
    
    @GetMapping("orgdetails/{id}")
    public String displayOrgDetails(@PathVariable Integer id, Model pageModel) {
        Organization toGet = service.getOrgById(id);
        List<Super> supers = service.getSupersByOrg(id);
        
        pageModel.addAttribute("organization", toGet);
        pageModel.addAttribute("supers", supers);
        
        return "orgdetails";
    }
    
    @GetMapping("deleteorg")
    public String deleteOrg(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));

        service.deleteOrgById(id);

        return "redirect:/organizations";
    }
    
    @GetMapping("addorg")
    public String displayAddOrg(Model pageModel) {
        List<Super> allSupers = service.getAllSupers();
        pageModel.addAttribute("supers", allSupers);
        return "addorg";
    }
    
    @PostMapping("addorg")
    public String addOrg(HttpServletRequest request, Organization toAdd) {
        List<Super> supers = new ArrayList<>();
        for (String id : request.getParameterValues("checkedSupers")) {
            supers.add(service.getSuperById(Integer.parseInt(id)));
        }
        toAdd.setSupers(supers);
        service.addOrganization(toAdd);
        
        return "redirect:/organizations";
    }
    
    @GetMapping("editorg")
    public String displayEditOrg(HttpServletRequest request, Model pageModel) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Organization org = service.getOrgById(id);
        org.setSupers(service.getSupersByOrg(id));
        pageModel.addAttribute("org", org);
        
        List<Super> checkedSupers = org.getSupers();
        pageModel.addAttribute("checkedSupers", checkedSupers);
        
        List<Super> allSupers = service.getAllSupers();
        pageModel.addAttribute("supers", allSupers);
        
        return "editorg";
    }
    
    @PostMapping("editorg")
    public String editOrg(HttpServletRequest request, Organization toEdit) {
        List<Super> supers = new ArrayList<>();
        for (String id : request.getParameterValues("checkedSupers")) {
            supers.add(service.getSuperById(Integer.parseInt(id)));
        }
        toEdit.setSupers(supers);
        
        Integer id = Integer.parseInt(request.getParameter("orgId"));
        toEdit.setOrgId(id);
        
        service.editOrganization(toEdit);

        return "redirect:/orgdetails/" + toEdit.getOrgId();
    }
}
