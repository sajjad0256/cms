package org.example.cms.controller;

import org.example.cms.model.User;
import org.example.cms.service.WordPressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/wordpress")
public class WordPressController {

    private final WordPressService wordPressService;

    /**
     * Constructor for WordPressController.
     * Uses constructor injection to provide WordPressService.
     *
     * @param wordPressService the WordPressService to be injected.
     */
    @Autowired
    public WordPressController(WordPressService wordPressService) {
        this.wordPressService = wordPressService;
    }

    /**
     * Endpoint to create a new user in WordPress.
     *
     * @param user the User object received from the request body.
     * @return a Mono wrapping the response from the WordPress service.
     */
    @PostMapping("/users")
    public Mono<String> createUser(@RequestBody User user) {
        return wordPressService.createUserOnWordPress(user);
    }

    /**
     * Endpoint to update an existing user in WordPress by ID.
     *
     * @param id the ID of the user to be updated.
     * @param user the User object containing updated information.
     * @return a Mono wrapping the response from the WordPress service.
     */
    @PutMapping("/users/{id}")
    public Mono<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        return wordPressService.updateUserOnWordPress(id, user);
    }

    /**
     * Endpoint to delete a user from WordPress by ID.
     *
     * @param id the ID of the user to be deleted.
     * @return a Mono wrapping the response from the WordPress service.
     */
    @DeleteMapping("/users/{id}")
    public Mono<String> deleteUser(@PathVariable Long id) {
        return wordPressService.deleteUserOnWordPress(id);
    }
}