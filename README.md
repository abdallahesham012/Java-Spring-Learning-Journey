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

## How to Add the Next Task
When I finish another daily task, I will add a new section below this one like this:

```md
## Task 03 - <Task Name>

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
