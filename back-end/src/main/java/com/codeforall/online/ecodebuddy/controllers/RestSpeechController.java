package com.codeforall.online.ecodebuddy.controllers;

import com.codeforall.online.ecodebuddy.command.DialogDto;
import com.codeforall.online.ecodebuddy.converters.DialogToDialogDto;
import com.codeforall.online.ecodebuddy.exceptions.SpeechNotFoundException;
import com.codeforall.online.ecodebuddy.model.dialog.Dialog;
import com.codeforall.online.ecodebuddy.model.speech.Speech;
import com.codeforall.online.ecodebuddy.services.SpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Random;
import java.util.Set;

/**
 * A REST API Speech Controller responsible for rendering {@link Speech}
 */
@CrossOrigin(origins = "*", maxAge = 3600 )
@RestController
@RequestMapping("/api/code")
public class RestSpeechController {

    SpeechService speechService;
    DialogToDialogDto dialogToDialogDto;

    /**
     * Handles HTTP GET resquests to retrieve a random dialog associated with a specific speech.
     * @param sid the ID of the speech which dialog is to be retrieved
     * @return a {@link ResponseEntity} containing a random {@link DialogDto} object if the specific speech exists,
     * or a 404 (Not Found) status if the specific speech is not found, or a 204 (No content) if there is no dialog
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/speech/{sid}", "/speech/{sid}/"})
    public ResponseEntity<DialogDto> getWelcomeSpeech(@PathVariable("sid") Integer sid) {

        try {
            Speech speech = speechService.get(sid);

            Set<Dialog> dialogs = speech.getDialogs();
            if (dialogs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            int randomIndex = new Random().nextInt(dialogs.size());
            Dialog randomDialog = dialogs.stream()
                    .skip(randomIndex)
                    .findFirst()
                    .orElse(null);

            if (randomDialog == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            DialogDto dialogDto = dialogToDialogDto.convert(randomDialog);

            return new ResponseEntity<>(dialogDto, HttpStatus.OK);
        } catch (SpeechNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Set the speech service
     * @param speechService to set
     */
    @Autowired
    public void setSpeechService(SpeechService speechService) {
        this.speechService = speechService;
    }

    /**
     * Set the dialog to dialog dto converter
     * @param dialogToDialogDto to set
     */
    @Autowired
    public void setDialogToDialogDto(DialogToDialogDto dialogToDialogDto) {
        this.dialogToDialogDto = dialogToDialogDto;
    }


}
