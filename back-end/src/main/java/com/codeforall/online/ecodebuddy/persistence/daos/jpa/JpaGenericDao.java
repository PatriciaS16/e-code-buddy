package com.codeforall.online.ecodebuddy.persistence.daos.jpa;

import com.codeforall.online.ecodebuddy.model.Model;
import com.codeforall.online.ecodebuddy.persistence.daos.Dao;
import com.codeforall.online.ecodebuddy.persistence.managers.jpa.JpaSessionManager;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * A generic JPA data access object to be used as a base for concrete JPA service implementations
 */
public abstract class JpaGenericDao<T extends Model> implements Dao<T> {

    protected JpaSessionManager sm;
    protected Class<T> modelType;

    /**
     * Initialize a new JPA DAO instance given a model type
     * @param modelType the model type
     */
    public JpaGenericDao(Class<T> modelType) {
        this.modelType = modelType;
    }

    /**
     * set the session manager
     * @param sm the session manager to set
     */
    @Autowired
    public void setSm(JpaSessionManager sm) {
        this.sm = sm;
    }

    /**
     * @see Dao#findAll()
     */
    @Override
    public List<T> findAll() {
        EntityManager em = sm.getCurrentSession();
        return em.createQuery("from " + modelType.getSimpleName() + " order by id", modelType).getResultList();
    }

    /**
     * @see Dao#findById(Integer)
     */
    @Override
    public T findById(Integer id) {
        EntityManager em = sm.getCurrentSession();
        return em.find(modelType, id);
    }

    /**
     * @see Dao#saveOrUpdate(Model)
     */
    @Override
    public T saveOrUpdate(T modelObject) {
        EntityManager em = sm.getCurrentSession();
        return em.merge(modelObject);
    }

    /**
     * @see Dao#delete(Integer)
     * @param id the id of the model to be deleted
     */
    @Override
    public void delete(Integer id) {
        EntityManager em = sm.getCurrentSession();

        em.remove(em.find(modelType, id));
    }
}
