package com.sg.supersightings;

import com.sg.supersightings.daos.LocationDao;
import com.sg.supersightings.daos.OrganizationDao;
import com.sg.supersightings.daos.PowerDao;
import com.sg.supersightings.daos.SightingDao;
import com.sg.supersightings.daos.SuperDao;
import com.sg.supersightings.dtos.Location;
import com.sg.supersightings.dtos.Organization;
import com.sg.supersightings.dtos.Power;
import com.sg.supersightings.dtos.Sighting;
import com.sg.supersightings.dtos.Super;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
@ActiveProfiles("dao-test")
public class SupersightingsApplicationTests {

    @Autowired
    PowerDao pDao;

    @Autowired
    SuperDao sDao;

    @Autowired
    OrganizationDao oDao;

    @Autowired
    LocationDao lDao;

    @Autowired
    SightingDao siDao;

    @Autowired
    JdbcTemplate template;

    Power p = new Power(10, "One For All", "Deku's Quirk");
    Super s = new Super(10, "Deku", "All Might's successor", 1);
    Organization org = new Organization();
    Location loc = new Location();
    Sighting si = new Sighting();
    public SupersightingsApplicationTests() {
        org.setOrgName("League of Villians");
        org.setOrgDescription("Villinous Organization created by the"
                + " Strongest Villian All For One");
        org.setOrgAddress("666 Villian Ln");
        org.setOrgCity("St. Paul");
        org.setOrgState("MN");
        org.setOrgZip("55101");
        org.setPhone("763-999-8888");
        loc.setLocName("TSG");
        loc.setLocDescription("The Software Guild");
        loc.setLocAddress("15 S 5th St");
        loc.setLocCity("Minneapolis");
        loc.setLocState("MN");
        loc.setLocZip("55402");
        loc.setLocLatitude(new BigDecimal(45.000000));
        loc.setLocLongitude(new BigDecimal(-93.000000));
        si.setSightingDate(Date.from(Instant.now()));
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        template.update("DELETE FROM sightings;");
        template.update("DELETE FROM locations;");
        template.update("DELETE FROM organizations_supers;");
        template.update("DELETE FROM organizations;");
        template.update("DELETE FROM supers;");
        template.update("DELETE FROM powers;");

        template.update("ALTER TABLE sightings auto_increment = 1;");
        template.update("ALTER TABLE locations auto_increment = 1;");
        template.update("ALTER TABLE organizations_supers auto_increment = 1;");
        template.update("ALTER TABLE organizations auto_increment = 1;");
        template.update("ALTER TABLE supers auto_increment = 1;");
        template.update("ALTER TABLE powers auto_increment = 1;");

        template.update("insert into powers (powerName, powerDescription) values "
                + "	('Super Strength', 'Allows the user to greatly increase their strength and agility'),"
                + "    ('Erasure', 'Allows the user to erase other supers powers by looking them in the eye'),"
                + "    ('Heal', 'Allows the user to greatly speed up a supers healing process through contact'),"
                + "    "
                + "    ('Explosion', 'Allows the user to excrete nitroglycerin like sweat from thier palms and ignite it at will to create an explosion'),"
                + "    ('Half-Cold Half-Hot', 'Allows the user to generate ice from the right side of their body and flames from the left side of their body'),"
                + "    ('Hardening', 'Allows the user to harden their body like rock to protect the user or to use to attack'),"
                + "    "
                + "    ('Permeation', 'Allows the user to phase any part of thier body through physical matter'),"
                + "    ('Manifest', 'Allows the user to enhance their limbs with super powered versions of anything they consume'),"
                + "    ('Stamina Wave', 'Allows the user to steal stamina from any super as well as give their own stamina to any super through wave-like blasts');");

        template.update("insert into supers (superName, superDescription, powerId) values "
                + "	('All Might', 'The #1 hero', 1),"
                + "    ('Eraser Head', 'Expert at Hand-to-hand combat', 2),"
                + "    ('Recovery Girl', 'Support role only', 3),"
                + "    "
                + "    ('Kacchan', 'Hot headed, and does not work well with others', 4),"
                + "    ('Shoto', 'A prodigy. Can attack and defend at the same time', 5),"
                + "    ('Red Riot', 'Defensive based hero', 6),"
                + "    "
                + "    ('Lemillion', 'Expected to be the future #1 hero', 7),"
                + "    ('Suneater', 'Very strong but does not believe in his abilities', 8),"
                + "    ('Nejire', 'Bubbly personality, mainly a support role', 9);");

        template.update("insert into organizations (orgName, orgDescription, orgAddress, orgCity, orgState, orgZip, phone) values "
                + "	('Pro Heroes', 'Professional heroes contracted through the government', '123 Pro St', 'Brooklyn Park', 'MN', '55443', '651-123-4567'),"
                + "    ('Hero Academy', 'Hero high school training young heroes to become pro heroes', '456 Academy Ave', 'Minneapolis', 'MN', '55404', '612-111-1111'),"
                + "    ('The Big 3', 'Former Students of the Hero Academy. Interning to become pro heroes', '789 Plus Ultra Rd', 'Minneapolis', 'MN', '55111', '612-222-3333');");

        template.update("insert into organizations_supers (orgId, superId) values "
                + "	(1, 1),"
                + "    (1, 2),"
                + "    (1, 3),"
                + "    (2, 4),"
                + "    (2, 5),"
                + "    (2, 6),"
                + "    (3, 7),"
                + "    (3, 8),"
                + "    (3, 9);");

        template.update("insert into locations (locName, locDescription, locAddress, locCity, locState, locZip, locLatitude, locLongitude) values"
                + "	('US Bank Stadium', 'Home of the Minnesota Vikings', '401 Chicago Ave', 'Minneapolis', 'MN', '55415', 44.973411, -93.257621),"
                + "    ('Minnehaha Park', 'Home to the Minnehaha Falls. One of the oldest and most populat parks in Minneapolis', 'Minnehaha Ave', 'Minneapolis', 'MN', '55417',  44.915001, -93.209999),"
                + "    ('Park Center Senior High', 'Public High School on the border of Brooklyn Park and Brooklyn Center, hence the name \"Park Center\"', '7300 Brooklyn Blvd', 'Brooklyn Park', 'MN', '55443', 45.111181, -93.350499);");

        template.update("insert into sightings (superId, locId, sightingDate) values "
                + "	(1, 1, '2020-06-20'),"
                + "    (3, 1, '2020-06-20'),"
                + "    (5, 2, '2020-06-25'),"
                + "    (7, 2, '2020-06-25'),"
                + "    (9, 3, '2020-07-04');");
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetAllPowersGoldenPath() {
        List<Power> powers = pDao.getAllPowers();

        assertEquals(9, powers.size());
        assertEquals("Super Strength", powers.get(0).getPowerName());
        assertEquals("Stamina Wave", powers.get(8).getPowerName());
    }

    @Test
    public void testGetPowerByIdGoldenPath() {

        pDao.addPower(p);
        Power toGet = pDao.getPowerById(p.getPowerId());

        assertEquals(p.getPowerName(), toGet.getPowerName());
        assertEquals(p.getPowerDescription(), toGet.getPowerDescription());
    }

    @Test
    public void testAddPowerGoldenPath() {

        Power toAdd = pDao.addPower(p);

        List<Power> powers = pDao.getAllPowers();
        assertEquals(powers.get(9).getPowerName(), toAdd.getPowerName());
        assertEquals(powers.get(9).getPowerDescription(), toAdd.getPowerDescription());
    }

    @Test
    public void testDeletePowerByIdGoldenPath() {
        List<Power> before = pDao.getAllPowers();

        assertEquals(9, before.size());

        pDao.deletePowerById(9);

        List<Power> after = pDao.getAllPowers();
        assertEquals(8, after.size());
    }

    @Test
    public void testEditPowerGoldenPath() {
        Power toTest = pDao.getPowerById(9);
        assertEquals("Stamina Wave", toTest.getPowerName());

        p.setPowerId(9);
        pDao.editPower(p);

        List<Power> powers = pDao.getAllPowers();
        assertEquals(p.getPowerName(), powers.get(8).getPowerName());
        assertEquals(p.getPowerDescription(), powers.get(8).getPowerDescription());
    }

    @Test
    public void testGetAllSupersGoldenPath() {
        List<Super> supers = sDao.getAllSupers();

        assertEquals(9, supers.size());
        assertEquals("All Might", supers.get(0).getSuperName());
        assertEquals("Nejire", supers.get(8).getSuperName());
    }

    @Test
    public void testGetSuperByIdGoldenPath() {
        sDao.addSuper(s);
        Super toGet = sDao.getSuperById(s.getSuperId());

        assertEquals(s.getSuperName(), toGet.getSuperName());
        assertEquals(s.getSuperDescription(), toGet.getSuperDescription());
    }

    @Test
    public void testAddSuperGoldenPath() {
        sDao.addSuper(s);

        List<Super> supers = sDao.getAllSupers();
        assertEquals(s.getSuperName(), supers.get(9).getSuperName());
        assertEquals(s.getSuperDescription(), supers.get(9).getSuperDescription());
    }

    @Test
    public void testDeleteSuperByIdGoldenPath() {
        List<Super> before = sDao.getAllSupers();

        assertEquals(9, before.size());

        sDao.deleteSuperById(9);

        List<Super> after = sDao.getAllSupers();
        assertEquals(8, after.size());
    }

    @Test
    public void testEditSuperGoldenPath() {
        Super toTest = sDao.getSuperById(9);
        assertEquals("Nejire", toTest.getSuperName());

        s.setSuperId(9);
        sDao.editSuper(s);

        List<Super> supers = sDao.getAllSupers();
        assertEquals(s.getSuperName(), supers.get(8).getSuperName());
        assertEquals(s.getSuperDescription(), supers.get(8).getSuperDescription());
    }

    @Test
    public void testGetOrgsBySuperGoldenPath() {
        List<Organization> orgs = sDao.getOrgsBySuper(1);

        assertEquals(1, orgs.size());
        assertEquals("Pro Heroes", orgs.get(0).getOrgName());
    }

    @Test
    public void testGetSupersByPowerGoldenPath() {
        List<Super> supers = sDao.getSupersByPower(1);

        assertEquals(1, supers.size());
        assertEquals("All Might", supers.get(0).getSuperName());
    }

    @Test
    public void testGetAllOrganizationsGoldenPath() {
        List<Organization> orgs = oDao.getAllOrganizations();

        assertEquals(3, orgs.size());
        assertEquals("Pro Heroes", orgs.get(0).getOrgName());
        assertEquals("The Big 3", orgs.get(2).getOrgName());
    }

    @Test
    public void testGetOrgByIdGoldenPath() {
        Organization toGet = oDao.getOrgById(2);

        assertEquals("Hero Academy", toGet.getOrgName());
        assertEquals("Hero high school training young heroes to become pro heroes", toGet.getOrgDescription());
    }

    @Test
    public void testGetSupersByOrgGoldenPath() {
        List<Super> supers = oDao.getSupersByOrg(3);

        assertEquals(3, supers.size());
        assertEquals("Lemillion", supers.get(0).getSuperName());
        assertEquals("Suneater", supers.get(1).getSuperName());
    }

    @Test
    public void testDeleteOrgByIdGoldenPath() {
        List<Organization> before = oDao.getAllOrganizations();

        assertEquals(3, before.size());

        oDao.deleteOrgById(3);

        List<Organization> after = oDao.getAllOrganizations();
        assertEquals(2, after.size());
    }

    @Test
    public void testAddOrgGoldenPath() {
        org.setSupers(oDao.getSupersByOrg(2));
        oDao.addOrganization(org);

        List<Organization> orgs = oDao.getAllOrganizations();
        assertEquals(org.getOrgName(), orgs.get(3).getOrgName());
        assertEquals(org.getOrgDescription(), orgs.get(3).getOrgDescription());
    }

    @Test
    public void testEditOrgGoldenPath() {
        org.setSupers(oDao.getSupersByOrg(2));
        org.setOrgId(3);
        oDao.editOrganization(org);

        List<Organization> orgs = oDao.getAllOrganizations();
        assertEquals(org.getOrgName(), orgs.get(2).getOrgName());
        assertEquals(org.getOrgDescription(), orgs.get(2).getOrgDescription());
    }

    @Test
    public void testGetAllLocationsGoldenPath() {
        List<Location> locations = lDao.getAllLocations();

        assertEquals(3, locations.size());
        assertEquals("US Bank Stadium", locations.get(0).getLocName());
        assertEquals("Park Center Senior High", locations.get(2).getLocName());
    }

    @Test
    public void testGetLocbyIdGoldenPath() {
        Location l = lDao.getLocById(2);

        assertEquals("Minnehaha Park", l.getLocName());
        assertEquals("Home to the Minnehaha Falls. One of the oldest and most"
                + " populat parks in Minneapolis", l.getLocDescription());
    }

    @Test
    public void testAddLocationGoldenPath() {
        lDao.addLocation(loc);

        List<Location> locations = lDao.getAllLocations();
        assertEquals(loc.getLocName(), locations.get(3).getLocName());
        assertEquals(loc.getLocDescription(), locations.get(3).getLocDescription());
    }

    @Test
    public void testDeleteLocByIdGoldenPath() {
        List<Location> before = lDao.getAllLocations();
        assertEquals(3, before.size());

        lDao.deleteLocById(3);

        List<Location> after = lDao.getAllLocations();
        assertEquals(2, after.size());
    }

    @Test
    public void testEditLocationGoldenPath() {
        loc.setLocId(3);
        lDao.editLocation(loc);

        List<Location> locations = lDao.getAllLocations();
        assertEquals(loc.getLocName(), locations.get(2).getLocName());
        assertEquals(loc.getLocDescription(), locations.get(2).getLocDescription());
    }

    @Test
    public void testGetAllSightingsGoldenPath() {
        List<Sighting> sightings = siDao.getAllSightings();
        assertEquals(5, sightings.size());
        assertEquals("All Might", sightings.get(0).getSuperSighted().getSuperName());
        assertEquals("Nejire", sightings.get(4).getSuperSighted().getSuperName());
    }

    @Test
    public void testGetSightingByIdGoldenPath() {
        Sighting sighting = siDao.getSightingById(3);
        
        assertEquals("Shoto", sighting.getSuperSighted().getSuperName());
        assertEquals("Minnehaha Park", sighting.getLocSighted().getLocName());
    }

    @Test
    public void testDeleteSightingByIdGoldenPath() {
        List<Sighting> before = siDao.getAllSightings();
        assertEquals(5, before.size());

        siDao.deleteSightingById(3);

        List<Sighting> after = siDao.getAllSightings();
        assertEquals(4, after.size());
    }

    @Test
    public void testAddSightingGoldenPath() {
        si.setSuperSighted(sDao.getSuperById(2));
        si.setLocSighted(lDao.getLocById(2));
        siDao.addSighting(si);
        
        List<Sighting> sighting = siDao.getAllSightings();
        assertEquals(si.getSuperSighted(), sighting.get(5).getSuperSighted());
        assertEquals(si.getLocSighted(), sighting.get(5).getLocSighted());
    }

    @Test
    public void testEditSightingGoldenPath() {
        si.setSightingId(5);
        si.setSuperSighted(sDao.getSuperById(2));
        si.setLocSighted(lDao.getLocById(2));
        siDao.editSighting(si);
        
        List<Sighting> sighting = siDao.getAllSightings();
        assertEquals(si.getSuperSighted(), sighting.get(4).getSuperSighted());
        assertEquals(si.getLocSighted(), sighting.get(4).getLocSighted());
    }

    @Test
    public void testGetSightingsByLocationGoldenPath() {
        List<Sighting> sightings = siDao.getSightingsByLocation(1);
        assertEquals(2, sightings.size());
        assertEquals("All Might", sightings.get(0).getSuperSighted().getSuperName());
        assertEquals("Recovery Girl", sightings.get(1).getSuperSighted().getSuperName());
    }

    @Test
    public void testGetSightingsBySuperGoldenPath() {
        List<Sighting> sightings = siDao.getSightingsBySuper(5);
        assertEquals(1, sightings.size());
        assertEquals("Shoto", sightings.get(0).getSuperSighted().getSuperName());
        assertEquals("Minnehaha Park", sightings.get(0).getLocSighted().getLocName());
    }
}
