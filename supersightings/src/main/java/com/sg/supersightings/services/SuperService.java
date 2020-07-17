/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.services;

import com.sg.supersightings.daos.OrganizationDaoDB;
import com.sg.supersightings.daos.PowerDaoDB;
import com.sg.supersightings.daos.SuperDaoDB;
import com.sg.supersightings.dtos.Organization;
import com.sg.supersightings.dtos.Power;
import com.sg.supersightings.dtos.Super;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jweez
 */
@Service
public class SuperService {
    
    @Autowired
    PowerDaoDB pDao;
    
    @Autowired
    SuperDaoDB sDao;
    
    @Autowired
    OrganizationDaoDB oDao;

    public List<Power> getAllPowers() {
        return pDao.getAllPowers();
    } 

    public Power getPowerById(Integer id) {
        return pDao.getPowerById(id);
    }

    public Power addPower(Power toAdd) {
        return pDao.addPower(toAdd);
    }

    public void deletePowerById(Integer id) {
        pDao.deletePowerById(id);
    }

    public void editPower(Power toEdit) {
        pDao.editPower(toEdit);
    }

    public List<Super> getAllSupers() {
        return sDao.getAllSupers();
    }

    public Super getSuperById(Integer id) {
        return sDao.getSuperById(id);
    }

    public Super addSuper(Super toAdd) {
        return sDao.addSuper(toAdd);
    }

    public void deleteSuperById(Integer id) {
        sDao.deleteSuperById(id);
    }

    public void editSuper(Super toEdit) {
        sDao.editSuper(toEdit);
    }

    public List<Organization> getAllOrganizations() {
        return oDao.getAllOrganizations();
    }

    public Organization getOrgById(Integer id) {
        return oDao.getOrgById(id);
    }

    public List<Super> getSupersByOrg(Integer id) {
        return oDao.getSupersByOrg(id);
    }

    public void deleteOrgById(Integer id) {
        oDao.deleteOrgById(id);
    }

    public Organization getOrgbySuper(Integer id) {
        return sDao.getOrgBySuper(id);
    }

    public void addOrganization(Organization toAdd) {
        oDao.addOrganization(toAdd);
    }

    public void editOrganization(Organization toEdit) {
        oDao.editOrganization(toEdit);
    }
    
    
}
