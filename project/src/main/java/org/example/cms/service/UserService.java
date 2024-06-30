package org.example.cms.service;

import org.example.cms.model.User;
import org.example.cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Creates a new user with the given username and password.
     *
     * @param username the username of the new user.
     * @param password the password of the new user.
     * @return the created user object.
     */
    public User createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    /**
     * Retrieves all users from the database.
     *
     * @return a list of all users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a user by their ID from the database.
     *
     * @param id the ID of the user to retrieve.
     * @return the retrieved user.
     * @throws RuntimeException if no user with the given ID exists.
     */
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    /**
     * Saves a user to the database, encoding their password.
     *
     * @param user the user object to save.
     * @return the saved user object.
     */
    @Transactional
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Updates an existing user in the database.
     *
     * @param id   the ID of the user to update.
     * @param user the updated user object.
     * @return the updated user object.
     * @throws RuntimeException if no user with the given ID exists.
     */
    @Transactional
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setUsername(user.getUsername());
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return userRepository.save(existingUser);
    }

    /**
     * Deletes a user from the database by their ID.
     *
     * @param id the ID of the user to delete.
     */
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}