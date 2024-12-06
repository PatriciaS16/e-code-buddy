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

    @NotNull(message = "Item description is mandatory")
    @NotBlank(message = "Item description is mandatory")
    @Size(min = 3, max = 200)
    private String description;

    @NumberFormat
    @Min(value = 1, message = "Minimum environmental impact must be 1")
    @Max(value = 5, message = "Maximum environmental impact must b 5")
    @NotNull(message = "Item environmental impact is mandatory")
    private int environmentalImpact;

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
     * Get the item description
     * @return the item description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the item description
     * @param description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the item environmentalImpact
     * @return the environmentalImpact
     */
    public int getEnvironmentalImpact() {
        return environmentalImpact;
    }

    /**
     * set the environmentalImpact
     * @param environmentalImpact to set
     */
    public void setEnvironmentalImpact(int environmentalImpact) {
        this.environmentalImpact = environmentalImpact;
    }
}
