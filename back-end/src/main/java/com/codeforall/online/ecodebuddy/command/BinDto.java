package com.codeforall.online.ecodebuddy.command;

import com.codeforall.online.ecodebuddy.model.bin.Bin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * A class which represent the data transfer object related to {@link Bin}
 */
public class BinDto {

    private Integer id;

    @NotNull(message = "Bin colo is mandatory")
    @NotBlank(message = "Bin colo is mandatory")
    @Size(min = 4, max = 20)
    private String color;

    @NotNull(message = "Bin description is mandatory")
    @NotBlank(message = "Bin description is mandatory")
    @Size(min = 3, max = 200)
    private String description;

    /**
     * Get the bin id
     * @return the bin id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the bin id
     * @param id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the bin color
     * @return the bin color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set the bin color
     * @param color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Get the bin description
     * @return the bin description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the bin description
     * @param description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
