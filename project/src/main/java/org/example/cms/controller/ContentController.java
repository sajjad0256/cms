package org.example.cms.controller;

import org.example.cms.model.Content;
import org.example.cms.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/")
public class ContentController {

    private final ContentService contentService;

    /**
     * Constructor injection for ContentService.
     *
     * @param contentService the ContentService to be injected.
     */
    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    /**
     * Endpoint to create new content.
     *
     * @param content the Content object to be created.
     * @return the created Content object.
     */
    @PostMapping("/create-content")
    public ResponseEntity<Content> createContent(@RequestBody Content content) {
        Content createdContent = contentService.saveContent(content);
        return new ResponseEntity<>(createdContent, HttpStatus.CREATED);
    }

    /**
     * Endpoint to update existing content.
     *
     * @param id the ID of the content to be updated.
     * @param content the Content object with updated data.
     * @return the updated Content object.
     */
    @PutMapping("/update-content/{id}")
    public ResponseEntity<Content> updateContent(@PathVariable Long id, @RequestBody Content content) {
        Content updatedContent = contentService.updateContent(id, content);
        return new ResponseEntity<>(updatedContent, HttpStatus.OK);
    }

    /**
     * Endpoint to retrieve all content.
     *
     * @return a list of all Content objects.
     */
    @GetMapping("/contents")
    public ResponseEntity<List<Content>> getAllContents() {
        List<Content> contents = contentService.getAllContents();
        return new ResponseEntity<>(contents, HttpStatus.OK);
    }

    /**
     * Endpoint to delete content by ID.
     *
     * @param id the ID of the content to be deleted.
     */
    @DeleteMapping("/delete-content/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long id) {
        contentService.deleteContent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}