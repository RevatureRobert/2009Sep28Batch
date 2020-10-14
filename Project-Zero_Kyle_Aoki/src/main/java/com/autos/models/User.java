package com.autos.models;

public class User {

    private String username;
    private String pw;
    private String accounttype;

    public User() {}

    public User(String username, String pw, String accounttype) {
        this.username = username;
        this.pw = pw;
        this.accounttype = accounttype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }
}
