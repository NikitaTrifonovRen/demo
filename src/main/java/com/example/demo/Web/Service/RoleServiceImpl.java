package com.example.demo.Web.Service;

import com.example.demo.Web.Dao.RoleDao;
import com.example.demo.Web.Models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class RoleServiceImpl{
    @Autowired
    private RoleDao roleDao;
    @Transactional
    public Role showRole(String name) {
        return roleDao.findRoleByName(name);
    }
}
