package com.codeforall.online.ecodebuddy.services;

import com.codeforall.online.ecodebuddy.exceptions.ItemNotFoundExceptionX;
import com.codeforall.online.ecodebuddy.exceptions.TransactionInvalidException;
import com.codeforall.online.ecodebuddy.model.item.Item;
import com.codeforall.online.ecodebuddy.persistence.daos.ItemDao;
import com.codeforall.online.ecodebuddy.persistence.managers.TransactionManager;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * An {@link ItemServiceX} implementation
 */
@Service
public class ItemServiceImpl implements ItemServiceX{

    private ItemDao itemDao;


    /**
     * @see ItemServiceX#add(Item)
     */
    @Override
    public Item add(Item item) throws TransactionInvalidException {
        return Optional.ofNullable(itemDao.saveOrUpdate(item)).orElseThrow(TransactionInvalidException::new);
    }

    /**
     * @see ItemServiceX#get(int)
     */
    @Override
    public Item get(int id) throws ItemNotFoundExceptionX {
        return Optional.ofNullable(itemDao.findById(id)).orElseThrow(ItemNotFoundExceptionX::new);
    }

    /**
     * Set the item data access object
     * @param itemDao the dialogDao to set
     */
    @Autowired
    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

}
