/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.daos;

import com.sg.supersightings.dtos.Power;
import com.sg.supersightings.dtos.Super;
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
public class SuperDaoDB {

    @Autowired
    JdbcTemplate template;

    public List<Super> getAllSupers() {
        List<Super> allSupers = template.query("select * from supers", new SuperMapper());

        return allSupers;
    }

    public Super getSuperById(Integer id) {
        Super toGet = template.queryForObject(("select * from supers where superId =?"), new SuperMapper(), id);
    
        return toGet;
    }

    public Super addSuper(Super toAdd) {
        template.update("insert into supers (superName, superDescription, powerId) values (?, ?, ?);",
                toAdd.getSuperName(), toAdd.getSuperDescription(), toAdd.getPowerId());
        int id = template.queryForObject("select last_insert_id()", Integer.class);
        toAdd.setSuperId(id);
        
        return toAdd;
    }

    public void deleteSuperById(Integer id) {
        template.update("delete from supers where superId =?", id);
        
        template.update("alter table supers auto_increment =?", id);
    }

    public void editSuper(Super toEdit) {
        template.update("update supers set superName =?, superDescription =?, powerId =? where superId =?",
                toEdit.getSuperName(),
                toEdit.getSuperDescription(),
                toEdit.getPowerId(),
                toEdit.getSuperId());
    }

    public class SuperMapper implements RowMapper<Super> {

        @Override
        public Super mapRow(ResultSet rs, int i) throws SQLException {
            Super toReturn = new Super();
            toReturn.setSuperId(rs.getInt("superId"));
            toReturn.setSuperName(rs.getString("superName"));
            toReturn.setSuperDescription(rs.getString("superDescription"));
            toReturn.setPowerId(rs.getInt("powerId"));

            return toReturn;
        }
    }
}
