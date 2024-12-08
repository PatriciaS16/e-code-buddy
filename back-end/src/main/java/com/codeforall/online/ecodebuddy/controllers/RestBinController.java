package com.codeforall.online.ecodebuddy.controllers;

import com.codeforall.online.ecodebuddy.command.BinDto;
import com.codeforall.online.ecodebuddy.command.ItemDto;
import com.codeforall.online.ecodebuddy.converters.BinToBinDto;
import com.codeforall.online.ecodebuddy.exceptions.BinNotFoundException;
import com.codeforall.online.ecodebuddy.model.bin.Bin;
import com.codeforall.online.ecodebuddy.model.item.Item;
import com.codeforall.online.ecodebuddy.services.BinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

/**
 * A REST API Bin Controller responsible for rendering {@link Bin}
 */
@CrossOrigin(origins= "*", maxAge = 3600)
@RestController
@RequestMapping("/api/code")
public class RestBinController {

    BinService binService;
    BinToBinDto binToBinDto;

    /**
     * Handles HTTP GET Requests to retrieve a specific bin
     * @param id the ID of the Bin to be retrieved
     * @return a {@link ResponseEntity} containing the {@link BinDto} object if the bin exists, or a 404 (Not Found) status
     * if the bin does not exist
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/bin/{id}", "/bin/{id}/"})
    public ResponseEntity<BinDto> getBin(@PathVariable Integer id) {
        try{
            Bin bin = binService.get(id);

            return new ResponseEntity<>(binToBinDto.convert(bin), HttpStatus.OK);
        } catch (BinNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     *  * Handles HTTP GET Requests to retrieve a list of all bins
     * @return a {@link ResponseEntity} containing the {@link BinDto} object if the items exist, or a 404 (Not Found) status
     * if the item does not exist
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/bin/wastehubdata", "/bin/wastehubdata/"})
    public ResponseEntity<List<BinDto>> listAllBins() {

        try {
            List<Bin> bins = binService.getAll();

            return new ResponseEntity<>(binToBinDto.convert(bins), HttpStatus.OK);
        } catch (BinNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Set the bin to bin dto converter
     * @param binToBinDto to set
     */
    @Autowired
    public void setBinToBinDto(BinToBinDto binToBinDto) {
        this.binToBinDto = binToBinDto;
    }

    /**
     * Set the bin service
     * @param binService to set
     */
    @Autowired
    public void setBinService(BinService binService) {
        this.binService = binService;
    }
}
