import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {

        /*
         * ========================= JDBC Workflow =========================
         * 1. Import java.sql package.
         * 2. Load the JDBC Driver (Automatic in modern JDBC versions).
         * 3. Establish a connection with the database.
         * 4. Create a Statement or PreparedStatement.
         * 5. Execute the SQL query.
         * 6. Process the returned result.
         * 7. Close all resources.
         * ================================================================
         */

        // Database Connection Information
        String url = "jdbc:postgresql://localhost:5432/Demo";
        String username = "postgres";
        String password = "0127";

        /*
         * =====================================================
         *                 READ DATA (SELECT)
         * =====================================================
         */

        // Create a connection to PostgreSQL
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established.");

        // SQL Query
        String sql = "SELECT * FROM student";

        /*
         * Statement
         * ---------
         * Used for executing static SQL queries.
         * Not recommended when user input exists because
         * it is vulnerable to SQL Injection.
         */
        Statement statement = connection.createStatement();

        /*
         * executeQuery()
         * --------------
         * Used ONLY with SELECT statements.
         * Returns ResultSet.
         */
        ResultSet rs = statement.executeQuery(sql);

        // Loop through every returned row
        while (rs.next()) {

            // Column Index starts from 1
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int marks = rs.getInt(3);

            System.out.println(id + " - " + name + " - " + marks);
        }

        // Always close resources
        rs.close();
        statement.close();
        connection.close();

        System.out.println("Connection Closed.\n");



        /*
         * =====================================================
         *                INSERT / UPDATE / DELETE
         * =====================================================
         */

        /*
         * executeUpdate()
         * ----------------
         * Used with:
         * INSERT
         * UPDATE
         * DELETE
         *
         * Returns:
         * Number of affected rows.
         */

        connection = DriverManager.getConnection(url, username, password);

        // INSERT Example
        // sql = "INSERT INTO student VALUES (4,'Abdalla',100)";

        // UPDATE Example
        // sql = "UPDATE student SET marks = 98 WHERE sid = 4";

        // DELETE Example
        // sql = "DELETE FROM student WHERE sid = 4";

        statement = connection.createStatement();

        int rowsAffected = statement.executeUpdate(sql);

        System.out.println("Rows Affected : " + rowsAffected);

        statement.close();
        connection.close();

        System.out.println("Connection Closed.\n");



        /*
         * =====================================================
         *              PreparedStatement Example
         * =====================================================
         */

        /*
         * Why PreparedStatement?
         *
         * ✔ Faster for repeated execution.
         * ✔ Prevents SQL Injection.
         * ✔ Automatically handles escaping special characters.
         * ✔ Best practice whenever values come from the user.
         */

        int sid = 5;
        String sname = "Ta7a";
        int studentMarks = 52;

        sql = "INSERT INTO student VALUES (?,?,?)";

        connection = DriverManager.getConnection(url, username, password);

        /*
         * ? represents placeholders.
         * We replace each placeholder using setXXX().
         */
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, sid);
        preparedStatement.setString(2, sname);
        preparedStatement.setInt(3, studentMarks);

        /*
         * executeUpdate()
         * Returns number of inserted rows.
         */
        int insertedRows = preparedStatement.executeUpdate();

        System.out.println("Inserted Rows : " + insertedRows);

        preparedStatement.close();
        connection.close();

        System.out.println("Connection Closed.");


    }
}