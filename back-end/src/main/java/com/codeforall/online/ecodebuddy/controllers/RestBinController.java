package com.codeforall.online.ecodebuddy.controllers;

import com.codeforall.online.ecodebuddy.command.BinDto;
import com.codeforall.online.ecodebuddy.converters.BinToBinDto;
import com.codeforall.online.ecodebuddy.exceptions.BinNotFoundException;
import com.codeforall.online.ecodebuddy.model.bin.Bin;
import com.codeforall.online.ecodebuddy.services.BinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * A REST API Bin Controller responsible for rendering {@link Bin}
 */
@CrossOrigin(origins= "*", maxAge = 3600)
@RestController
@RequestMapping("/api/code")
public class RestBinController {

    BinService binService;
    BinToBinDto binToBinDto;

    @RequestMapping(method = RequestMethod.GET, path = {"/bin/{id}", "/bin/{id}/"})
    public ResponseEntity<BinDto> getBin(@PathVariable Integer id) {
        try{
            Bin bin = binService.get(id);

            return new ResponseEntity<>(binToBinDto.convert(bin), HttpStatus.OK);
        } catch (BinNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    public void setBinToBinDto(BinToBinDto binToBinDto) {
        this.binToBinDto = binToBinDto;
    }

    @Autowired
    public void setBinService(BinService binService) {
        this.binService = binService;
    }
}
