package ru.artezio.dbWithView.models;

import org.springframework.security.core.GrantedAuthority;

public class User {
    int user_id;
    private String name="unknown";
    private String password="unknown";
    private String role;

    public User() {
    }

    public User(int user_id, String name, String password, String role) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return this.password+" "+this.name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
