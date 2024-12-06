package com.codeforall.online.ecodebuddy.services;

import com.codeforall.online.ecodebuddy.exceptions.ItemNotFoundExceptionX;
import com.codeforall.online.ecodebuddy.exceptions.TransactionInvalidException;
import com.codeforall.online.ecodebuddy.model.item.Item;

/**
 * Common interface for item services, provides methods to manage items
 */
public interface ItemServiceX {

    /**
     * Add given item
     * @param item
     * @throws TransactionInvalidException
     */
    Item add(Item item) throws TransactionInvalidException;

    Item get(int id) throws ItemNotFoundExceptionX;
}
