/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.services;

import com.sg.supersightings.daos.LocationDaoDB;
import com.sg.supersightings.daos.OrganizationDaoDB;
import com.sg.supersightings.daos.PowerDaoDB;
import com.sg.supersightings.daos.SightingDaoDB;
import com.sg.supersightings.daos.SuperDaoDB;
import com.sg.supersightings.dtos.Location;
import com.sg.supersightings.dtos.Organization;
import com.sg.supersightings.dtos.Power;
import com.sg.supersightings.dtos.Sighting;
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
    
    @Autowired
    LocationDaoDB lDao;
    
    @Autowired
    SightingDaoDB siDao;

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

    public List<Location> getAllLocations() {
        return lDao.getAllLocations();
    }

    public Location getLocById(Integer id) {
        return lDao.getLocById(id);
    }

    public void addLocation(Location toAdd) {
        lDao.addLocation(toAdd);
    }

    public void deleteLocById(Integer id) {
        lDao.deleteLocById(id);
    }

    public void editLocation(Location toEdit) {
        lDao.editLocation(toEdit);
    }

    public List<Sighting> getAllSightings() {
        return siDao.getAllSightings();
    }

    public Sighting getSightingById(Integer id) {
        return siDao.getSightingById(id);
    }

    public void deleteSightingById(Integer id) {
        siDao.deleteSightingById(id);
    }
    
    public void addSighting(Sighting toAdd) {
        siDao.addSighting(toAdd);
    }

    public void editSighting(Sighting toEdit) {
        siDao.editSighting(toEdit);
    }
}
