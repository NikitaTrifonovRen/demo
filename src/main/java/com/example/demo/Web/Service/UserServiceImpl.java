package com.example.demo.Web.Service;

import com.example.demo.Web.Dao.UserDao;
import com.example.demo.Web.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Transactional
    public List<User> allUsers() {
        return userDao.findAll();
    }
    @Transactional
    public void addUser(User user) {
       userDao.save(user);
    }

    @Transactional
    public void removeUser(int id) {
        userDao.deleteById(id);
    }
    @Transactional
    public User showUser(int id) {
        return userDao.findById(id);
    }
    @Transactional
    public void updateUserParams(User user) {
        userDao.save(user);
    }
    @Transactional
    public User findByName(String name){
        return userDao.findByName(name);
    }
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userDao.findByName(name);
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getName())
                .password(user.getPassword())
                .authorities(user.getUserRoles())
                .build();

        //return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), user.getUserRoles());
    }

}
