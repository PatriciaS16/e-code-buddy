package com.codeforall.online.ecodebuddy.command;

import com.codeforall.online.ecodebuddy.model.item.Item;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

/**
 * A class which represents the data transfer object related to {@link Item}
 */
public class ItemDto {

    private Integer id;
    @NotNull(message = "Item name is mandatory")
    @NotBlank(message = "Item name is mandatory")
    @Size(min = 3, max = 40)
    private String name;

    @NotNull(message = "Item environmental impact is mandatory")
    @NotBlank(message = "Item denvironmental impact is mandatory")
    @Size(min = 3, max = 200)
    private String environmentalImpact;

    @NotNull(message = "Item reuse and recycling is mandatory")
    @NotBlank(message = "Item reuse and recycling is mandatory")
    @Size(min = 3, max = 200)
    private String ReuseAndRecycling;

    /**
     * Get the item id
     * @return the item id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the item id
     * @param id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the item name
     * @return the item name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the item name
     * @param name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the item environmentalImpact
     * @return the environmentalImpact
     */
    public String getEnvironmentalImpact() {
        return environmentalImpact;
    }

    /**
     * set the environmentalImpact
     * @param environmentalImpact to set
     */
    public void setEnvironmentalImpact(String environmentalImpact) {
        this.environmentalImpact = environmentalImpact;
    }

    /**
     * set the reuseAndRecycling
     * @return the reuseAndRecycling
     */
    public String getReuseAndRecycling() {
        return ReuseAndRecycling;
    }

    /**
     * set the reuseAndRecycling
     * @param reuseAndRecycling to set
     */
    public void setReuseAndRecycling(String reuseAndRecycling) {
        ReuseAndRecycling = reuseAndRecycling;
    }
}
