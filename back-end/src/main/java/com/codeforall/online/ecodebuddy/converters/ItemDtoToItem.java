package com.codeforall.online.ecodebuddy.converters;

import com.codeforall.online.ecodebuddy.command.ItemDto;
import com.codeforall.online.ecodebuddy.exceptions.ItemNotFoundExceptionX;
import com.codeforall.online.ecodebuddy.model.item.Item;
import com.codeforall.online.ecodebuddy.services.ItemServiceX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A converter class which converts {@link ItemDto} objects into {@link Item} objects
 */
@Component
public class ItemDtoToItem {

    private ItemServiceX itemService;

    public Item convert(ItemDto itemDto) throws ItemNotFoundExceptionX {

        Item item = (itemDto.getId() != null ? itemService.get(itemDto.getId()) : new Item());

        item.setName(itemDto.getName());
        item.setEnvironmentalImpact(itemDto.getEnvironmentalImpact());
        item.setReuseAndRecycling(itemDto.getReuseAndRecycling());

        return item;
    }

    @Autowired
    public void setItemService(ItemServiceX itemService) {
        this.itemService = itemService;
    }

}
