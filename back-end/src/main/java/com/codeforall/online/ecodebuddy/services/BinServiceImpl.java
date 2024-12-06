package com.codeforall.online.ecodebuddy.services;


import com.codeforall.online.ecodebuddy.exceptions.BinNotFoundException;
import com.codeforall.online.ecodebuddy.exceptions.ItemNotFoundExceptionX;
import com.codeforall.online.ecodebuddy.exceptions.TransactionInvalidException;
import com.codeforall.online.ecodebuddy.model.bin.Bin;
import com.codeforall.online.ecodebuddy.model.item.Item;
import com.codeforall.online.ecodebuddy.persistence.daos.BinDao;
import com.codeforall.online.ecodebuddy.persistence.daos.ItemDao;
import com.codeforall.online.ecodebuddy.persistence.managers.TransactionManager;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * An {@link BinService} implementation
 */
@Service
public class BinServiceImpl implements BinService {

    private TransactionManager transactionManager;
    private BinDao binDao;
    private ItemDao itemDao;
    private ItemServiceX itemService;

    /**
     * @see BinService#get(int) 
     */
    @Override
    public Bin get(int binId) throws BinNotFoundException {
        return Optional.ofNullable(binDao.findById(binId)).orElseThrow(BinNotFoundException::new);
    }

    /**
     * @see BinService#getAll() 
     */
    @Override
    public List<Bin> getAll() throws BinNotFoundException {

        return binDao.findAll();
    }

    /**
     * @see BinService#addItem(Integer, Item)
     */
    @Override
    public Item addItem(Integer binId, Item item) throws BinNotFoundException {
        Item newItem = null;

        try{
            transactionManager.beginWrite();
            Bin bin = get(binId);

            newItem = itemService.add(item);
            bin.addItem(newItem);

            binDao.saveOrUpdate(bin);
            transactionManager.commit();

        } catch (PersistenceException | TransactionInvalidException e){
            transactionManager.rollback();
        } finally {
            transactionManager.rollback();
        }
        return newItem;
    }

    /**
     * @see BinService#removeItem(Integer, Integer) 
     */
    @Override
    public void removeItem(Integer binId, Integer itemId) throws BinNotFoundException {

        try {
            transactionManager.beginWrite();

            Bin bin = get(binId);

            Item item = itemService.get(itemId);

            if (!(bin.getId() == binId)) {
                throw new BinNotFoundException();
            }

            bin.removeItem(item);

            binDao.saveOrUpdate(bin);
            transactionManager.commit();

        } catch (PersistenceException | ItemNotFoundExceptionX e) {
            transactionManager.rollback();
        } finally {
            transactionManager.rollback();
        }
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
     * Set the bin access data object
     * @param binDao the binDao to set
     */
    @Autowired
    public void setBinDao(BinDao binDao) {
        this.binDao = binDao;
    }

    /**
     * Set the transaction manager
     * @param transactionManager
     */
    @Autowired
    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * Set the item data access object
     * @param itemDao the itemDao to set
     */
    @Autowired
    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }
}
