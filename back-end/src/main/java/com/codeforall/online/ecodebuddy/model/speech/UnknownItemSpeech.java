package com.codeforall.online.ecodebuddy.model.speech;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * A dialog list for unknown item speech
 */
@Entity
@DiscriminatorValue("UNKNOWN_ITEM")
public class UnknownItemSpeech extends Speech {

    /**
     * @see Speech#getSpeechType()
     * @return
     */
    @Override
    public SpeechType getSpeechType() {
        return SpeechType.UNKNOWN_ITEM;
    }
}
