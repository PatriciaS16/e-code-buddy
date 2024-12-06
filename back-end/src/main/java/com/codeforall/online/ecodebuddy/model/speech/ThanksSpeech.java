package com.codeforall.online.ecodebuddy.model.speech;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * A dialog list for thanks speech
 */
@Entity
@DiscriminatorValue("THANKS")
public class ThanksSpeech extends Speech {

    /**
     * @see Speech#getSpeechType()
     * @return
     */
    @Override
    public SpeechType getSpeechType() {
        return SpeechType.THANKS;
    }
}
