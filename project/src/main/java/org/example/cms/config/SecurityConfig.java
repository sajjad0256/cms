package org.example.cms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Bean definition for password encoder using BCrypt hashing algorithm.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures HTTP security settings.
     *
     * @param http the HttpSecurity to modify.
     * @throws Exception if an error occurs.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors() // Enable CORS (Cross-Origin Resource Sharing)
                .and()
                .csrf().disable() // Disable CSRF (Cross-Site Request Forgery) protection
                .authorizeRequests()
                // Allow public access to specific HTTP methods and paths
                .antMatchers(HttpMethod.PUT, "/edit-user/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/update-content/**").permitAll()
                .antMatchers(HttpMethod.POST, "/create-wordpress-user/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/delete-user/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/delete-content/**").permitAll()
                .antMatchers(
                        "/",
                        "/create-user",
                        "/styles.css",
                        "/list",
                        "/create-content",
                        "/edit-user",
                        "/index",
                        "/portal",
                        "/users",
                        "/contents",
                        "/create-wordpress-user",
                        "/content-list",
                        "/delete-content",
                        "/update-content",
                        "/delete-user/**",
                        "/favicon.ico",
                        "/scripts.js"
                ).permitAll()
                .anyRequest().authenticated(); // Require authentication for any other requests
    }
}