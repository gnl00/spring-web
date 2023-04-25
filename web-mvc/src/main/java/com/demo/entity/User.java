package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 * TODO
 *
 * @author gnl
 * @since 2023/4/21
 */
public class User implements Serializable {

    private static final long serialVersionUID = 7412326844439353227L;

    public interface WithoutPasswordView {};
    public interface WithPasswordView extends WithoutPasswordView {};

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @JsonView(WithoutPasswordView.class)
    public String getUsername() {
        return this.username;
    }

    @JsonView(WithPasswordView.class)
    public String getPassword() {
        return this.password;
    }
}
