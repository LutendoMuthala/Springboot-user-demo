package org.example;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeRepo implements FakeRepoInterface {

    private final List<User> userList = new ArrayList<>();

    @Override
    public String insertUser(long id, String name, String surname) {
        // Check if user with this ID already exists
        for (User user : userList) {
            if (user.getId() == id) {
                return "User with ID " + id + " already exists";
            }
        }

        // Create and add the new user
        User newUser = new User(id, name, surname);
        userList.add(newUser);
        return name;
    }

    @Override
    public String findUserById(long id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user.getName();
            }
        }
        return "User not found";
    }

    @Override
    public String deleteUser(long id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                String name = userList.get(i).getName();
                userList.remove(i);
                return name;
            }
        }
        return "User not found";
    }
}