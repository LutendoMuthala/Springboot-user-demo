package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserServiceTests {

    private UserService userService;
    private FakeRepoInterface fakeRepo;

    @BeforeEach
    void setUp() {
        // Create a mock of the FakeRepoInterface
        fakeRepo = Mockito.mock(FakeRepoInterface.class);

        // Initialize the UserService with the mock repository
        userService = new UserServiceImpl(fakeRepo);
    }

    @Test
    void testAddUser() {
        // Arrange
        String name = "Luu";
        String surname = "Muthala";
        when(fakeRepo.insertUser(anyLong(), anyString(), anyString())).thenReturn(name);

        // Act
        String result = userService.addUser(name, surname);

        // Assert
        assertEquals(name + " added", result);
    }

    @Test
    void testRemoveUser() {
        // Arrange
        String name = "Luu";
        when(fakeRepo.deleteUser(anyLong())).thenReturn(name);

        // Act
        String result = userService.removeUser(1L);

        // Assert
        assertEquals(name + " removed", result);
    }

    @Test
    void testRemoveUserNotFound() {
        // Arrange
        when(fakeRepo.deleteUser(anyLong())).thenReturn("User not found");

        // Act
        String result = userService.removeUser(999L);

        // Assert
        assertEquals("User not found", result);
    }

    @Test
    void testGetUser() {
        // Arrange
        String name = "Luu";
        when(fakeRepo.findUserById(anyLong())).thenReturn(name);

        // Act
        String result = userService.getUser(1L);

        // Assert
        assertEquals("hello " + name, result);
    }

    @Test
    void testGetUserNotFound() {
        // Arrange
        when(fakeRepo.findUserById(anyLong())).thenReturn("User not found");

        // Act
        String result = userService.getUser(999L);

        // Assert
        assertEquals("User not found", result);
    }
}
