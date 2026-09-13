# Java Spring Learning Journey

This repository is my daily Java + Spring learning log.
Each task is added as a new section so the progress stays clear and organized.

---

## Task 01 - JDBC Demo Project

### Objective
Learn the basics of Java Database Connectivity (JDBC) and understand how Java connects to a database using a simple project.

### Concepts Covered
- JDBC
- `DriverManager`
- `Connection`
- `Statement`
- SQL queries
- Database connection setup

### Project Used
- `01-Demo_JDBC`

### What I Did
- Created a simple Java project for database connection
- Connected Java to a database using JDBC
- Executed a basic SQL query
- Reviewed how Java communicates with a database
- Learned the flow: connect → execute query → read results → close resources

### Key Notes
- JDBC is the standard Java API for connecting to databases.
- The basic steps are: load the driver, establish a connection, create a statement, execute SQL, and close the connection.
- A database connection is opened using `DriverManager.getConnection(...)`.
- Always close database resources after use to avoid leaks.

### Example Code
```java
String url = "jdbc:mysql://localhost:3306/mydb";
String username = "root";
String password = "1234";

Connection connection = DriverManager.getConnection(url, username, password);
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
```

### Learnings
- JDBC is the foundation before learning Hibernate and Spring Data JPA.
- Java can interact directly with SQL using standard database APIs.
- This project helped me understand how data flows between the application and the database.

### Next Step
- Continue learning Hibernate and understand the ORM approach.

---

## Task 02 - Hibernate CRUD Project

### Objective
Learn how Hibernate simplifies database operations by mapping Java objects to database tables and implementing CRUD operations using ORM.

### Concepts Covered
- Hibernate ORM
- JPA annotations
- Entity mapping
- PostgreSQL database connection
- CRUD operations
- HQL queries
- Pagination
- Criteria API
- Transactions and sessions

### Project Used
- `02-Hibernate CRUD`

### What I Did
- Created a `Student` entity mapped to the `students` table.
- Connected the application to PostgreSQL using Hibernate configuration.
- Implemented insert, select, update, and delete operations.
- Retrieved all students and searched using HQL.
- Added pagination for student queries.
- Practiced querying with the JPA Criteria API.

### Key Notes
- Hibernate is an ORM framework that maps Java classes to database tables.
- The `@Entity`, `@Table`, `@Id`, and `@GeneratedValue` annotations define the entity mapping.
- A Hibernate `Session` is used to communicate with the database.
- Transactions are required for insert, update, and delete operations.
- HQL queries use entity and property names instead of database table and column names.

### Learnings
- ORM reduces the amount of SQL and JDBC boilerplate code.
- JPA annotations make the relationship between Java objects and database tables clear.
- Hibernate supports multiple query approaches, including HQL and Criteria API.
- Proper session and transaction handling is important for reliable database operations.

### Next Step
- Start learning Spring and understand dependency injection.
- Connect Spring concepts with Hibernate and database applications.

---

## Task 03 - Spring Boot Start Project

### Objective
Learn the basics of Spring Boot, the IoC container, dependency injection, and Spring beans.

### Concepts Covered
- Spring Boot application setup
- `ApplicationContext`
- Inversion of Control (IoC)
- Dependency Injection
- `@Component`
- `@Autowired`
- Singleton bean scope

### Project Used
- `03-Spring Start`

### What I Did
- Created a Spring Boot application using Maven.
- Registered `Student` and `StudentService` as Spring components.
- Retrieved beans from the `ApplicationContext`.
- Verified that Spring returns the same `Student` bean by default.
- Injected `Student` into `StudentService` using `@Autowired`.
- Called the service to start the student's study process.

### Key Notes
- `ApplicationContext` is Spring's IoC container and manages the application's beans.
- `@Component` tells Spring to create and manage a class as a bean.
- Dependency Injection allows Spring to provide required objects instead of creating them manually with `new`.
- Spring beans use Singleton scope by default, so repeated lookups return the same object.

### Learnings
- Spring manages object creation and dependencies for the application.
- `StudentService` can use `Student` without manually constructing it.
- Spring Boot reduces the configuration needed to start a Spring application.

### Next Step
- Learn Spring configuration and different ways to define and inject beans.

---

## Task 04 - Spring XML Demo Project

### Objective
Learn how to configure Spring using XML-based bean configuration and understand the basics of dependency injection without using annotations.

### Concepts Covered
- Spring XML configuration
- `applicationContext.xml`
- Bean definition in XML
- Dependency injection via XML
- Spring container setup
- Service and repository decoupling

### Project Used
- `04-SpringXMLDemo`

### What I Did
- Created a Spring project configured with XML bean definitions.
- Defined beans in `applicationContext.xml` for the model, repository, and service layers.
- Injected dependencies using Spring XML configuration.
- Loaded the container using `ClassPathXmlApplicationContext`.
- Accessed the service bean and verified dependency injection was working.

### Key Notes
- XML configuration is one of the classic ways to define Spring beans.
- Beans are declared in an XML file and then loaded by the Spring container.
- Dependency injection can be configured by constructor or setter injection.
- Spring separates object creation from business logic, making code easier to manage.

### Learnings
- Spring can work without annotations using XML configuration.
- The container reads bean definitions and wires dependencies automatically.
- XML-based Spring still follows the same IoC and DI principles as annotation-based configuration.
- This project helped me understand the core idea behind Spring bean wiring.

### Next Step
- Learn Spring Java-based configuration and compare it with XML-based configuration.

---

## Task 05 - Spring Java Configuration Demo Project

### Objective
Learn how to configure a Spring application using Java classes instead of XML files, and understand how the Spring container manages beans through configuration classes.

### Concepts Covered
- Java-based Spring configuration
- `@Configuration`
- `@Bean`
- Dependency injection in configuration classes
- Spring container initialization
- Bean wiring without XML

### Project Used
- `05-SpringConfigDemo`

### What I Did
- Created a Spring project that uses Java configuration instead of XML.
- Defined a configuration class using `@Configuration`.
- Registered beans using `@Bean` methods.
- Injected dependencies through the Spring container.
- Created the application context with `AnnotationConfigApplicationContext`.
- Verified that Spring successfully created and wired the required beans.

### Key Notes
- `@Configuration` marks a class as a Spring configuration source.
- `@Bean` tells Spring to create and manage an object as a bean.
- Java-based configuration is cleaner and more modern than XML configuration.
- Spring can use annotation-based and Java-based setup together depending on the project needs.

### Learnings
- Java configuration is more readable and maintainable than XML.
- Bean dependencies can be resolved without hardcoding object creation.
- Spring containers can be initialized from Java classes, which is the modern standard in many applications.
- This project helped me transition from XML configuration to the modern Spring style.

### Next Step
- Continue learning advanced Spring concepts such as component scanning, annotations, and real application architecture.

---

## How to Add the Next Task
When I finish another daily task, I will add a new section below this one like this:

```md
## Task 04 - <Task Name>

### Objective
...

### Concepts Covered
- ...

### Project Used
- ...

### What I Did
- ...

### Key Notes
- ...

### Learnings
- ...

---
```

This keeps the repository organized and makes it easy to track my daily learning progress.
