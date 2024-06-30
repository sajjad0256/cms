package org.example.cms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String body;

    /**
     * Retrieves the ID of the content.
     *
     * @return the ID of the content.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the content.
     *
     * @param id the ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the title of the content.
     *
     * @return the title of the content.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the content.
     *
     * @param title the title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the body of the content.
     *
     * @return the body of the content.
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the body of the content.
     *
     * @param body the body to set.
     */
    public void setBody(String body) {
        this.body = body;
    }
}