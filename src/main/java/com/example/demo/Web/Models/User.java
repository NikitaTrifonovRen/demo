package com.example.demo.Web.Models;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String name;
    @Column
    private String adress;
    @Column
    private String password;
    @ManyToMany
    @JoinTable(name = "userRoles", joinColumns = @JoinColumn(
            name = "userId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
            name = "roleId", referencedColumnName = "id"))
    private List<Role> userRoles;

    public List<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<Role> userRoles) {
        this.userRoles = userRoles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(){

    }
    public User(String name, String adress, String password){
        this.name = name;
        this.adress =adress;
        this.password = password;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
