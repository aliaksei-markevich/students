package ru.artezio.dbWithView.models;

public class User {
    int user_id;
    private String name="unknown";
    private String password="unknown";

    public User() {
    }

    public User(final int user_id,final String name,final String password) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
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
}
