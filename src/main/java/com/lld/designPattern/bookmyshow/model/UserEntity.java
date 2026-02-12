package com.lld.designPattern.bookmyshow.model;

public class UserEntity {

    public int userId;
    public String userName;
    public String email;

    public UserEntity(int userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }
}
