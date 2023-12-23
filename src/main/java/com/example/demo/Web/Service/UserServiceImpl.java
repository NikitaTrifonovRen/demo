package com.example.demo.Web.Service;

import com.example.demo.Web.Dao.UserDao;
import com.example.demo.Web.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Transactional
    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }
    @Transactional
    @Override
    public void addUser(User user) {
       userDao.addUser(user);
    }

    @Transactional
    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);
    }
    @Transactional
    @Override
    public User showUser(int id) {
        return userDao.showUser(id);
    }
    @Transactional
    @Override
    public void updateUserParams(int id, User user) {
        userDao.updateUserParams(id, user);
    }
    @Transactional
    @Override
    public User findByName(String name){
        return userDao.findByName(name);
    }

}
