package com.example.demo.Web.Dao;

import com.example.demo.Web.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Integer> {
    Role findRoleByName(String name);

}
