/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.dtos;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author jweez
 */
public class Sighting {
    
    private int sightingId;
    private Super superSighted;
    private Location locSighted;
    private Date sightingDate;

    /**
     * @return the sightingId
     */
    public int getSightingId() {
        return sightingId;
    }

    /**
     * @param sightingId the sightingId to set
     */
    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
    }

    /**
     * @return the superSighted
     */
    public Super getSuperSighted() {
        return superSighted;
    }

    /**
     * @param superSighted the superSighted to set
     */
    public void setSuperSighted(Super superSighted) {
        this.superSighted = superSighted;
    }

    /**
     * @return the locSighted
     */
    public Location getLocSighted() {
        return locSighted;
    }

    /**
     * @param locSighted the locSighted to set
     */
    public void setLocSighted(Location locSighted) {
        this.locSighted = locSighted;
    }

    /**
     * @return the sightingDate
     */
    public Date getSightingDate() {
        return sightingDate;
    }

    /**
     * @param sightingDate the sightingDate to set
     */
    public void setSightingDate(Date sightingDate) {
        this.sightingDate = sightingDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.sightingId;
        hash = 47 * hash + Objects.hashCode(this.superSighted);
        hash = 47 * hash + Objects.hashCode(this.locSighted);
        hash = 47 * hash + Objects.hashCode(this.sightingDate);
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
        final Sighting other = (Sighting) obj;
        if (this.sightingId != other.sightingId) {
            return false;
        }
        if (!Objects.equals(this.superSighted, other.superSighted)) {
            return false;
        }
        if (!Objects.equals(this.locSighted, other.locSighted)) {
            return false;
        }
        if (!Objects.equals(this.sightingDate, other.sightingDate)) {
            return false;
        }
        return true;
    }
    
    
}
