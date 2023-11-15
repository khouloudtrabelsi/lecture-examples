package de.unistuttgart.iste.pe2.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * This class contains examples of using the JDBC API to connect to a local MariaDB Server
 */
public class JDBCExamples {
    private static Logger LOGGER = Logger.getLogger(JDBCExamples.class.getName());
    private Connection connection;

    /**
     * Connects to MariaDB, executes examplary SQL statements and closes connection
     */
    public void runDemonstration() {

        // creates connection to a MariaDB installed on localhost
        boolean connected = this.connectToDB("jdbc:mariadb://localhost:3306", "root", "root");

        if (connected) {
            this.interactWithDB();
            this.closeConnectionToDB();
        }
    }

    /*
     * Connects to a database
     */
    private boolean connectToDB(String connectionString, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(connectionString, user, password);
            return true;
        } catch (SQLException exception) {
            LOGGER.log(Level.SEVERE, "Error code: " + exception.getErrorCode());
            LOGGER.log(Level.SEVERE, "Error message: " + exception.getMessage());
        }
        return false;
    }

    /*
     * Executes SQL statements
     */
    private void interactWithDB() {
        try {
            // create statement
            Statement statement = this.connection.createStatement();

            // create and use database
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS PE2;");
            statement.executeUpdate("USE PE2;");

            LOGGER.log(Level.INFO, "Created PE2 database");

            // drop table for demonstration purposes
            statement.executeUpdate("DROP TABLE IF EXISTS departments;");

            // create table in newly created database
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS departments (departmentId INTEGER PRIMARY KEY, departmentName VARCHAR(256), managerId INTEGER);");

            LOGGER.log(Level.INFO, "Created table 'departments'! Inserting entries...");

            // fill table
            statement.executeUpdate(
                    "INSERT INTO departments (departmentId, departmentName, managerId) VALUES (20, 'Controlling', 41573);");
            statement.executeUpdate(
                    "INSERT INTO departments (departmentId, departmentName, managerId) VALUES (21, 'Marketing', 69547);");

            LOGGER.log(Level.INFO, "Inserting via PreparedStatement...");
            // insert content into table using a prepared statement
            String preparedSQLstring =
                    "INSERT INTO departments (departmentId, departmentName, managerId) VALUES (?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(preparedSQLstring);
            preparedStatement.setInt(1, 22);
            preparedStatement.setString(2, "R&D");
            preparedStatement.setInt(3, 69004);
            int rowCount = preparedStatement.executeUpdate();
            LOGGER.log(Level.INFO, "Number of affected rows: " + rowCount);

            LOGGER.log(Level.INFO, "Starting SELECT query...");
            // retrieve content of table
            ResultSet result =
                    statement.executeQuery("SELECT * FROM departments WHERE departmentId > 10");

            // iterate through results
            while (result.next()) {
                String identification = result.getString("departmentName");
                LOGGER.log(Level.INFO, "departments identification: " + identification);
            }
            result.close();

        } catch (SQLException exception) {
            LOGGER.log(Level.SEVERE, "Error code: " + exception.getErrorCode());
            LOGGER.log(Level.SEVERE, "Error message: " + exception.getMessage());
        }
    }

    /*
     * Closes connection to the database
     */
    private void closeConnectionToDB() {
        try {
            this.connection.close();
        } catch (SQLException exception) {
            LOGGER.log(Level.SEVERE, "Error code: " + exception.getErrorCode());
            LOGGER.log(Level.SEVERE, "Error message: " + exception.getMessage());
        }
    }
}
