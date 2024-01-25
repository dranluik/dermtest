## Prerequisites

- **Java Development Kit (JDK) 17**: This project is built using JDK 17. Ensure that you have JDK 17 installed on your 
machine. Set the `JAVA_HOME` environment variable to point to the JDK installation directory.

  JDK 17 can be downloaded from [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) or 
[AdoptOpenJDK](https://adoptopenjdk.net/).

- **Maven**: This project uses Maven for dependency management and build automation. The Maven Wrapper (`mvnw`) is 
included in the project, so you do not need to have Maven installed. Use `./mvnw` (on Unix-like systems) or `mvnw.cmd` 
(on Windows) to run Maven commands.
- **Docker**: Docker & Docker Compose: This project uses Docker to containerize and run the application in an isolated 
environment. Docker Compose is used to simplify the Docker configurations. Ensure that both Docker and Docker 
Compose are installed on your machine.

## Building with Maven Wrapper

To build the project, open terminal in the project folder and run:

Unix-like systems:
````
./mvnw clean install
````

Windows:
````
mvnw clean install
````

## Running with Docker

To run the application using Docker Compose, execute the following command:
````
docker-compose up
````
This command will start the application as defined in the docker-compose.yaml file, including the necessary Docker 
container configurations.

### Overriding the Profile

The application is configured to use the dev profile by default. 
To run the application with a different profile, such as prod, 
update the SPRING_PROFILES_ACTIVE environment variable in the docker-compose.yaml 
file:
````
services:
  your-app:
    environment:
      - SPRING_PROFILES_ACTIVE=prod

````
Then, run docker-compose up again to start the application with the prod profile.

**Currently, for production the database datasource refers to a nonexistent location
/var/appdata/hsqldb/dermtest, so before running in 
production, you need to set up the database correctly in the system and in application-prod.properties.**

## Accessing the Application and API Documentation

Once the application is up and running, you can access it and its API documentation through the following URL:

- Application Endpoint: http://localhost:8080/
- Swagger UI for API Documentation: http://localhost:8080/swagger-ui/index.html

### Logging in
The Spring Boot OAuth2 client includes Spring Security, which requires a login. The default username is `user`. 
The password is auto-generated by Spring Boot and printed in the console log upon application startup. 
Look for a line similar to:
Using generated security password: generated-password

- username: user
- password: generated-password printed in console log

## Completed Tasks

### 1. Spring Boot REST API Creation

- **Description**: Created a Spring Boot (version 2.6 or 2.7) Maven-based Java 17 JAR REST API. 
Initially started with version 3.1.18 from Spring Initializr and then manually adjusted the version in the pom.xml.
- **Solution Approach**:
  - Used Spring Initializr to generate the project base.
  - Chose the dependencies: 
    - Lombok, 
    - Spring Web, 
    - Spring Data JPA, 
    - OAuth2 Client, 
    - HyperSQL Database, 
    - Validation.
  - Manually edited the pom.xml file to set version to the latest 2.7 Spring Boot version.
- Time Taken: 15-20 min. This is something I've done multiple times before, so it was just about deciding which 
dependencies I can select immediately and how to get an older Spring Boot version.

### 2. Configuration tasks
#### ii. Lombok Integration
- **Description**: Integrated Lombok to reduce boilerplate code like getters, setters, and constructors.
- **Solution Approach**:
  - Used Spring Initializr to add the Lombok dependency.
- Time Taken: Completed within task 1. I've always used Lombok in my Spring Boot setups.

#### iv. OpenAPI Documentation
- **Description**: Added OpenAPI documentation for the REST API.
- **Solution Approach**:
  - Added the Springdoc OpenApi UI dependency to pom.xml.
- Time Taken: 20 min. Had to find a compatible version for Spring Boot 2.7, I've only used Spring Boot 3.* before.

#### v. Add log4j
- **Description**:  Integrated Log4j for logging.
- **Solution Approach**:
  - Added Log4j dependencies in pom.xml.
- Time Taken: 30 min. Had to find a compatible version. I didn't manage to find a working dependency example in 
https://central.sonatype.com/search?q=log4j, 
so I had to write it myself using console error logs and ChatGPT.

#### iii. Docker Image Creation
- **Description**:  Created a runnable Docker image of the application using Docker Compose.
- **Solution Approach**:
  - Created a Dockerfile to package the application.
  - Used Docker Compose to manage the application container.
- Time Taken: 30 min. First time creating a docker image, took some time to understand common settings.

#### vi. Dual Configuration for Prod and Dev
- **Description**:  Set up two different configurations for production and development environments.
- **Solution Approach**:
  - Created separate application-prod.properties and application-dev.properties.
  - Configured log4j properties.
  - Configured environment-specific parameters in each property file.
  - Configured Docker Compose to map the database.
- Time Taken: 90-120 min. Took some time to understand what are some reasonable settings, and how it relates to the docker 
container.

#### i. File-based Database (HSQLDB)
- **Description**: Integrated a file-based HSQLDB database into the project.
- **Solution Approach**:
  - Used Spring Initializr to generate the dependency.
  - Set up the configurations and empty data and schema files during task 2.vi.
  - Mapped using docker compose in task 2.vi. Also set up data source in my ide.
- Time Taken: Completed in tasks 1 and 2.vi.

