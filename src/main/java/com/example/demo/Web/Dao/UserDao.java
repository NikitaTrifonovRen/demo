package com.example.demo.Web.Dao;

import com.example.demo.Web.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserDao{
    List<User> allUsers();
    void addUser(User user);
    void removeUser(int id);
    User showUser(int id);
    void updateUserParams(int id, User user);
    User findByName(String name);


}
