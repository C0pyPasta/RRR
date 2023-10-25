package com.rudi.dao;

import com.rudi.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO {

    public UserDAO()
    {
        super();
    }

    public void saveUser(User user)
    {
        if(getByUsername(user.getUsername()) == null)
        {
            user.setPassword(hashPassword(user.getPassword()));
            save(user);
        }
    }

    public void saveAllUsers(List<User> users)
    {
        List<User> usersWithHashedPasswords = new ArrayList<>();
        for(User user : users)
        {
            if(getByUsername(user.getUsername()) == null)
            {
                user.setPassword(hashPassword(user.getPassword()));
                usersWithHashedPasswords.add(user);
            }
        }
        saveAll(usersWithHashedPasswords);
    }

    public User getByUsername(String username)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = builder.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root).where(builder.like(root.get("username"), username.toLowerCase()));

        Query query = entityManager.createQuery(cq);
        List<User> result = query.getResultList();
        entityManager.close();
        return result.isEmpty() ? null : result.get(0);
    }

    public String hashPassword(String unhashedPassword)
    {
        return BCrypt.hashpw(unhashedPassword, BCrypt.gensalt());
    }

    public boolean checkPassword(User user, String input)
    {
        return BCrypt.checkpw(input, user.getPassword());
    }


}
