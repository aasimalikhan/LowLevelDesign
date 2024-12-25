package org.example.designScenarios.designAuthenticationAndAuthorization.code;

import java.util.List;

public class User {
    private String userId;
    private String username;
    private String password;
    private List<String> roles;

    public User(String userId, String username, String password, List<String> roles)
    {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
