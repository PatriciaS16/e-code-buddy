package com.codeforall.online.ecodebuddy.model.item;

import com.codeforall.online.ecodebuddy.model.AbstractModel;
import com.codeforall.online.ecodebuddy.model.bin.Bin;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

/**
 * A class which represents an item of the bins
 */
@Entity
@Table(name = "items")
public class Item extends AbstractModel {

    private String name;
    private String description;
    private int environmentalImpact;
    @ManyToOne
    private Bin bin;

    /**
     * Get item's name
     * @return the item's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set item's name
     * @param name given
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the bin to which the item is associated with
     * @return bin
     */
    public Bin getBin() {
        return bin;
    }

    /**
     * Set the bin to the item
     * @param bin
     */
    public void setBin(Bin bin) {
        this.bin = bin;
    }
    /**
     * Get item's description
     * @return the item's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set item's name
     * @param description given
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get item's environmentalImpact
     * @return the item's environmentalImpact
     */
    public int getEnvironmentalImpact() {
        return environmentalImpact;
    }

    /**
     * Set item's environmentalImpact
     * @param environmentalImpact given
     */
    public void setEnvironmentalImpact(int environmentalImpact) {
        this.environmentalImpact = environmentalImpact;
    }
}

