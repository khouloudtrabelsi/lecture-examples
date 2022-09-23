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
        boolean connected = this.connectToDB("jdbc:mariadb://localhost:3306", "root", null);

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

            // create database
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS PE2;");
            statement.executeUpdate("USE PE2;");

            // drop table for demonstration purposes
            statement.executeUpdate("DROP TABLE IF EXISTS ABTEILUNG;");

            // create table in newly created database
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS ABTEILUNG (ABTEILUNGSNR INTEGER PRIMARY KEY, BEZEICHNUNG VARCHAR(256), ABTEILUNGSLEITER INTEGER);");

            // fill table
            statement.executeUpdate(
                    "INSERT INTO ABTEILUNG (ABTEILUNGSNR,BEZEICHNUNG,ABTEILUNGSLEITER) VALUES (20,'Controlling',41573);");
            statement.executeUpdate(
                    "INSERT INTO ABTEILUNG (ABTEILUNGSNR,BEZEICHNUNG,ABTEILUNGSLEITER) VALUES (21,'Marketing',69547);");

            // retrieve content of table
            ResultSet result = statement.executeQuery("SELECT * FROM ABTEILUNG WHERE ABTEILUNGSNR > 10");

            // iterate through results
            while (result.next()) {
                String identification = result.getString("BEZEICHNUNG");
                LOGGER.log(Level.INFO, "department identification: " + identification);
            }
            result.close();

            // retrieve content of table using a prepared statement
            String preparedSQLstring = "INSERT INTO ABTEILUNG (ABTEILUNGSNR,BEZEICHNUNG,ABTEILUNGSLEITER) VALUES (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(preparedSQLstring);
            preparedStatement.setInt(1, 22);
            preparedStatement.setString(2, "R&D");
            preparedStatement.setInt(3, 69004);
            int rowCount = preparedStatement.executeUpdate();
            LOGGER.log(Level.INFO, "Number of affected rows: " + rowCount);

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

    /*
     * Executes a group of statements as a transaction
     */
    private void executeStatementsAsTransaction() {
        try {
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();
            // Typical transaction example: Bank transfer from account A to account B
            // TODO: extend example
            connection.commit();

        } catch (SQLException exception) {
            LOGGER.log(Level.SEVERE, "Error code: " + exception.getErrorCode());
            LOGGER.log(Level.SEVERE, "Error message: " + exception.getMessage());
        }
    }
}
