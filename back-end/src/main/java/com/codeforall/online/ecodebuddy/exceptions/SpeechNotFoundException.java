package com.codeforall.online.ecodebuddy.exceptions;

import com.codeforall.online.ecodebuddy.errors.ErrorMessage;

/**
 * Thrown to indicate that the bin was not found
 */
public class SpeechNotFoundException extends EcodebuddyException {

    /**
     * @see EcodebuddyException#EcodebuddyException(String)
     */
    public SpeechNotFoundException() {
        super(ErrorMessage.SPEECH_NOT_FOUND);
    }
}
