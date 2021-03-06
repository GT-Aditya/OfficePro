package com.boot.officeproject.model.usermodel;

public class UserLogin {
    private String username;
    private String password;
    
    public UserLogin() {
    }
    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "UserLogin [password=" + password + ", username=" + username + "]";
    }
    
}
