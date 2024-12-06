package com.codeforall.online.ecodebuddy.exceptions;

import com.codeforall.online.ecodebuddy.errors.ErrorMessage;

/**
 * Thrown to indicate that the dialog was not found
 */
public class DialogNotFoundException extends EcodebuddyException {

    public DialogNotFoundException() {
        super(ErrorMessage.DIALOG_NOT_FOUND);
    }
}
