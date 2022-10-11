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

            // TODO: use statetment to create and use a database with the name "PE2"
            
            LOGGER.log(Level.INFO, "Created PE2 database");

            // TODO: create table in newly created database
            
            LOGGER.log(Level.INFO, "Created table 'departments'! Inserting entries...");

            // TODO: fill table with entries
            

            // TODO: retrieve a ResultSet for the table content
            LOGGER.log(Level.INFO, "Starting SELECT query...");
            
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
