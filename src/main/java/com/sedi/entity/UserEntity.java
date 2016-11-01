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
    private String userName;
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
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
