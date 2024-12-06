package com.codeforall.online.ecodebuddy.command;

import com.codeforall.online.ecodebuddy.model.dialog.Dialog;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * A class which represents the data transfer object related to {@link Dialog}
 */
public class DialogDto {

    private Integer id;

    @NotNull(message = "Dialog text is mandatory")
    @NotBlank(message = "Dialog text is mandatory")
    @Size(min = 3, max = 300)
    private String text;

    /**
     * Get dialog text
     * @return the dialog text
     */
    public String getText() {
        return text;
    }

    /**
     * Set dialog text
     * @param text to set
     */
    public void setText( String text) {
        this.text = text;
    }

    /**
     * Get dialog id
     * @return the dialog id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set dialog Id
     * @param id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
}
