package com.example.demo.Web.Dao;

import com.example.demo.Web.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<User> allUsers() {
        Query query = entityManagerFactory.createEntityManager().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removeUser(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class,id);
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public User showUser(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class,id);
        return user;

    }

    @Override
    public void updateUserParams(int id, User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User userToUpdate = entityManager.find(User.class,id);
        userToUpdate.setName(user.getName());
        userToUpdate.setAdress(user.getAdress());
        entityManager.getTransaction().begin();
        entityManager.merge(userToUpdate);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public User findByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.name = :name", User.class);
        query.setParameter("name", name);
        User user = (User) query.getSingleResult();
        return user;

    }
}
