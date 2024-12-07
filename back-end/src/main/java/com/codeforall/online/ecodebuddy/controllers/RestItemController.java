package com.codeforall.online.ecodebuddy.controllers;

import com.codeforall.online.ecodebuddy.command.ItemDto;
import com.codeforall.online.ecodebuddy.converters.ItemDtoToItem;
import com.codeforall.online.ecodebuddy.converters.ItemToItemDto;
import com.codeforall.online.ecodebuddy.exceptions.BinNotFoundException;
import com.codeforall.online.ecodebuddy.exceptions.ItemNotFoundExceptionX;
import com.codeforall.online.ecodebuddy.model.bin.Bin;
import com.codeforall.online.ecodebuddy.model.item.Item;
import com.codeforall.online.ecodebuddy.services.BinService;
import com.codeforall.online.ecodebuddy.services.ItemServiceX;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Comparator;
import java.util.List;

/**
 * A REST API Item Controller responsible for rendering {@link Item}
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/code")
public class RestItemController {

    BinService binService;
    ItemServiceX itemService;
    ItemToItemDto itemToItemDto;
    ItemDtoToItem itemDtoToItem;

    @RequestMapping(method = RequestMethod.GET, path = {"/bin/{bid}/items", "/bin/{bid}/items/"})
    public ResponseEntity<List<ItemDto>> listBinItems(@PathVariable("bid") Integer bid) {

        try {
            Bin bin = binService.get(bid);

            List<ItemDto> itemDtos = itemToItemDto.convert(bin.getItems()
                    .stream()
                    .sorted(Comparator.comparingInt(Item::getId)).toList());

            return new ResponseEntity<>(itemDtos, HttpStatus.OK);
        } catch (BinNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/bin/wastehub", "/bin/wastehub/"})
    public ResponseEntity<List<ItemDto>> listAllItems() {

        try {
        List<Bin> bins = binService.getAll();

        List<ItemDto> itemDtos = bins.stream()
                .flatMap(bin -> bin.getItems().stream())
                .sorted(Comparator.comparingInt(Item::getId))
                .map(itemToItemDto::convert)
                .toList();

        return new ResponseEntity<>(itemDtos, HttpStatus.OK);
    } catch (BinNotFoundException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

    @RequestMapping(method = RequestMethod.GET, path = {"/bin/{bid}/item/{iid}", "/bin/{bid}/item/{iid}/"})
    public ResponseEntity<ItemDto> getItem(@PathVariable Integer bid, @PathVariable Integer iid) {

        try{
            Item item = itemService.get(iid);

            Bin bin = binService.get(bid);

            if(!item.getBin().equals(bin)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(itemToItemDto.convert(item), HttpStatus.OK);
        } catch (ItemNotFoundExceptionX  | BinNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @RequestMapping(method = RequestMethod.POST, path = {"/bin/{bid}/add", "/bin/{bid}/add/"})
    public ResponseEntity<ItemDto> addItem(@PathVariable("bid") Integer bid, @Valid @RequestBody ItemDto itemDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        try{
            if(bindingResult.hasErrors()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Bin bin = binService.get(bid);
            if (bin == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Item item = binService.addItem(bid, itemDtoToItem.convert(itemDto));

            UriComponents uriComponents = uriComponentsBuilder.path("/api/code/bin" + bid + "/item/" + item.getId() ).build();
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(uriComponents.toUri());

            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        } catch (ItemNotFoundExceptionX | BinNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }




    @Autowired
    public void setBinService(BinService binService) {
        this.binService = binService;
    }

    @Autowired
    public void setItemService(ItemServiceX itemService) {
        this.itemService = itemService;
    }

    @Autowired
    public void setItemToItemDto(ItemToItemDto itemToItemDto) {
        this.itemToItemDto = itemToItemDto;
    }

    @Autowired
    public void setItemDtoToItem(ItemDtoToItem itemDtoToItem) {
        this.itemDtoToItem = itemDtoToItem;
    }
}
