package com.codeforall.online.ecodebuddy.model.bin;

import com.codeforall.online.ecodebuddy.model.AbstractModel;
import com.codeforall.online.ecodebuddy.model.Code;
import com.codeforall.online.ecodebuddy.model.item.Item;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * A generic bin domain entity to be used as a base for concrete types of bins
 */
@Entity
@Table(name = "bins")
public abstract class Bin extends AbstractModel {

    private String color;
    private String description;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "bin",
            fetch = FetchType.EAGER
    )
    private Set<Item> items = new HashSet<>();

    @ManyToOne
    private Code code;

    /*
    protected Bin(String color) {
        this.color = color;
    }*/

    /**
     * Add an item to the bin items list
     * @param item the item to be added
     */
    public void addItem(Item item) {
        items.add(item);
        item.setBin(this);
    }

    /**
     * Remove given item from the items list
     * @param item the item to be removed
     */
    public void removeItem(Item item) {
        items.remove(item);
        item.setBin(null);
    }

    public abstract BinType getBinType();


    /**
     * Get bin's Color
     * @return the bin's color
     */
    public String getColor() {
        return color;
    }

    /**
     * Get bin's description
     * @return the bin's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the bin's description
     * @param description given
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * List all items
     * @return a set of items
     */
    public Set<Item> getItems() {
        return items;
    }

    /**
     * Set the item to the given items list
     * @param items given
     */
    public void setItems(Set<Item> items) {
        this.items = items;
    }

    /**
     * Set the bin's color
     * @param color to set
     */
    public void setColor(String color) {
        this.color = color;
    }
}
