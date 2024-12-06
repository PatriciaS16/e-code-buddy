package com.codeforall.online.ecodebuddy.exceptions;

/**
 * A generic ecodebuddy exception to be used as base for concrete types of exceptions
 * @see Exception
 */
public class EcodebuddyException extends Exception {

    /**
     * @see Exception#Exception(String)
     */
    public EcodebuddyException(String message) {
        super(message);
    }
}
