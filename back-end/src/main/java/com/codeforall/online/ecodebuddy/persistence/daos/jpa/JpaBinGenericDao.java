package com.codeforall.online.ecodebuddy.persistence.daos.jpa;

import com.codeforall.online.ecodebuddy.model.bin.Bin;
import com.codeforall.online.ecodebuddy.persistence.daos.BinDao;
import org.springframework.stereotype.Repository;

/**
 * A JPA {@link BinDao} implementation
 */
@Repository
public class JpaBinGenericDao extends JpaGenericDao<Bin> implements BinDao {

    /**
     * @see JpaGenericDao(Class)
     */
    public JpaBinGenericDao() {
        super(Bin.class);
    }
}
