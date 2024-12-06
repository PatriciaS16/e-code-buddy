package com.codeforall.online.ecodebuddy.command;

import com.codeforall.online.ecodebuddy.model.Code;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * A class which represents the data transfer object related to {@link Code}
 */
public class CodeDto {

    private Integer id;

    @NotNull(message = "Cod-e name is mandatory")
    @NotBlank(message = "Cod-e name is mandatory")
    @Size(min = 3, max = 64)
    private String name;

    /**
     * Get code id
     * @return the code id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the code id
     * @param id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the code name
     * @return the code name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the code name
     * @param name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
