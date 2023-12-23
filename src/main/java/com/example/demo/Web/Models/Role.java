package com.example.demo.Web.Models;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")

public class Role implements GrantedAuthority {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "userRoles")
    private List<User> users;
    public Role(){

    }

    public Role(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users.toString() +
                '}';
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
