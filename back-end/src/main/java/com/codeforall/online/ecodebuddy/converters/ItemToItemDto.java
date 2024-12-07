package com.codeforall.online.ecodebuddy.converters;

import com.codeforall.online.ecodebuddy.command.ItemDto;
import com.codeforall.online.ecodebuddy.model.item.Item;
import org.springframework.stereotype.Component;

/**
 * A concrete converter class that transforms an {@link Item} entity into an {@link ItemDto}
 */
@Component
public class ItemToItemDto extends AbstractConverter<Item, ItemDto> {

    /**
     * Convert an item into an itemDto
     * @param item to take the info out of
     * @return the itemDto
     */
    @Override
    public ItemDto convert(Item item) {

        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        itemDto.setReuseAndRecycling(item.getReuseAndRecycling());
        itemDto.setEnvironmentalImpact(item.getEnvironmentalImpact());

        return itemDto;
    }
}
