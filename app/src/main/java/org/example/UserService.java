package org.example;

public interface UserService {
    //Add a new user to the system
     
    String addUser(String name, String surname);
    
    //Remove a user from the system by ID
     
    String removeUser(long id);
    
    //Get user information by ID
     
    String getUser(long id);
}