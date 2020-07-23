/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.dtos;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author jweez
 */
@Entity
public class Location {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locId;
    
    @NotBlank
    @Size(max=50)
    private String locName;
    
    @Size(max=100)
    private String locDescription;
    
    @NotBlank
    @Size(max=50)
    private String locAddress;
    
    @NotBlank
    @Size(max=50)
    private String locCity;
    
    @NotBlank
    @Size(min=2, max=2)
    private String locState;
    
    @NotBlank
    @Size(min=5, max=5)
    private String locZip;
    
    @NotBlank
    @Digits(integer=2, fraction=6)
    @DecimalMin(value = "-90.00000")
    @DecimalMax(value = "-90.00000")
    private BigDecimal locLatitude;
    
    @NotBlank
    @Digits(integer=3, fraction=6)
    @DecimalMin("90.00000")
    @DecimalMax(value = "-90.00000")
    private BigDecimal locLongitude;

    /**
     * @return the locId
     */
    public int getLocId() {
        return locId;
    }

    /**
     * @param locId the locId to set
     */
    public void setLocId(int locId) {
        this.locId = locId;
    }

    /**
     * @return the locName
     */
    public String getLocName() {
        return locName;
    }

    /**
     * @param locName the locName to set
     */
    public void setLocName(String locName) {
        this.locName = locName;
    }

    /**
     * @return the locDescription
     */
    public String getLocDescription() {
        return locDescription;
    }

    /**
     * @param locDescription the locDescription to set
     */
    public void setLocDescription(String locDescription) {
        this.locDescription = locDescription;
    }

    /**
     * @return the locAddress
     */
    public String getLocAddress() {
        return locAddress;
    }

    /**
     * @param locAddress the locAddress to set
     */
    public void setLocAddress(String locAddress) {
        this.locAddress = locAddress;
    }

    /**
     * @return the locCity
     */
    public String getLocCity() {
        return locCity;
    }

    /**
     * @param locCity the locCity to set
     */
    public void setLocCity(String locCity) {
        this.locCity = locCity;
    }

    /**
     * @return the locState
     */
    public String getLocState() {
        return locState;
    }

    /**
     * @param locState the locState to set
     */
    public void setLocState(String locState) {
        this.locState = locState;
    }

    /**
     * @return the locZip
     */
    public String getLocZip() {
        return locZip;
    }

    /**
     * @param locZip the locZip to set
     */
    public void setLocZip(String locZip) {
        this.locZip = locZip;
    }

    /**
     * @return the locLatitude
     */
    public BigDecimal getLocLatitude() {
        return locLatitude;
    }

    /**
     * @param locLatitude the locLatitude to set
     */
    public void setLocLatitude(BigDecimal locLatitude) {
        this.locLatitude = locLatitude;
    }

    /**
     * @return the locLongitude
     */
    public BigDecimal getLocLongitude() {
        return locLongitude;
    }

    /**
     * @param locLongitude the locLongitude to set
     */
    public void setLocLongitude(BigDecimal locLongitude) {
        this.locLongitude = locLongitude;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.locId;
        hash = 17 * hash + Objects.hashCode(this.locName);
        hash = 17 * hash + Objects.hashCode(this.locDescription);
        hash = 17 * hash + Objects.hashCode(this.locAddress);
        hash = 17 * hash + Objects.hashCode(this.locCity);
        hash = 17 * hash + Objects.hashCode(this.locState);
        hash = 17 * hash + Objects.hashCode(this.locZip);
        hash = 17 * hash + Objects.hashCode(this.locLatitude);
        hash = 17 * hash + Objects.hashCode(this.locLongitude);
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
        final Location other = (Location) obj;
        if (this.locId != other.locId) {
            return false;
        }
        if (!Objects.equals(this.locName, other.locName)) {
            return false;
        }
        if (!Objects.equals(this.locDescription, other.locDescription)) {
            return false;
        }
        if (!Objects.equals(this.locAddress, other.locAddress)) {
            return false;
        }
        if (!Objects.equals(this.locCity, other.locCity)) {
            return false;
        }
        if (!Objects.equals(this.locState, other.locState)) {
            return false;
        }
        if (!Objects.equals(this.locZip, other.locZip)) {
            return false;
        }
        if (!Objects.equals(this.locLatitude, other.locLatitude)) {
            return false;
        }
        if (!Objects.equals(this.locLongitude, other.locLongitude)) {
            return false;
        }
        return true;
    }
    
    
}
