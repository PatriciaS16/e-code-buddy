package com.codeforall.online.ecodebuddy.persistence.daos.jpa;

import com.codeforall.online.ecodebuddy.model.Code;
import com.codeforall.online.ecodebuddy.persistence.daos.CodeDao;
import org.springframework.stereotype.Repository;

/**
 * A JPA {@link CodeDao} implementation
 */
@Repository
public class JpaCodeGenericDao extends JpaGenericDao<Code> implements CodeDao {
    /**
     *@see JpaGenericDao(Class)
     */
    public JpaCodeGenericDao() {
        super(Code.class);
    }
}
