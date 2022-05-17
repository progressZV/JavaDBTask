package com.senla.javadbtask.repository.impl;

import com.senla.javadbtask.repository.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractDao<T, Id> implements GenericDao<T, Id> {

    @PersistenceContext
    protected EntityManager entityManager;
    protected Class<T> clazz;

    public AbstractDao(Class<T> clazz){
        this.clazz = clazz;
    }

    public T save(final T entity){
        entityManager.persist(entity);
        return entity;
    }

    public T read(final Id id){
        return entityManager.find(clazz, id);
    }

    public T update(final T entity){
       return entityManager.merge(entity);
    }

    public void delete(final Id id){
        entityManager.remove(entityManager.find(clazz, id));
    }
}
