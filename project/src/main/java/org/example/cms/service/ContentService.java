package org.example.cms.service;

import org.example.cms.model.Content;
import org.example.cms.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    /**
     * Retrieves all contents from the database.
     *
     * @return a list of all contents.
     */
    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    /**
     * Saves a new content to the database.
     *
     * @param content the content to save.
     * @return the saved content.
     */
    @Transactional
    public Content saveContent(Content content) {
        return contentRepository.save(content);
    }

    /**
     * Retrieves a content by its ID from the database.
     *
     * @param id the ID of the content to retrieve.
     * @return the retrieved content.
     * @throws RuntimeException if no content with the given ID exists.
     */
    @Transactional
    public Content getContentById(Long id) {
        return contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content not found"));
    }

    /**
     * Updates an existing content in the database.
     *
     * @param id      the ID of the content to update.
     * @param content the updated content object.
     * @return the updated content.
     * @throws RuntimeException if no content with the given ID exists.
     */
    @Transactional
    public Content updateContent(Long id, Content content) {
        Optional<Content> optionalContent = contentRepository.findById(id);
        if (optionalContent.isPresent()) {
            Content existingContent = optionalContent.get();
            existingContent.setTitle(content.getTitle());
            existingContent.setBody(content.getBody());
            return contentRepository.save(existingContent);
        } else {
            throw new RuntimeException("Content not found");
        }
    }

    /**
     * Deletes a content from the database by its ID.
     *
     * @param id the ID of the content to delete.
     */
    @Transactional
    public void deleteContent(Long id) {
        contentRepository.deleteById(id);
    }
}