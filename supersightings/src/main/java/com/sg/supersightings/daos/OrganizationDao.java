/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.daos;

import com.sg.supersightings.dtos.Organization;
import com.sg.supersightings.dtos.Super;
import java.util.List;

/**
 *
 * @author jweez
 */
public interface OrganizationDao {

    void addOrganization(Organization toAdd);

    void deleteOrgById(Integer id);

    void editOrganization(Organization toEdit);

    List<Organization> getAllOrganizations();

    Organization getOrgById(Integer id);

    List<Super> getSupersByOrg(Integer id);
    
}
