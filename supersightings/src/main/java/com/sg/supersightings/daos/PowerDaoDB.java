/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.daos;

import com.sg.supersightings.dtos.Power;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jweez
 */
@Repository
public class PowerDaoDB {
    
    @Autowired
    JdbcTemplate template;

    public List<Power> getAllPowers() {
        List<Power> allPowers = template.query("select * from powers", new PowerMapper());
        
        return allPowers;
    }

    public Power getPowerById(Integer id) {
        Power toGet = template.queryForObject(("select * from powers where powerid =?"), new PowerMapper(), id);
    
        return toGet;
    }

    public Power addPower(Power toAdd) {
        template.update("insert into powers (powerName, powerDescription) values (?, ?);",
                toAdd.getPowerName(), toAdd.getPowerDescription());
        int id = template.queryForObject("select last_insert_id()", Integer.class);
        toAdd.setPowerId(id);
        
        return toAdd;
    }
    
    public void deletePowerById(Integer id) {
        template.update("delete from powers where powerId =?", id);
        
        template.update("alter table powers auto_increment =?", id);
    }

    public void editPower(Power toEdit) {
        template.update("update powers set powerName =?, powerDescription =? where powerId =?",
                toEdit.getPowerName(),
                toEdit.getPowerDescription(),
                toEdit.getPowerId());
    }
    
    private static class PowerMapper implements RowMapper<Power> {
        
        public Power mapRow(ResultSet rs, int i) throws SQLException {
            Power toReturn = new Power();
            toReturn.setPowerId(rs.getInt("powerId"));
            toReturn.setPowerName(rs.getString("powerName"));
            toReturn.setPowerDescription(rs.getString("powerDescription"));
            
            return toReturn;
        }
    }
    
}
