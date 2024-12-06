package com.codeforall.online.ecodebuddy.persistence.daos.jpa;

import com.codeforall.online.ecodebuddy.model.item.Item;
import com.codeforall.online.ecodebuddy.persistence.daos.ItemDao;
import org.springframework.stereotype.Repository;

/**
 * A JPA {@link ItemDao} implementation
 */
@Repository
public class JpaItemGenericDao extends JpaGenericDao<Item> implements ItemDao {

    /**
     * @see JpaGenericDao(Class)
     */
    public JpaItemGenericDao() {
        super(Item.class);
    }
}
