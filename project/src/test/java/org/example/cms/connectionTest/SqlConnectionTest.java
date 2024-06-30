package org.example.cms.connectionTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SqlConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDatabaseConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
            assertTrue(true, "Database connection successful!");
        } catch (Exception ex) {
            assertTrue(false, "Error connecting to database: " + ex.getMessage());
        }
    }

    @AfterEach
    public void displaySuccessMessage() {
        System.out.println("Database connection test completed successfully.");
    }
}
