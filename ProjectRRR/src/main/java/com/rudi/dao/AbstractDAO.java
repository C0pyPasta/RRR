package com.rudi.dao;

import com.rudi.entities.AbstractEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.function.Consumer;

public abstract class AbstractDAO {

    public AbstractDAO()
    {

    }

    public <T extends AbstractEntity> void save(T entity)
    {
        inTransaction(session -> {
            session.persist(entity);
        });
    }

    public <T extends AbstractEntity> void delete(T entity)
    {
        inTransaction(session -> {
            session.remove(session.merge(entity));
        });
    }

//    public <T extends AbstractEntity> T getById(Long id)
//    {
//        connectionManager.inTransaction(session -> {
//            session.find()
//        });
//    }
    public void inTransaction(Consumer<EntityManager> work) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            work.accept(entityManager);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
        finally {
            entityManager.close();
        }
    }
}
