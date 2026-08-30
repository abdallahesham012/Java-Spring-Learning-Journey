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
- Learn how to insert, update, and delete records using JDBC.
- Move to Hibernate and understand the ORM approach.

---

## How to Add the Next Task
When I finish another daily task, I will add a new section below this one like this:

```md
## Task 02 - <Task Name>

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
