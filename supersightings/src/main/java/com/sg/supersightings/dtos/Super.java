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
    private int powerId;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.superId;
        hash = 59 * hash + Objects.hashCode(this.superName);
        hash = 59 * hash + Objects.hashCode(this.superDescription);
        hash = 59 * hash + this.powerId;
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
        if (this.powerId != other.powerId) {
            return false;
        }
        if (!Objects.equals(this.superName, other.superName)) {
            return false;
        }
        if (!Objects.equals(this.superDescription, other.superDescription)) {
            return false;
        }
        return true;
    }
}
