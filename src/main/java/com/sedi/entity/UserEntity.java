package com.sedi.entity;

import javax.persistence.*;

/**
 * Created by csw on 2016/11/1 10:09.
 * Explain:
 */
@Entity
@Table(name = "sedi_user", schema = "", catalog = "sedi")
public class UserEntity {

    private Integer id;
    private String username;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
