# Student Management System API

The Student Management System API is a web application that provides a RESTful API for managing student records. It is built using Spring Boot, Maven, MVC, and Validation.

## Features
   * CRUD operations for managing student records.
   * RESTful API for accessing student information.
   * Validation rules to ensure data integrity and security.
   * Utilizes Spring Data JPA for database management.
   * Unit tests to ensure the reliability of the application.
## Technologies Used
    *  Spring Boot
    *  Maven
    *  MVC
    *  Validation
    *  Spring Data JPA
    *  JUnit
## Getting Started
      To run this application locally, you will need to have Java 8 or higher installed on your machine. Follow these steps:

      *  Clone the repository: git clone 
      *  Navigate to the project directory
      *  Run the application: ./mvnw spring-boot:run
      *  The application will be running at http://localhost:8080.

## API Endpoints
      The following endpoints are available:

      *  GET /students: Returns a list of all students.
      *  GET /students/{id}: Returns the student with the specified ID.
      *  POST /students: Adds a new student.
      *  PUT /students/{id}: Updates the student with the specified ID.
      *  DELETE /students/{id}: Deletes the student with the specified ID.
## Testing
To run the unit tests, navigate to the project directory and run ./mvnw test.

## Contributing
If you would like to contribute to this project, please fork the repository and submit a pull request.
