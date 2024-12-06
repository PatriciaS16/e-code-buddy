package com.codeforall.online.ecodebuddy.command;

import com.codeforall.online.ecodebuddy.model.speech.Speech;

/**
 * A class which represent the data transfer object related to {@link Speech}
 */
public class SpeechDto {

    private Integer id;

    /**
     * Get the speech id
     * @return the speech id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the speech id
     * @param id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
}
