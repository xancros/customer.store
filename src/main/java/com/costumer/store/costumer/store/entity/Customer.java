package com.costumer.store.costumer.store.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_costumer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    private String name;
    private String surname;
    private Long phone;
    private String email;
    private String user;
    private String password;


    public Customer(){}

    public Customer(String name, String surname, Long phone, String email, String user, String password) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.user = user;
        this.password = password;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
