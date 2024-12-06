package com.codeforall.online.ecodebuddy.services;

import com.codeforall.online.ecodebuddy.exceptions.CodeNotFoundException;
import com.codeforall.online.ecodebuddy.model.Code;
import com.codeforall.online.ecodebuddy.persistence.daos.CodeDao;
import com.codeforall.online.ecodebuddy.persistence.managers.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * An {@link CodeService} implementation
 */
@Service
public class CodeServiceImpl implements CodeService {

    private TransactionManager transactionManager;
    private CodeDao codeDao;


    /**
     * @see CodeService#get(int)
     */
    @Override
    public Code get(int codeId) throws CodeNotFoundException {
        return Optional.ofNullable(codeDao.findById(codeId)).orElseThrow(CodeNotFoundException::new);
    }

    /**
     * Set the Code data access object
     * @param codeDao the codeDao to set
     */
    @Autowired
    public void setCodeDao(CodeDao codeDao) {
        this.codeDao = codeDao;
    }

    @Autowired
    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
