# Mail Server Using REST API – OBJ2100 Assignment

This is a Spring Boot-based REST API that simulates a basic mail server. Users can register, log in, and send emails to each other. All data is stored in a PostgreSQL database. The API is documented using Swagger (OpenAPI) for easy testing and exploration.


---

## Table of Contents

- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Prerequisites](#prerequisites)  
- [Getting Started](#getting-started)  
- [API Documentation](#api-documentation)  
- [Project Structure](#project-structure)  
- [Key Components](#key-components)  
  - [Entities](#entities)  
  - [Controllers](#controllers)  
  - [Services](#services)  
  - [Repositories](#repositories)  
  - [DTOs](#dtos)  
  - [Mappers](#mappers)  
  - [Exception Handling](#exception-handling)  
  - [Configuration](#configuration)  
- [Acknowledgments](#acknowledgments)

---

## Features

- User registration, update, and deletion  
- Send and receive emails between users  
- RESTful API following standard HTTP methods (GET, POST, PUT, DELETE)  
- PostgreSQL integration via Spring Data JPA  
- API documentation using Swagger UI  

---

## Tech Stack

- **Java 17**  
- **Spring Boot 3.4.2**  
- **PostgreSQL**  
- **Spring Data JPA**  
- **MapStruct** – DTO mapping  
- **Lombok** – Boilerplate reduction  
- **Springdoc OpenAPI** – API documentation  

---

## Prerequisites

Before running the project, ensure you have:

- JDK 17  
- Maven (or use the included `mvnw`)  
- PostgreSQL  
- IDE (e.g., IntelliJ IDEA, VS Code)

---

## Getting Started

1. Clone the Repository

```bash
git clone https://github.com/<your-username>/MailServerOBJ2100.git
cd MailServerOBJ2100
```

2. Create the Database

```sql
CREATE DATABASE mailserverdb;
```
3. Configure `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mailserverdb
spring.datasource.username=your_username
spring.datasource.password=your_password
```
4. Build the Project

```bash
mvn clean install
```
5. Run the Application

```bash
mvn spring-boot:run
```
And if you dont have maven installed: 

```bash
.\mvnw spring-boot:run
```

6. Access the API
•	- Swagger UI: http://localhost:8080/swagger-ui.html
•	- OpenAPI JSON: http://localhost:8080/v3/api-docs

---

## API Documentation

This project uses **Swagger UI** (via Springdoc OpenAPI) for interactive API documentation and testing.

### How to Use:

- Start the application:
  ```bash
  ./mvnw spring-boot:run

### Testing with Swagger UI

1. Open your browser and go to http://localhost:8080/swagger-ui.html
2. Expand the sections for:
   - User Management API – for registering, retrieving, updating, and deleting users
   - Email Management API – for sending and retrieving emails
   - Click "Try it out", then "Execute"
   - View the response directly in your browser

---

## Project Structure

```
src/main/java/com/myproject/
├── config/          # Configuration (e.g., web settings, database init)
├── controller/      # REST controllers for Users and Emails
├── dto/             # Data Transfer Objects (UserDTO, EmailDTO)
├── exception/       # Custom exception handling
├── mapper/          # MapStruct mappers for DTO and Entity
├── model/           # JPA entities: User, Email
├── repository/      # Spring Data JPA repositories
├── service/         # Business logic layer
```

---

## Key Components

### Entites

The `User` entity represents a registered user in the system:

- id (primary key)
- username
- email
- password

The `Email` entity represents an email message sent between users:

- id (primary key)

- fromEmail (sender's email address)

- toEmail (recipient's email address)

- subject (email subject line)

- body (content of the email)

- timestamp (time the email was sent, cannot be null)

---

### Controllers

The `EmailController` handles all email-related REST API operations:

- POST /api/emails – Send a new email

- GET /api/emails/received/{toEmail} – Get all emails received by a user

- GET /api/emails/sent/{fromEmail} – Get all emails sent by a user

- GET /api/emails/{id} – Retrieve a specific email by its ID

- DELETE /api/emails/{id} – Delete an email by its ID

Includes custom exception handling for missing emails (EmailNotFoundException) and returns appropriate HTTP responses.

The `UserController` Handles user-related REST operations:

- GET /api/users – Retrieve all registered users.

- GET /api/users/{id} – Retrieve a user by their ID.

- POST /api/users – Create a new user with username, email, and password.

- PUT /api/users/{id} – Update an existing user’s details.

- DELETE /api/users/{id} – Delete a user by their ID.

Returns appropriate status codes for successful and failed operations, and handles exceptions like UserNotFoundException.

---

## Services

### UserService

The `UserService` class handles business logic for user operations:

- createUser(User user): Saves a new user to the database.

- getAllUsers(): Retrieves all registered users.

- getUserById(Long id): Finds a user by ID or throws an exception if not found.

- updateUser(Long id, User newUserInfo): Updates user information based on the given ID.

- deleteUser(Long id): Deletes a user by ID.

### EmailService

The `EmailService` class manages email-related operations:

- sendEmail(Email email): Sets the timestamp and stores a new email.

- getEmailsReceivedBy(String toEmail): Retrieves all emails received by a specific address.

- getEmailsSentBy(String fromEmail): Retrieves all emails sent from a specific address.

- getEmailById(Long id): Finds an email by ID or returns null if not found.

- deleteEmail(Long id): Deletes an email using its ID.

---

## Repository layer

### UserRepository 

The user repository interface extends JpaRepository<User, Long> and provides built-in CRUD operations for the User entity. It also includes custom query methods such as:

- findByUsername(String username)

- findByEmail(String email)

These allow searching for users based on their username or email address.

### EmailRepository

The email repository interface extends JpaRepository<Email, Long> and provides built-in CRUD operations for the Email entity. It includes custom methods for filtering emails:

- findByToEmail(String toEmail): Retrieves all emails received by the specified email address.

- findByFromEmail(String fromEmail): Retrieves all emails sent from the specified email address.

---

## Data transfer objects (DTOs)

DTOs are used to encapsulate and transfer data between the client and server, without exposing the internal entity structure directly.

### User DTOs

- UserBasicDTO: Contains basic user information (e.g., id, username, email).

- UserDetailDTO: Contains detailed user information, including sensitive data like password.

These are used to present appropriate views of user data depending on the context (e.g., hiding the password when returning user lists).

### Email DTOs

- EmailBasicDTO: Represents a simplified view of an email, typically used in lists (e.g., fromEmail, toEmail, subject).

- EmailDetailDTO: Represents the full details of an email, including the body and timestamp.

These DTOs help structure email data efficiently for both retrieval and creation.

---

## Mappers

Mappers are used to convert between entities and their corresponding DTOs, ensuring that only necessary data is exposed through the API.

### UserMapper

- Converts between User entity and:

   - UserBasicDTO for general listing or lightweight views.

   - UserDetailDTO for detailed user information (e.g., during creation or updates).

### EmailMapper

- Converts between Email entity and:

   - EmailBasicDTO for sent/received lists.

   - EmailDetailDTO for complete email data including content and timestamp.

These mappers ensure a clean separation of concerns and reduce boilerplate code when handling transformations.

---

## Exception handling

The application includes a centralized exception handling mechanism using Spring's @ControllerAdvice to ensure consistent error responses throughout the API.

`GlobalExceptionHandler`
This class handles both specific and generic exceptions:

- `EntityNotFoundException`: Returns 404 Not Found if an entity is missing.

- `Exception`: Catches all other exceptions and returns a 500 Internal Server Error with the error message for debugging.

Custom Exceptions

- `UserNotFoundException`: Thrown when a requested user ID does not exist.

- `EmailNotFoundException`: Thrown when a requested email ID does not exist.

---

## Configuration

- WebConfiguration Enables support for Spring Data web features, such as automatic handling of pagination and sorting in controller methods.

---

## Running Tests

- Use the command: mvn test

---

## Acknowledgments

- Spring Boot

- PostgreSQL

- Springdoc OpenAPI

- MapStruct

- Project Lombok

---