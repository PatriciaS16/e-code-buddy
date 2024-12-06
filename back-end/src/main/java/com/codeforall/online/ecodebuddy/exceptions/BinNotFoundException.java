package com.codeforall.online.ecodebuddy.exceptions;

import com.codeforall.online.ecodebuddy.errors.ErrorMessage;

/**
 * Thrown to indicate that the bin was not found
 */
public class BinNotFoundException extends EcodebuddyException {

    /**
     * @see EcodebuddyException#EcodebuddyException(String)
     */
    public BinNotFoundException() {
        super(ErrorMessage.BIN_NOT_FOUND);
    }
}
