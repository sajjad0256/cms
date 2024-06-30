# CMS Project

This project is a Content Management System (CMS) developed using Spring Boot and Spring Data JPA. It provides functionalities for managing users and content, including creating, updating, retrieving, and deleting operations.

## Features

- **User Management**: CRUD operations for managing users with username and password.
- **Content Management**: CRUD operations for managing content with title and body.
- **WordPress Integration**: Integration with WordPress API for creating, updating, and deleting users.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- WebClient (for WordPress integration)
- HTML/CSS/JavaScript (for frontend UI)
- MySQL (or any other database supported by Spring Data JPA)

## Project Structure

The project is structured as follows:

- **Model**: Contains Java entities (`Content` and `User`) mapped to database tables.
- **Repository**: Data access layer using Spring Data JPA (`ContentRepository` and `UserRepository`).
- **Service**: Business logic layer implementing CRUD operations (`ContentService`, `UserService`, `WordPressService`).
- **Controller**: REST API endpoints for users (`UserController`), content (`ContentController`), and WordPress integration (`WordPressController`).
- **Configuration**: Spring configurations including security settings (`SecurityConfig`), web configuration (`WebConfig`), and main application class (`Main`).
- **Static Resources**: Contains static files such as HTML templates (`*.html`), CSS (`styles.css`), and JavaScript (`scripts.js`).

## Getting Started

To run this project locally, make sure you have Java and Maven installed. Clone the repository and configure your database settings in `application.properties`. Then, build and run the project using Maven:

```bash
mvn spring-boot:run
