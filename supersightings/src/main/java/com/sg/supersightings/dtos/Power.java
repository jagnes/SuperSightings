/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.dtos;

import java.util.Objects;

/**
 *
 * @author jweez
 */
public class Power {
    
    private int powerId;
    private String powerName;
    private String powerDescription;

    /**
     * @return the powerId
     */
    public int getPowerId() {
        return powerId;
    }

    /**
     * @param powerId the powerId to set
     */
    public void setPowerId(int powerId) {
        this.powerId = powerId;
    }

    /**
     * @return the powerName
     */
    public String getPowerName() {
        return powerName;
    }

    /**
     * @param powerName the powerName to set
     */
    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    /**
     * @return the powerDescription
     */
    public String getPowerDescription() {
        return powerDescription;
    }

    /**
     * @param powerDescription the powerDescription to set
     */
    public void setPowerDescription(String powerDescription) {
        this.powerDescription = powerDescription;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.powerId;
        hash = 37 * hash + Objects.hashCode(this.powerName);
        hash = 37 * hash + Objects.hashCode(this.powerDescription);
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
        final Power other = (Power) obj;
        if (this.powerId != other.powerId) {
            return false;
        }
        if (!Objects.equals(this.powerName, other.powerName)) {
            return false;
        }
        if (!Objects.equals(this.powerDescription, other.powerDescription)) {
            return false;
        }
        return true;
    }
    
    
}
