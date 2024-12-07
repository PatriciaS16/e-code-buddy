package com.codeforall.online.ecodebuddy.controllers;

import com.codeforall.online.ecodebuddy.command.ItemDto;
import com.codeforall.online.ecodebuddy.converters.ItemToItemDto;
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
import java.util.Set;

/**
 * A REST API Item Controller responsible for rendering {@link Item}
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/code")
public class RestItemController {

    BinService binService;
    ItemToItemDto itemToItemDto;

    @RequestMapping(method = RequestMethod.GET, path ={"/bin/{bid}/items", "/bin/{bid}/items/"})
    public ResponseEntity<List<ItemDto>> listBinItems(@PathVariable("bid") Integer bid) {

        try{
            Bin bin = binService.get(bid);

            List<ItemDto> itemDtos = itemToItemDto.convert(bin.getItems()
                    .stream()
                    .sorted(Comparator.comparingInt(Item::getId)).toList());

            return new ResponseEntity<>(itemDtos, HttpStatus.OK);
        } catch (BinNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    public void setBinService(BinService binService) {
        this.binService = binService;
    }

    @Autowired
    public void setItemToItemDto(ItemToItemDto itemToItemDto) {
        this.itemToItemDto = itemToItemDto;
    }
}
