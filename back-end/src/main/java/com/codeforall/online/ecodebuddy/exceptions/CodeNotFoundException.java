package com.codeforall.online.ecodebuddy.exceptions;

import com.codeforall.online.ecodebuddy.errors.ErrorMessage;

/**
 * Thrown to indicate thate the class code was not found
 */
public class CodeNotFoundException extends EcodebuddyException {

    /**
     * @see EcodebuddyException#EcodebuddyException(String)
     */
    public CodeNotFoundException() {
        super(ErrorMessage.CODE_NOT_FOUND);
    }
}
