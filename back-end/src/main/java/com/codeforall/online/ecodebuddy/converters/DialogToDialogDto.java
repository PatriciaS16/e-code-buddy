package com.codeforall.online.ecodebuddy.converters;

import com.codeforall.online.ecodebuddy.command.DialogDto;
import com.codeforall.online.ecodebuddy.model.dialog.Dialog;
import org.springframework.stereotype.Component;


/**
 * A concrete converter class that transforms an {@link Dialog} entity into an {@link DialogDto}
 */
@Component
public class DialogToDialogDto extends AbstractConverter<Dialog, DialogDto> {

    /**
     * Convert a dialog into a dialogDto
     * @param dialog to take the info out of
     * @return the dialogDto
     */
    @Override
    public DialogDto convert(Dialog dialog) {

        DialogDto dialogDto = new DialogDto();
        dialogDto.setId(dialog.getId());
        dialogDto.setText(dialog.getText());

        return dialogDto;
    }

}
