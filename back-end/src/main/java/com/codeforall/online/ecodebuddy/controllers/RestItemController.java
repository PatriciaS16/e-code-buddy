package com.codeforall.online.ecodebuddy.controllers;

import com.codeforall.online.ecodebuddy.command.BinDto;
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

    /**
     * Handles HTTP GET Requests to retrieve a list of items associated with a specific bin
     * @param bid the ID of the Bin whose items are to be retrieved
     * @return a {@link ResponseEntity} containing the {@link ItemDto} object if the bin exists, or a 404 (Not Found) status
     * if the bin does not exist
     */
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

    /**
     *  * Handles HTTP GET Requests to retrieve a list of all items
     * @return a {@link ResponseEntity} containing the {@link ItemDto} object if the items exist, or a 404 (Not Found) status
     * if the item does not exist
     */
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

    /**
     * Handles HTTP GET Requests to retrieve a list of items associated with a specific bin
     * @param bid the ID of the Bin whose items are to be retrieved
     * @return a {@link ResponseEntity} containing the {@link ItemDto} object if the bin exists, or a 404 (Not Found) status
     * if the bin does not exist
     */
    /**
     * Handles HTTP GET Requests to retrieve a specific item associated with a specific bin
     * @param bid the id of the bin which item is to be retrieved
     * @param iid the id of the item to be retrieved
     * @return a {@link ResponseEntity} containing the {@link ItemDto} object if the item exists and is associated with the specific bin
     * or a 404 (Not Found) status if the item does not exist, or if the bin does not exist. or a 400 (Bad Request) with
     * the item is not associated with the specific bin
     */
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

    /**
     * Handles HTTP POST requests to create a new item associated with a specific bin
     * @param bid id of the bin to which the item should be associated
     * @param itemDto the {@link ItemDto} object containing the details of the item to be created
     * @param bindingResult holds validation results for the {@code itemDto}
     * @param uriComponentsBuilder used to construct the URI of the newly created item
     * @return a {@link ResponseEntity} with a {@code Location} header pointing to the URI of the newly created item
     * and a 201 (Created) status if the recipient is sucessfully created, or a 400 (Bad Request) status if the request
     * is invalid, or a 404 (Not Found) status if the specified bin or item does not exist
     */
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

    /**
     * Handles HTTP DELETE Requests to remove a specific item associated with a given bin
     * @param bid the ID of the bin associated with the item to be deleted
     * @param iid the ID of the item to be deleted
     * @return a {@link ResponseEntity} with a 204 (No Content) status if the recipient is successfully deleted,
     * or a 404 (Not Found) status if the item or bin does not exist
     */
    @RequestMapping(method = RequestMethod.DELETE, path = {"/bin/{bid}/item/{iid}", "/bin/{bid}/item/{iid}/"} )
    public ResponseEntity<?> deleteItem(@PathVariable Integer bid, @PathVariable Integer iid) {

        try{
            binService.removeItem(bid, iid);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (BinNotFoundException e ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    /**
     * Set the bin service
     * @param binService to set
     */
    @Autowired
    public void setBinService(BinService binService) {
        this.binService = binService;
    }

    /**
     * Set the item service
     * @param itemService to set
     */
    @Autowired
    public void setItemService(ItemServiceX itemService) {
        this.itemService = itemService;
    }

    /**
     * Set the item to item dto converter
     * @param itemToItemDto to set
     */
    @Autowired
    public void setItemToItemDto(ItemToItemDto itemToItemDto) {
        this.itemToItemDto = itemToItemDto;
    }

    /**
     * Set the item dto to item converter
     * @param itemDtoToItem to set
     */
    @Autowired
    public void setItemDtoToItem(ItemDtoToItem itemDtoToItem) {
        this.itemDtoToItem = itemDtoToItem;
    }
}
