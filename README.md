# wishfy-technologies

# Application README

## Table of Contents
- [Introduction](#introduction)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Configuration](#configuration)
  - [Database Configuration](#database-configuration)
  - [Login Credentials](#login-credentials)
- [Usage](#usage)
  - [Login](#login)
- [Endpoints](#endpoints)
  - [Login Endpoint](#login-endpoint)
- [Authentication](#authentication)
- [Exception Handling](#exception-handling)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Welcome to the documentation for the empl project. This application provides [brief description of your application's purpose].


## Getting Started

### Prerequisites

- [List of prerequisites, e.g., Java, Spring Boot, MySQL]

### Installation

1. [Clone the repository: `git clone https://github.com/your-username/your-repository.git`]
2. [Navigate to the project directory: `cd your-repository`]
3. [Build the project: `mvn clean install`]
4. [Run the application: `mvn spring-boot:run`]

## Configuration
##SQL
CREATE TABLE wishfy_technologies.employee (
    id INT NOT NULL,
    department VARCHAR(10),
    email VARCHAR(50),
    joining_date DATE,
    name VARCHAR(50),
    PRIMARY KEY (id)
) ENGINE=InnoDB;


### Database Configuration

Configure your application's database settings in the `application.properties` file:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

### Login Credentials

Set up login credentials in the `application.properties` file:

```properties
# Login Credentials
login.username=your_default_username
login.password=your_default_password
login.role=your_default_role
```

## Usage

### Login

To log in, send a POST request to the `/v1/login` endpoint with a JSON payload containing the email and password.

```json
{
  "email": "user@example.com",
  "password": "password123"
}
```

## Endpoints

### Login Endpoint

- **Endpoint:** `/v1/login`
- **Method:** POST
- **Request Body:**
  ```json
  {
    "email": "user@example.com",
    "password": "password123"
  }
  ```
- **Response:**
  ```json
  {
    "jwtToken": "your-generated-jwt-token",
    "userName": "user@example.com"
  }
  ```

## Authentication

This application uses JWT (JSON Web Token) for authentication. The generated token should be included in the Authorization header for subsequent requests.
User "Bearer"+" "+JWT

## Exception Handling

- The application handles `BadCredentialsException` during authentication.
- If invalid credentials are provided, a `401 Unauthorized` response is returned with an appropriate error message.

## Dependencies
<dependencies>

    <!-- Spring Boot Starters -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    
    <!-- Spring Boot Starter Test -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>

    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.8.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.8.2</version>
        <scope>test</scope>
    </dependency>

    <!-- Mockito -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>3.12.4</version>
        <scope>test</scope>
    </dependency>

    <!-- AssertJ for fluent assertions -->
    <dependency>
        <groupId>org.assertj</groupId>
        <artifactId>assertj-core</artifactId>
        <version>3.21.0</version>
        <scope>test</scope>
    </dependency>

    <!-- JSON Web Token -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.11.5</version>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-impl</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-jackson</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>

    <!-- Hibernate Validator -->
    <dependency>
        <groupId>org.hibernate.validator</groupId>
        <artifactId>hibernate-validator</artifactId>
        <version>7.0.2.Final</version>
    </dependency>

    <!-- MySQL Connector -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!-- Springfox Swagger -->
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-boot-starter</artifactId>
        <version>3.0.0</version>
    </dependency>

    <!-- Springdoc OpenAPI UI -->
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.2.0</version>
    </dependency>

    <!-- Servlet API -->
    <dependency>
        <groupId>jakarta.servlet</groupId>
        <artifactId>jakarta.servlet-api</artifactId>
        <version>6.0.0</version>
        <scope>provided</scope>
    </dependency>

</dependencies>



