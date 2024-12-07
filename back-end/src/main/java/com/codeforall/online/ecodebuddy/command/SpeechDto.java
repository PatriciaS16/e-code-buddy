package com.codeforall.online.ecodebuddy.command;

import com.codeforall.online.ecodebuddy.model.speech.Speech;
import com.codeforall.online.ecodebuddy.model.speech.SpeechType;
import jakarta.validation.constraints.NotNull;

/**
 * A class which represent the data transfer object related to {@link Speech}
 */
public class SpeechDto {

    private Integer id;

    @NotNull(message = "speech type is mandatory" )
    private SpeechType speechType;

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

    /**
     * Get the speech type
     * @return the speech type
     */
    public SpeechType getSpeechType() {
        return speechType;
    }

    /**
     * Set the speech type
     * @param speechType to set
     */
    public void setSpeechType(SpeechType speechType) {
        this.speechType = speechType;
    }
}
