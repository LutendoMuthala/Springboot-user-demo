package org.example;

public interface FakeRepoInterface {
 //Insert a new user into the repository
     
    String insertUser(long id, String name, String surname);
    
    // Find a user by their ID
     
    String findUserById(long id);
    
    // Delete a user from the repository by their ID
    
    String deleteUser(long id);
}

