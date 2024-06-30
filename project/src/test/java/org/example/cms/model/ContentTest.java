package org.example.cms.repository;


import org.example.cms.model.Content;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class ContentTest {

    @Test
    public void testContent() {

        Content content = new Content();
        System.out.println("create content instance.");

        assertNull(content.getId(), "null");
        assertNull(content.getBody(), "null");
        assertNull(content.getTitle(), "null");
        System.out.println("id: " + " " + content.getId());
        System.out.println("body: " + " " + content.getBody());
        System.out.println("title: " + " " + content.getTitle());

        Long expectedId = 1l;
        String expectedBody = "Body";
        String expectedTitle = "Title";
        content.setId(expectedId);
        content.setBody(expectedBody);
        content.setTitle(expectedTitle);
        System.out.println("id: " + " " + content.getId());
        System.out.println("body: " + " " + content.getBody());
        System.out.println("title: " + " " + content.getTitle());


    }

}
