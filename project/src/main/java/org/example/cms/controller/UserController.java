package org.example.cms.controller;

import org.example.cms.model.User;
import org.example.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    /**
     * Constructor for UserController.
     * Uses constructor injection to provide UserService.
     *
     * @param userService the UserService to be injected.
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Creates a new user.
     *
     * @param user the User object received from the request body.
     * @return the saved User object.
     */
    @PostMapping("/create-user")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * Updates an existing user by ID.
     *
     * @param id the ID of the user to be updated.
     * @param user the User object containing updated information.
     * @return the updated User object.
     */
    @PutMapping("/edit-user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    /**
     * Retrieves all users.
     *
     * @return a list of all User objects.
     */
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Deletes a user by ID.
     *
     * @param id the ID of the user to be deleted.
     */
    @DeleteMapping("/delete-user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}