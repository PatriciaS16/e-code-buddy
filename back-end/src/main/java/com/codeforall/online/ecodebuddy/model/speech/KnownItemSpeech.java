package com.codeforall.online.ecodebuddy.model.speech;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * A dialog list for known item speech
 */
@Entity
@DiscriminatorValue("KNOWN_ITEM")
public class KnownItemSpeech extends Speech {

    /**
     * @see Speech#getSpeechType()
     * @return
     */
    @Override
    public SpeechType getSpeechType() {
        return SpeechType.KNOWN_ITEM;
    }
}
