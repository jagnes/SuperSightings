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
public interface SuperDao {

    Super addSuper(Super toAdd);

    void deleteSuperById(Integer id);

    void editSuper(Super toEdit);

    List<Super> getAllSupers();

    List<Organization> getOrgsBySuper(Integer id);

    Super getSuperById(Integer id);
    
    List<Super> getSupersByPower(Integer id);
}
