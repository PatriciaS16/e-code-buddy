package com.codeforall.online.ecodebuddy.persistence.daos.jpa;

import com.codeforall.online.ecodebuddy.model.dialog.Dialog;
import com.codeforall.online.ecodebuddy.persistence.daos.DialogDao;
import org.springframework.stereotype.Repository;

/**
 * A JPA {@link DialogDao}
 */
@Repository
public class JpaDialogGenericDao extends JpaGenericDao<Dialog> implements DialogDao {

    /**
     * @see JpaGenericDao(Class)
     */
    public JpaDialogGenericDao() {
        super(Dialog.class);
    }
}
