package ru.artezio.db.models;

import ru.artezio.db.dto.Role;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
    int user_id;

    @Size(min = 3,max = 20,message = "Имя должно быть больше 3 и меньше 20")
    @Pattern(regexp = "[a-zA-Z0-9]+$",message = "Без проблеов" )
    private String name;

    @Size(min = 3,max = 20,message = "Пароль должно быть больше 3 и меньше 20")
    private String password;

    @Size(min = 3,max = 40,message = "Email должно быть больше 3 и меньше 40")
    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._+-]+.[A-Za-z]{2,4}",message = "Некорректный email" )
    private String email;
    private Role role;

    public User() {
        this.role = new Role("ROLE_USER",2);
    }

    public User(int user_id, String name, String password, String email, Role role) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.email = email;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
