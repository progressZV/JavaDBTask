package com.senla.javadbtask.repository;

public interface GenericDao<T, Id> {
    T save(final T entity);
    T read(final Id id);
    T update(final T entity);
    void delete(final Id id);
}
