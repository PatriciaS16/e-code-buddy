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

    public void removeDialog(Dialog dialog) {
        dialogs.remove(dialog);
        dialog.setSpeech(null);
    }

    public abstract SpeechType getSpeechType();

    public Set<Dialog> getDialogs() {
        return dialogs;
    }

    public void setDialogs(Set<Dialog> dialogs) {
        this.dialogs = dialogs;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }
}
