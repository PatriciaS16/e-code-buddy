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

    private TransactionManager transactionManager;
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
     * @see ItemServiceX#delete(Integer)
     */
    @Override
    public void delete(Integer id) throws ItemNotFoundExceptionX {

        try{
            transactionManager.beginWrite();

            Item item = itemDao.findById(id);

            itemDao.delete(id);
            transactionManager.commit();
        } catch (PersistenceException e) {
            transactionManager.rollback();

        } finally {
            transactionManager.rollback();
        }
    }

    /**
     * Set the item data access object
     * @param itemDao the dialogDao to set
     */
    @Autowired
    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    /**
     * Set the transaction manager
     * @param transactionManager the transaction manager to set
     */
    @Autowired
    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
