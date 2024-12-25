package org.example.designScenarios.designInventoryManagementSystem.manager;


import org.example.designScenarios.designInventoryManagementSystem.User;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserManager {
    private List<User> users;
    public void addUser(User user)
    {
        users.add(user);
    }
    public void removeUser(User user)
    {
        users.remove(user);
    }
    public void removeUser(String id)
    {
        users = users.stream().filter(item -> Objects.equals(item.getId(), id)).toList();
    }
}
