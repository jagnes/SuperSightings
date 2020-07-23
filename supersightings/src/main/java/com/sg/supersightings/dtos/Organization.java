/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.dtos;

import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author jweez
 */
@Entity
public class Organization {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orgId;
    
    @NotBlank
    @Size(max=30)
    private String orgName;
    
    @Size(max=100)
    private String orgDescription;
    
    @NotBlank
    @Size(max=50)
    private String orgAddress;
    
    @NotBlank
    @Size(max=50)
    private String orgCity;
    
    @NotBlank
    @Size(min=2, max=2)
    private String orgState;
    
    @NotBlank
    @Size(min=5, max=5)
    private String orgZip;
    
    @NotBlank
    @Size(min=12, max=12)
    private String phone;
    
    @ManyToMany
    @JoinTable(name = "organizations_supers",
            joinColumns = {
                @JoinColumn(name = "orgId")},
            inverseJoinColumns = {
                @JoinColumn(name = "superId")})
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
