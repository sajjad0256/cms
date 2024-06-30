package org.example.cms.service;

import org.example.cms.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class WordPressService {

    @Value("${wordpress.api.url}")
    private String wordpressApiUrl;

    @Value("${wordpress.api.token}")
    private String wordpressApiToken;

    private final WebClient webClient;

    public WordPressService() {
        this.webClient = WebClient.builder().build();
    }

    /**
     * Creates a user on WordPress using WebClient.
     *
     * @param user the user object to create.
     * @return a Mono representing the response from WordPress.
     */
    public Mono<String> createUserOnWordPress(User user) {
        return webClient.post()
                .uri(wordpressApiUrl + "/users")
                .header("Authorization", "Bearer " + wordpressApiToken)
                .bodyValue(user)
                .retrieve()
                .bodyToMono(String.class);
    }

    /**
     * Updates a user on WordPress using WebClient.
     *
     * @param id   the ID of the user to update.
     * @param user the updated user object.
     * @return a Mono representing the response from WordPress.
     */
    public Mono<String> updateUserOnWordPress(Long id, User user) {
        return webClient.put()
                .uri(wordpressApiUrl + "/users/" + id)
                .header("Authorization", "Bearer " + wordpressApiToken)
                .bodyValue(user)
                .retrieve()
                .bodyToMono(String.class);
    }

    /**
     * Deletes a user from WordPress using WebClient.
     *
     * @param id the ID of the user to delete.
     * @return a Mono representing the response from WordPress.
     */
    public Mono<String> deleteUserOnWordPress(Long id) {
        return webClient.delete()
                .uri(wordpressApiUrl + "/users/" + id)
                .header("Authorization", "Bearer " + wordpressApiToken)
                .retrieve()
                .bodyToMono(String.class);
    }

}