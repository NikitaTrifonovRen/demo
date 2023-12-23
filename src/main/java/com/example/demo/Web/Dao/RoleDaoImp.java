package com.example.demo.Web.Dao;

import com.example.demo.Web.Models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

@Repository
public class RoleDaoImp implements RoleDao {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public Role showRole(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery(
                "SELECT r FROM Role r WHERE r.name = :name", Role.class);
        query.setParameter("name", name);
        Role role = (Role) query.getSingleResult();
        return role;
    }
}
