package com.codeforall.online.ecodebuddy.controllers;

import com.codeforall.online.ecodebuddy.command.CodeDto;
import com.codeforall.online.ecodebuddy.converters.CodeToCodeDto;
import com.codeforall.online.ecodebuddy.exceptions.CodeNotFoundException;
import com.codeforall.online.ecodebuddy.model.Code;
import com.codeforall.online.ecodebuddy.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * A REST API Code Controller responsible for rendering {@link Code}  related views
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/code")
public class RestCodeController {

    private CodeService codeService;
    private BinService binService;
    private ItemServiceX itemServiceX;
    private SpeechService speechService;
    private DialogService dialogService;
    private CodeDto codeDto;
    private CodeToCodeDto codeToCodeDto;

    //Add DTOS
    //produces = MediaType.APPLICATION_JSON_VALUE,

    @RequestMapping(method = RequestMethod.GET, path = {"/",""})
    public ResponseEntity<CodeDto> getCode() {

        try{
            return new ResponseEntity<>(codeToCodeDto.convert(codeService.get(4)), HttpStatus.OK);
        } catch (CodeNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.GET, path = {"/test"})
    public ResponseEntity<String> getTest() {

            return new ResponseEntity<>("HELLLOOO", HttpStatus.OK);
    }

    @Autowired
    public void setCodeToCodeDto(CodeToCodeDto codeToCodeDto) {
        this.codeToCodeDto = codeToCodeDto;
    }

    @Autowired
    public void setCodeService(CodeService codeService) {
        this.codeService = codeService;
    }
}


