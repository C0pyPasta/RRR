package com.rudi.dao;

import com.rudi.config.ConnectionManager;
import com.rudi.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UserDAO {
    private ConnectionManager connectionManager;

    public UserDAO()
    {
        this.connectionManager = new ConnectionManager();
    }

    public void save(User user)
    {
        connectionManager.inTransaction(session -> {
            session.persist(user);
        });
    }

    public void delete(User user)
    {
        connectionManager.inTransaction(session -> {
            session.remove(user);
            session.getTransaction().commit();
        });
    }

    public User getByUsername(String username)
    {
        EntityManager entityManager = connectionManager.getEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = builder.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root).where(builder.like(root.get("username"), username));

        Query query = entityManager.createQuery(cq);
        List<User> results = query.getResultList();
        entityManager.close();
        if(!results.isEmpty())
        {
            return results.get(0);
        }
        return null;
    }

    public String hashPassword(String unhashedPassword)
    {
        return BCrypt.hashpw(unhashedPassword, BCrypt.gensalt());
    }
}
