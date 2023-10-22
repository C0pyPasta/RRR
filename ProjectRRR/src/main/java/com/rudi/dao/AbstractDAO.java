package com.rudi.dao;

import com.rudi.config.ConnectionManager;
import com.rudi.entities.AbstractEntity;

public abstract class AbstractDAO {
    protected ConnectionManager connectionManager;

    public AbstractDAO()
    {
        this.connectionManager = new ConnectionManager();
    }

    public <T extends AbstractEntity> void save(T entity)
    {
        connectionManager.inTransaction(session -> {
            session.persist(entity);
        });
    }

    public <T extends AbstractEntity> void delete(T entity)
    {
        connectionManager.inTransaction(session -> {
            session.remove(session.merge(entity));
        });
    }

//    public <T extends AbstractEntity> T getById(Long id)
//    {
//        connectionManager.inTransaction(session -> {
//            session.find()
//        });
//    }
}
