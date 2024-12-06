package com.codeforall.online.ecodebuddy.services;

import com.codeforall.online.ecodebuddy.exceptions.DialogNotFoundException;
import com.codeforall.online.ecodebuddy.exceptions.TransactionInvalidException;
import com.codeforall.online.ecodebuddy.model.dialog.Dialog;

/**
 * Common interface for dialog services, provides Methods to manage dialogs
 */
public interface DialogService {

    Dialog add(Dialog dialog) throws TransactionInvalidException;

    Dialog get(int id) throws DialogNotFoundException;
}
