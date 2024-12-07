package com.codeforall.online.ecodebuddy.model.item;

import com.codeforall.online.ecodebuddy.model.AbstractModel;
import com.codeforall.online.ecodebuddy.model.bin.Bin;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * A class which represents an item of the bins
 */
@Entity
@Table(name = "items")
public class Item extends AbstractModel {

    private String name;
    private String environmentalImpact;
    private String ReuseAndRecycling;
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
     * Get item's environmentalImpact
     * @return the item's environmentalImpact
     */
    public String getEnvironmentalImpact() {
        return environmentalImpact;
    }

    /**
     * Set item's environmentalImpact
     * @param environmentalImpact given
     */
    public void setEnvironmentalImpact(String environmentalImpact) {
        this.environmentalImpact = environmentalImpact;
    }

    /**
     * Get item's reuseAndRecycling
     * @return the imte's reuseAndRecycling
     */
    public String getReuseAndRecycling() {
        return ReuseAndRecycling;
    }

    /**
     * Set item's reuseAndRecycling
     * @param ReuseAndRecycling given
     */
    public void setReuseAndRecycling(String ReuseAndRecycling) {
        this.ReuseAndRecycling = ReuseAndRecycling;
    }
}

