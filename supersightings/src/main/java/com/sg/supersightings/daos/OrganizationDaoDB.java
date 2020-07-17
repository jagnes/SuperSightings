/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.daos;

import com.sg.supersightings.dtos.Organization;
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
public class OrganizationDaoDB {

    @Autowired
    JdbcTemplate template;

    @Autowired
    SuperDaoDB sDao;

    public List<Organization> getAllOrganizations() {
        return template.query("select * from organizations", new OrganizationMapper());
    }

    public Organization getOrgById(Integer id) {
        return template.queryForObject("select * from organizations where orgId =?", new OrganizationMapper(), id);
    }

    public List<Super> getSupersByOrg(Integer id) {
        return template.query("select s.superId, s.superName, s.superDescription, s.powerId from organizations o"
                + " inner join organizations_supers os on o.orgId = os.orgId"
                + " inner join supers s on s.superId = os.superId where o.orgId =?;",
                new SuperMapper(), id);
    }

    public void deleteOrgById(Integer id) {
        template.update("delete from organizations_supers where orgId =?", id);
        template.update("delete from organizations where orgId =?", id);
        template.update("alter table organizations auto_increment =?", id);
    }

    public void addOrganization(Organization toAdd) {
        template.update("insert into organizations (orgName, orgDescription, orgAddress,"
                + " orgCity, orgState, orgZip, phone) values (?,?,?,?,?,?,?)",
                toAdd.getOrgName(),
                toAdd.getOrgDescription(),
                toAdd.getOrgAddress(),
                toAdd.getOrgCity(),
                toAdd.getOrgState(),
                toAdd.getOrgZip(),
                toAdd.getPhone());

        int newId = template.queryForObject("select last_insert_id()", Integer.class);
        toAdd.setOrgId(newId);
        insertSupersInOrg(toAdd);
    }

    private void insertSupersInOrg(Organization toAdd) {
        final String INSERT_SUPERS = "insert into organizations_supers"
                + " (orgId, superId) values (?,?);";
        for (Super s : toAdd.getSupers()) {
            template.update(INSERT_SUPERS,
                    toAdd.getOrgId(), s.getSuperId());
        }
    }

    public void editOrganization(Organization toEdit) {
        template.update("update organizations set orgName=?, orgDescription=?, orgAddress=?,"
                + " orgCity=?, orgState=?, orgZip=?, phone=? where orgId=?",
                toEdit.getOrgName(),
                toEdit.getOrgDescription(),
                toEdit.getOrgAddress(),
                toEdit.getOrgCity(),
                toEdit.getOrgState(),
                toEdit.getOrgZip(),
                toEdit.getPhone(),
                toEdit.getOrgId());
        
        template.update("delete from organizations_supers where orgId =?", toEdit.getOrgId());
        
        insertSupersInOrg(toEdit);
    }

//    private void updateSupersInOrg(Organization toEdit) {
//        
//        
//        final String UPDATE_SUPERS = "update organizations_supers set orgId=?, superId=? where orgId=?;";
//        for (Super s : toEdit.getSupers()) {
//            template.update(UPDATE_SUPERS,
//                    toEdit.getOrgId(), s.getSuperId(), toEdit.getOrgId());
//        }
//    }

    private static class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization toReturn = new Organization();
            toReturn.setOrgId(rs.getInt("orgId"));
            toReturn.setOrgName(rs.getString("orgName"));
            toReturn.setOrgDescription(rs.getString("orgDescription"));
            toReturn.setOrgAddress(rs.getString("orgAddress"));
            toReturn.setOrgCity(rs.getString("orgCity"));
            toReturn.setOrgState(rs.getString("orgState"));
            toReturn.setOrgZip(rs.getString("orgZip"));
            toReturn.setPhone(rs.getString("phone"));
            return toReturn;
        }
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
