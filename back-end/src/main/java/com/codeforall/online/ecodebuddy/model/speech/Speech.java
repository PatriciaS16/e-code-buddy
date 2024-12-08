package com.codeforall.online.ecodebuddy.model.speech;

import com.codeforall.online.ecodebuddy.model.AbstractModel;
import com.codeforall.online.ecodebuddy.model.Code;
import com.codeforall.online.ecodebuddy.model.dialog.Dialog;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * A generic Speech entity to be used as a base for concrete types of speeches
 */
@Entity
@Table(name = "speeches" )
public abstract class Speech extends AbstractModel {

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "speech",
            fetch = FetchType.EAGER
    )
    private Set<Dialog> dialogs = new HashSet<>();
    @ManyToOne
    private Code code;


    /**
     * Add a dialog to the dialogs list
     * @param dialog the dialog to be added
     */
    public void addDialog(Dialog dialog) {
        dialogs.add(dialog);
        dialog.setSpeech(this);
    }

    /**
     * Remove givem dialog from the dialog list
     * @param dialog the dialog to be removed
     */
    public void removeDialog(Dialog dialog) {
        dialogs.remove(dialog);
        dialog.setSpeech(null);
    }

    /**
     * Get the speech type
     * @return the type of speech
     */
    public abstract SpeechType getSpeechType();

    /**
     * List all the dialogs
     * @return a set of dialogs
     */
    public Set<Dialog> getDialogs() {
        return dialogs;
    }

    /**
     * Set the dialog to the givem dialogs list
     * @param dialogs given
     */
    public void setDialogs(Set<Dialog> dialogs) {
        this.dialogs = dialogs;
    }

    /**
     * Get the speech Code
     * @return the speech code
     */
    public Code getCode() {
        return code;
    }

    /**
     * Set the speech code
     * @param code to set
     */
    public void setCode(Code code) {
        this.code = code;
    }
}
