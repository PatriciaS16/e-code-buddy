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

    /**
     * Get the customer with the given id
     * @param id the item id
     * @return the item
     * @throws ItemNotFoundExceptionX
     */
    Item get(int id) throws ItemNotFoundExceptionX;

    /**
     * Delete a item
     * @param id of the item to delete
     * @throws ItemNotFoundExceptionX if the item doesn't exist
     */
    void delete(Integer id) throws ItemNotFoundExceptionX;
}
