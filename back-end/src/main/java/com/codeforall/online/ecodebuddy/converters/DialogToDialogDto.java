package com.codeforall.online.ecodebuddy.converters;

import com.codeforall.online.ecodebuddy.command.DialogDto;
import com.codeforall.online.ecodebuddy.command.SpeechDto;
import com.codeforall.online.ecodebuddy.model.dialog.Dialog;
import com.codeforall.online.ecodebuddy.model.speech.Speech;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


/**
 * A concrete converter class that transforms an {@link Dialog} entity into an {@link DialogDto}
 */
@Component
public class DialogToDialogDto extends AbstractConverter<Dialog, DialogDto> {


    @Override
    public DialogDto convert(Dialog dialog) {

        DialogDto dialogDto = new DialogDto();
        dialogDto.setId(dialog.getId());
        dialogDto.setText(dialog.getText());

        return dialogDto;
    }

}
