package com.asiainfo.entity;

/**
 * Created by admin on 2018-06-02.
 */
public class Userinfo {

    private Long id;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
