/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.daos;

import com.sg.supersightings.dtos.Location;
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
public class LocationDaoDB implements LocationDao {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Location> getAllLocations() {
        List<Location> allLocations = template.query("select * from locations", new LocationMapper());

        return allLocations;
    }

    @Override
    public Location getLocById(Integer id) {
        return template.queryForObject("select * from locations where locId=?", new LocationMapper(), id);
    }

    @Override
    public void addLocation(Location toAdd) {
        template.update("insert into locations(locName, locDescription, locAddress,"
                + " locCity, locState, locZip, locLatitude, locLongitude) values (?,?,?,?,?,?,?,?);",
                toAdd.getLocName(),
                toAdd.getLocDescription(),
                toAdd.getLocAddress(),
                toAdd.getLocCity(),
                toAdd.getLocState(),
                toAdd.getLocZip(),
                toAdd.getLocLatitude(),
                toAdd.getLocLongitude());
    }

    @Override
    public void deleteLocById(Integer id) {
        template.update("delete from sightings where locId =?", id);

        template.update("delete from locations where locId=?;", id);

        template.update("alter table locations auto_increment =?", id);
    }

    @Override
    public void editLocation(Location toEdit) {
        template.update("update locations set locName=?, locDescription=?, locAddress=?,"
                + " locCity=?, locState=?, locZip=?, locLatitude=?, locLongitude=? where locId=?",
                toEdit.getLocName(),
                toEdit.getLocDescription(),
                toEdit.getLocAddress(),
                toEdit.getLocCity(),
                toEdit.getLocState(),
                toEdit.getLocZip(),
                toEdit.getLocLatitude(),
                toEdit.getLocLongitude(),
                toEdit.getLocId());
    }

    private static class LocationMapper implements RowMapper<Location> {

        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location toReturn = new Location();
            toReturn.setLocId(rs.getInt("locId"));
            toReturn.setLocName(rs.getString("locName"));
            toReturn.setLocDescription(rs.getString("locDescription"));
            toReturn.setLocAddress(rs.getString("locAddress"));
            toReturn.setLocCity(rs.getString("locCity"));
            toReturn.setLocState(rs.getString("locState"));
            toReturn.setLocZip(rs.getString("locZip"));
            toReturn.setLocLatitude(rs.getBigDecimal("locLatitude"));
            toReturn.setLocLongitude(rs.getBigDecimal("locLongitude"));

            return toReturn;
        }
    }
}
