package com.codeforall.online.ecodebuddy.services;

import com.codeforall.online.ecodebuddy.exceptions.BinNotFoundException;
import com.codeforall.online.ecodebuddy.model.bin.Bin;
import com.codeforall.online.ecodebuddy.model.item.Item;

import java.util.List;

/**
 * Common interface for bin services, provides methods to manage bins
 */
public interface BinService {

    /**
     * Get the bin with given binId
     * @param binId
     * @return the bin
     * @throws BinNotFoundException when the bin does not exist
     */
    Bin get(int binId) throws BinNotFoundException;

    /**
     * List all bins
     * @return a list of bins
     * @throws BinNotFoundException
     */
    List<Bin> getAll() throws BinNotFoundException;

    /**
     * Add given item to the bin
     * @param binId
     * @param item the item to be added
     * @throws BinNotFoundException
     */
    Item addItem(Integer binId, Item item) throws BinNotFoundException;

    /**
     * Removes item from the bin
     * @param binId
     * @param itemId
     * @throws BinNotFoundException
     */
    void removeItem(Integer binId, Integer itemId) throws BinNotFoundException;


}
