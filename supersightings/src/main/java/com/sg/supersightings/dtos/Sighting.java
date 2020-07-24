/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.supersightings.dtos;

import java.util.Date;
import java.util.Objects;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author jweez
 */
public class Sighting {
    
    private int sightingId;
    
    @NotNull(message = "Super cannot be blank")
    private Super superSighted;
    
    @NotNull(message = "Location cannot be blank")
    private Location locSighted;
    
    @NotNull(message = "Date cannot be blank")
    @PastOrPresent(message = "Date cannot be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sightingDate;

    public Sighting(int sightingId, Super superSighted, Location locSighted, Date sightingDate) {
        this.sightingId = sightingId;
        this.superSighted = superSighted;
        this.locSighted = locSighted;
        this.sightingDate = sightingDate;
    }
    
    public Sighting() {
        
    }
    
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
