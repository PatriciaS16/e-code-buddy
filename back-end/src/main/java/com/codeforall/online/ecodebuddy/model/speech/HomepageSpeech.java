package com.codeforall.online.ecodebuddy.model.speech;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * A dialog list for homepage speech
 */
@Entity
@DiscriminatorValue("HOMEPAGE")
public class HomepageSpeech extends Speech {

    /**
     * @see Speech#getSpeechType()
     * @return
     */
    @Override
    public SpeechType getSpeechType() {
        return SpeechType.HOMEPAGE;
    }
}
