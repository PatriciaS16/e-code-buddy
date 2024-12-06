package com.codeforall.online.ecodebuddy.services;

import com.codeforall.online.ecodebuddy.exceptions.SpeechNotFoundException;
import com.codeforall.online.ecodebuddy.model.dialog.Dialog;
import com.codeforall.online.ecodebuddy.model.speech.Speech;

import java.util.List;

/**
 * Common interface for speech services
 */
public interface SpeechService {

    /**
     * Get the speech with given speechId
     * @param speechId
     * @return the speech
     * @throws SpeechNotFoundException when the speech does not exist
     */
    Speech get(int speechId) throws SpeechNotFoundException;

    /**
     * List all speeches
     * @return a list of speeches
     * @throws SpeechNotFoundException
     */
    List<Speech> getAll() throws SpeechNotFoundException;

    /**
     * Add given dialog to the speech
     * @param speechId
     * @param dialog the dialog to be added
     * @throws SpeechNotFoundException
     */
    Dialog addDialog(Integer speechId, Dialog dialog) throws SpeechNotFoundException;

    /**
     * Removes dialog from the speech
     * @param speechId
     * @param dialogId
     * @throws SpeechNotFoundException
     */
    void removeDialog(Integer speechId, Integer dialogId) throws SpeechNotFoundException;
}
