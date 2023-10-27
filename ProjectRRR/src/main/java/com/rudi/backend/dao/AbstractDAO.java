package com.rudi.backend.dao;

import com.rudi.backend.entities.AbstractEntity;
import jakarta.persistence.*;
import java.util.List;
import java.util.function.Consumer;

public abstract class AbstractDAO {

    public <T extends AbstractEntity> void save(T entity)
    {
        performTransaction(session -> {
            session.persist(entity);
        });
    }

    public <T extends AbstractEntity> void saveAll(List<T> entityList)
    {
        performTransaction(session -> {
            for(T entity : entityList)
            {
                session.persist(entity);
            }
        });
    }

    public <T extends AbstractEntity> void delete(T entity)
    {
        performTransaction(session -> {
            session.remove(session.merge(entity));
        });
    }

//    public <T extends AbstractEntity> T getById(Long id)
//    {
//        connectionManager.inTransaction(session -> {
//            session.find()
//        });
//    }

    public void performTransaction(Consumer<EntityManager> work) {
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
