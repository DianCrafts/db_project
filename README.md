# Food delivery service 

This is a Spring Boot application for managing a PostgreSQL dataset, focused on handling customer-related data, deliveries, food reservations, and raw materials. The project includes various models, controllers, and repositories that provide a structured way to interact with the database.

## Project Structure

The project is organized into the following main folders:

- **models/**: Contains the entity classes that define the data structure of the application.
- **controllers/**: Contains the REST controllers that handle incoming requests and interact with the service layer.
- **repository/**: Contains the repository interfaces for performing CRUD operations on the models.


## why spring boot:
### Rapid Development
- Convention Over Configuration: Spring Boot comes with sensible defaults and pre-configured setups, allowing you to get started quickly without needing extensive configuration.
- Spring Initializr: You can easily generate a base project structure using Spring Initializr, which simplifies the setup process for new applications.
### Integration with PostgreSQL
- seamless Database Integration: Spring Boot provides out-of-the-box support for PostgreSQL, including automatic configuration and easy integration with JPA (Java Persistence API) and Hibernate.
- Spring Data JPA: This feature simplifies database interactions, allowing you to perform CRUD operations without writing boilerplate code.
### RESTful API Support
- Easy REST Controllers: Spring Boot makes it straightforward to create RESTful web services using annotations like @RestController and @RequestMapping, streamlining the development of APIs for your application.
- Response Handling: It provides built-in mechanisms for handling various response types, making it easier to create well-structured APIs.
## Getting Started
To run the project, follow these steps:

Clone the Repository
```
git clone https://github.com/DianCrafts/db_project
```
Set Up PostgreSQL: Ensure you have PostgreSQL installed and running. Create a database for the application.

Update Application Properties: Configure your application.properties file with your PostgreSQL database credentials:

properties
```
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
Run the Application: Navigate to the project directory and run the application:
```
./mvnw spring-boot:run
```
