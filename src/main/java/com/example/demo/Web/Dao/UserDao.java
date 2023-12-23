package com.example.demo.Web.Dao;

import com.example.demo.Web.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Integer> {
    User findByName(String name);
    User findById(int id);

}
