package com.co.outline.models;

public class Data {
    private String user;
    private String password;

    public Data(String user, String password) {
        this.user = user;
        this.password = password;

    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
