package org.example.caseStudies.designAuthenticationAndAuthorization.code;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private Map<String, User> userStore = new HashMap<>();
    public void registerUser(User user)
    {
        userStore.put(user.getUsername(), user);
    }

    public User authenticate(String username, String password)
    {
        User user = userStore.get(username);
        if(user != null && user.getPassword().equals(password))
        {
            return user;
        }
        throw new RuntimeException("Invalid Credentials");
    }
}
