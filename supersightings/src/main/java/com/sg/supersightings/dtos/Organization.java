/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.dtos;

import java.util.List;
import java.util.Objects;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author jweez
 */
public class Organization {

    private int orgId;
    
    @NotBlank(message = "Name must not be blank")
    @Size(max=30, message="Name must be less than 30 characters.")
    private String orgName;
    
    @Size(max=100, message="Description must be less than 100 characters.")
    private String orgDescription;
    
    @NotBlank(message = "Address must not be blank")
    @Size(max=50, message="Address must be less than 50 characters.")
    private String orgAddress;
    
    @NotBlank(message = "City must not be blank")
    @Size(max=50, message="City must be less than 50 characters.")
    private String orgCity;
    
    @NotBlank(message = "State must not be blank")
    @Size(min=2, max=2, message="State Abbreviation must be 2 characters.")
    private String orgState;
    
    @NotBlank(message = "Zip must not be blank")
    @Size(min=5, max=5, message="Zip Code be 5 characters.")
    private String orgZip;
    
    @NotBlank(message = "Phone must not be blank")
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message="Phone must be in the format of XXX-XXX-XXXX.")
    //@Size(min=12, max=12, message="Phone must be in the format of XXX-XXX-XXXX.")
    private String phone;
    
    private List<Super> supers;

    /**
     * @return the orgId
     */
    public int getOrgId() {
        return orgId;
    }

    /**
     * @param orgId the orgId to set
     */
    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    /**
     * @return the orgName
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName the orgName to set
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * @return the orgDescription
     */
    public String getOrgDescription() {
        return orgDescription;
    }

    /**
     * @param orgDescription the orgDescription to set
     */
    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }
    
    /**
     * @return the orgAddress
     */
    public String getOrgAddress() {
        return orgAddress;
    }

    /**
     * @param orgAddress the orgAddress to set
     */
    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    /**
     * @return the orgCity
     */
    public String getOrgCity() {
        return orgCity;
    }

    /**
     * @param orgCity the orgCity to set
     */
    public void setOrgCity(String orgCity) {
        this.orgCity = orgCity;
    }

    /**
     * @return the orgState
     */
    public String getOrgState() {
        return orgState;
    }

    /**
     * @param orgState the orgState to set
     */
    public void setOrgState(String orgState) {
        this.orgState = orgState;
    }

    /**
     * @return the orgZip
     */
    public String getOrgZip() {
        return orgZip;
    }

    /**
     * @param orgZip the orgZip to set
     */
    public void setOrgZip(String orgZip) {
        this.orgZip = orgZip;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the supers
     */
    public List<Super> getSupers() {
        return supers;
    }

    /**
     * @param supers the supers to set
     */
    public void setSupers(List<Super> supers) {
        this.supers = supers;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.orgId;
        hash = 71 * hash + Objects.hashCode(this.orgName);
        hash = 71 * hash + Objects.hashCode(this.orgDescription);
        hash = 71 * hash + Objects.hashCode(this.orgAddress);
        hash = 71 * hash + Objects.hashCode(this.orgCity);
        hash = 71 * hash + Objects.hashCode(this.orgState);
        hash = 71 * hash + Objects.hashCode(this.orgZip);
        hash = 71 * hash + Objects.hashCode(this.phone);
        hash = 71 * hash + Objects.hashCode(this.supers);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Organization other = (Organization) obj;
        if (this.orgId != other.orgId) {
            return false;
        }
        if (!Objects.equals(this.orgName, other.orgName)) {
            return false;
        }
        if (!Objects.equals(this.orgDescription, other.orgDescription)) {
            return false;
        }
        if (!Objects.equals(this.orgAddress, other.orgAddress)) {
            return false;
        }
        if (!Objects.equals(this.orgCity, other.orgCity)) {
            return false;
        }
        if (!Objects.equals(this.orgState, other.orgState)) {
            return false;
        }
        if (!Objects.equals(this.orgZip, other.orgZip)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.supers, other.supers)) {
            return false;
        }
        return true;
    }

    
    
    
}
