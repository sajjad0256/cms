package org.example.cms.repository;


import org.example.cms.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserTest {

    @Test
    public void testUser() {

        User user = new User();
        System.out.println("create user instance.");

        //default instance.
        assertNull(user.getId(), "null");
        assertNull(user.getUsername(), "null");
        assertNull(user.getPassword(), "null");
        System.out.println("id: " + " " + user.getId());
        System.out.println("userName: "+ " " + user.getUsername());
        System.out.println("password: " + " " + user.getPassword());

        Long expectedId = 1l;
        String expectedUserName = "sajjad";
        String expectedPassword = "nothing";

        //define user
        user.setId(expectedId);
        user.setUsername(expectedUserName);
        user.setPassword(expectedPassword);
        assertEquals(expectedId, user.getId());
        assertEquals(expectedUserName, user.getUsername());
        assertEquals(expectedPassword, user.getPassword());

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

    }

}