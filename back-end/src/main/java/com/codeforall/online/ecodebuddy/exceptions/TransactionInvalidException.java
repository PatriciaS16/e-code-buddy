package com.codeforall.online.ecodebuddy.exceptions;

import com.codeforall.online.ecodebuddy.errors.ErrorMessage;

/**
 * Thrown to indicate that the transaction was not valid
 */
public class TransactionInvalidException extends EcodebuddyException {

    /**
     * @see EcodebuddyException#EcodebuddyException(String)
     */
    public TransactionInvalidException() {
        super(ErrorMessage.TRANSACTION_INVALID);
    }
}
