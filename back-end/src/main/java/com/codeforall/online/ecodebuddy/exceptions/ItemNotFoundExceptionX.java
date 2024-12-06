package com.codeforall.online.ecodebuddy.exceptions;

import com.codeforall.online.ecodebuddy.errors.ErrorMessage;

/**
 * Thrown to indicate that the item was not found
 */
public class ItemNotFoundExceptionX extends EcodebuddyException {

    /**
     * @see EcodebuddyException#EcodebuddyException(String)
     */
    public ItemNotFoundExceptionX() {
        super(ErrorMessage.ITEM_NOT_FOUND);
    }
}
