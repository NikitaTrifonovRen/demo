package com.example.demo.Web.Service;

import com.example.demo.Web.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleService{
    Role showRole(String name);
}
