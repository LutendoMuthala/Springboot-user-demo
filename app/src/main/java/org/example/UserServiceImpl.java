package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    
    private final FakeRepoInterface fakeRepo;
    private final Random random = new Random();
    
    @Autowired
    public UserServiceImpl(FakeRepoInterface fakeRepo) {
        this.fakeRepo = fakeRepo;
    }
    
    @Override
    public String addUser(String name, String surname) {
        // Generate a random ID for demonstration purposes
        long id = random.nextLong(1000);
        String result = fakeRepo.insertUser(id, name, surname);
        System.out.println(result + " added");
        return result + " added";
    }
    
    @Override
    public String removeUser(long id) {
        String result = fakeRepo.deleteUser(id);
        if (!"User not found".equals(result)) {
            System.out.println(result + " removed");
            return result + " removed";
        }
        System.out.println(result);
        return result;
    }
    
    @Override
    public String getUser(long id) {
        String result = fakeRepo.findUserById(id);
        if (!"User not found".equals(result)) {
            System.out.println("hello " + result);
            return "hello " + result;
        }
        System.out.println(result);
        return result;
    }
}
