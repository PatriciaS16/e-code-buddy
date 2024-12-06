package com.codeforall.online.ecodebuddy.model.speech;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * A dialog list for suggestion speech
 */
@Entity
@DiscriminatorValue("SUGGESTION")
public class SuggestionSpeech extends Speech {

    /**
     * @see Speech#getSpeechType()
     * @return
     */
    @Override
    public SpeechType getSpeechType() {
        return SpeechType.SUGGESTION;
    }
}
