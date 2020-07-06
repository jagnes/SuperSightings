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
public class Super {
    
    private int superId;
    private String superName;
    private String superDescription;
    private Power superpower;

    /**
     * @return the superId
     */
    public int getSuperId() {
        return superId;
    }

    /**
     * @param superId the superId to set
     */
    public void setSuperId(int superId) {
        this.superId = superId;
    }

    /**
     * @return the superName
     */
    public String getSuperName() {
        return superName;
    }

    /**
     * @param superName the superName to set
     */
    public void setSuperName(String superName) {
        this.superName = superName;
    }

    /**
     * @return the superDescription
     */
    public String getSuperDescription() {
        return superDescription;
    }

    /**
     * @param superDescription the superDescription to set
     */
    public void setSuperDescription(String superDescription) {
        this.superDescription = superDescription;
    }

    /**
     * @return the superpower
     */
    public Power getSuperpower() {
        return superpower;
    }

    /**
     * @param superpower the superpower to set
     */
    public void setSuperpower(Power superpower) {
        this.superpower = superpower;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.superId;
        hash = 97 * hash + Objects.hashCode(this.superName);
        hash = 97 * hash + Objects.hashCode(this.superDescription);
        hash = 97 * hash + Objects.hashCode(this.superpower);
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
        final Super other = (Super) obj;
        if (this.superId != other.superId) {
            return false;
        }
        if (!Objects.equals(this.superName, other.superName)) {
            return false;
        }
        if (!Objects.equals(this.superDescription, other.superDescription)) {
            return false;
        }
        if (!Objects.equals(this.superpower, other.superpower)) {
            return false;
        }
        return true;
    }
    
    
}
