package org.example.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class WebController {

    /**
     * Displays the form for creating a new user.
     *
     * @return the name of the HTML template for the user creation form.
     */
    @GetMapping("/create-user")
    public String showCreateUserForm() {
        return "create-user.html";
    }

    /**
     * Displays the form for deleting a user.
     *
     * @return the name of the HTML template for the user deletion form.
     */
    @GetMapping("/delete-user")
    public String showDeleteUserForm() {
        return "delete-user.html";
    }

    /**
     * Displays the form for editing a user, based on the user ID.
     *
     * @param userId the ID of the user to edit.
     * @return the name of the HTML template for editing the user.
     */
    @GetMapping("/edit-user/{userId}")
    public String showEditUser(@PathVariable Long userId) {
        return "edit-user.html";
    }

    /**
     * Displays the list page for users.
     *
     * @return the name of the HTML template for the user list page.
     */
    @GetMapping("/list")
    public String showListPage() {
        return "list.html";
    }

    /**
     * Displays the form for creating new content.
     *
     * @return the name of the HTML template for creating content.
     */
    @GetMapping("/create-content")
    public String showCreateContentPage() {
        return "create-content.html";
    }

    /**
     * Displays the form for updating content.
     *
     * @return the name of the HTML template for updating content.
     */
    @GetMapping("/update-content")
    public String showUpdateContentPage() {
        return "update-content.html";
    }

    /**
     * Displays the form for deleting content.
     *
     * @return the name of the HTML template for deleting content.
     */
    @GetMapping("/delete-content")
    public String showDeleteContentPage() {
        return "delete-content.html";
    }

    /**
     * Displays the list page for content.
     *
     * @return the name of the HTML template for the content list page.
     */
    @GetMapping("/content-list")
    public String showListContentPage() {
        return "content-list.html";
    }

    /**
     * Displays the form for creating a new WordPress user.
     *
     * @return the name of the HTML template for creating a WordPress user.
     */
    @GetMapping("/create-wordpress-user")
    public String showCreateWordPressPage() {
        return "create-wordpress-user.html";
    }
}