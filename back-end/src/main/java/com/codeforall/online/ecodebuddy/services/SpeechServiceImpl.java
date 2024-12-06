package com.codeforall.online.ecodebuddy.services;

import com.codeforall.online.ecodebuddy.exceptions.DialogNotFoundException;
import com.codeforall.online.ecodebuddy.exceptions.SpeechNotFoundException;
import com.codeforall.online.ecodebuddy.exceptions.TransactionInvalidException;
import com.codeforall.online.ecodebuddy.model.dialog.Dialog;
import com.codeforall.online.ecodebuddy.model.speech.Speech;
import com.codeforall.online.ecodebuddy.persistence.daos.SpeechDao;
import com.codeforall.online.ecodebuddy.persistence.managers.TransactionManager;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * An {@link SpeechService} implementation
 */
@Service
public class SpeechServiceImpl implements SpeechService {

    private TransactionManager transactionManager;
    private SpeechDao speechDao;
    private DialogService dialogService;

    /**
     * @see SpeechService#get(int)
     */
    @Override
    public Speech get(int speechId) throws SpeechNotFoundException {
        return Optional.ofNullable(speechDao.findById(speechId)).orElseThrow(SpeechNotFoundException::new);
    }

    /**
     * @see SpeechService#getAll()
     */
    @Override
    public List<Speech> getAll() throws SpeechNotFoundException {
        return speechDao.findAll();
    }

    /**
     * @see SpeechService#addDialog(Integer, Dialog)
     */
    @Override
    public Dialog addDialog(Integer speechId, Dialog dialog) throws SpeechNotFoundException {
        Dialog newDialog = null;

        try{
            transactionManager.beginWrite();
            Speech speech = get(speechId);

            newDialog = dialogService.add(dialog);
            speech.addDialog(newDialog);

            speechDao.saveOrUpdate(speech);
            transactionManager.commit();
        } catch (PersistenceException | TransactionInvalidException e) {
            transactionManager.rollback();
        } finally {
            transactionManager.rollback();
        }

        return newDialog;
    }

    /**
     * @see SpeechService#removeDialog(Integer, Integer)

     */
    @Override
    public void removeDialog(Integer speechId, Integer dialogId) throws SpeechNotFoundException {

        try{
            transactionManager.beginWrite();

            Speech speech = get(speechId);

            Dialog dialog = dialogService.get(dialogId);

            if(!(speech.getId() == dialogId)){
                throw new SpeechNotFoundException();
            }
            speech.removeDialog(dialog);

            speechDao.saveOrUpdate(speech);
            transactionManager.commit();
        } catch (PersistenceException | DialogNotFoundException e){
            transactionManager.rollback();
        } finally {
            transactionManager.rollback();
        }
    }

    /**
     * Set the transaction manager
     * @param transactionManager
     */
    @Autowired
    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * Set the speech data access object
     * @param speechDao the speechDao to set
     */
    @Autowired
    public void setSpeechDao(SpeechDao speechDao) {
        this.speechDao = speechDao;
    }

    /**
     * Set the dialog service
     * @param dialogService to set
     */
    @Autowired
    public void setDialogService(DialogService dialogService) {
        this.dialogService = dialogService;
    }
}
