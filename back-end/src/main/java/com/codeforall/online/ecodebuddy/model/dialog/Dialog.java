package com.codeforall.online.ecodebuddy.model.dialog;

import com.codeforall.online.ecodebuddy.model.AbstractModel;
import com.codeforall.online.ecodebuddy.model.speech.Speech;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * A class which represents dialog of the Cod-e
 */
@Entity
@Table(name = "dialogs")
public class Dialog extends AbstractModel {

    private String text;
    @ManyToOne
    private Speech speech;

    /**
     * Get dialog's text
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * Set dialog's text
     * @param text given
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get the speech to which the dialog is associated with
     * @return bin
     */
    public Speech getSpeech() {
        return speech;
    }

    /**
     * Set the speech to the dialog
     * @param speech
     */
    public void setSpeech(Speech speech) {
        this.speech = speech;
    }
}
