package com.codeforall.online.ecodebuddy.services;

import com.codeforall.online.ecodebuddy.exceptions.DialogNotFoundException;
import com.codeforall.online.ecodebuddy.exceptions.TransactionInvalidException;
import com.codeforall.online.ecodebuddy.model.dialog.Dialog;
import com.codeforall.online.ecodebuddy.persistence.daos.DialogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * An {@link DialogService} implementation
 */
@Service
public class DialogServiceImpl implements DialogService {

    private DialogDao dialogDao;

    /**
     * @see DialogService#add(Dialog)
     */
    @Override
    public Dialog add(Dialog dialog) throws TransactionInvalidException {
        return Optional.ofNullable(dialogDao.saveOrUpdate(dialog)).orElseThrow(TransactionInvalidException::new);
    }

    /**
     * @see DialogService#get(int)
     */
    @Override
    public Dialog get(int id) throws DialogNotFoundException {
        return Optional.ofNullable(dialogDao.findById(id)).orElseThrow(DialogNotFoundException::new);
    }

    /**
     * Set the dialog data access object
     * @param dialogDao the dialogDao to set
     */
    @Autowired
    public void setDialogDao(DialogDao dialogDao) {
        this.dialogDao = dialogDao;
    }
}
