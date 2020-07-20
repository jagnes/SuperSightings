/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.daos;

import com.sg.supersightings.dtos.Sighting;
import com.sg.supersightings.dtos.Super;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jweez
 */
@Repository
public class SightingDaoDB {
    
    @Autowired
    JdbcTemplate template;
    
    @Autowired
    SuperDaoDB sDao;
    
    @Autowired
    LocationDaoDB lDao;

    public List<Sighting> getAllSightings() {
        return template.query("select * from sightings", new SightingMapper());
    }

    public Sighting getSightingById(Integer id) {
        return template.queryForObject("select * from sightings where sightingId=?", new SightingMapper(), id);
    }

    private class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Sighting toReturn = new Sighting();
            toReturn.setSightingId(rs.getInt("sightingId"));
            toReturn.setSightingDate(rs.getDate("sightingDate"));
            toReturn.setSuperSighted(sDao.getSuperById(rs.getInt("superId")));
            toReturn.setLocSighted(lDao.getLocById(rs.getInt("locId")));
            return toReturn;
        }
    }
}
