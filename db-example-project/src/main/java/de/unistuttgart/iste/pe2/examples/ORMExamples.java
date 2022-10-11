package de.unistuttgart.iste.pe2.examples;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import de.unistuttgart.iste.pe2.model.Department;

public class ORMExamples {
    private static Logger LOGGER = Logger.getLogger(ORMExamples.class.getName());
    private static int CONTROLLING_DEPARTMENT_ID = 20;
    private static int MARKETING_DEPARTMENT_ID = 21;

    private ConnectionSource connectionSource;
    private Dao<Department, Integer> departmentDao;

    /*
     * Runs code demonstrating the use of ORMLite.
     */
    public void runDemonstration() {
        // creates connection to a MariaDB installed on localhost
        boolean connected = this.connectToDB("jdbc:mariadb://localhost:3306/pe2", "root", "root");

        if (connected) {
            try {
                // TODO: instantiate the Database Access Object (DAO) for handling DB operations using the DaoManager
                this.departmentDao;

                // demonstrates operations using TableUtils class
                this.performTableOperations();

                // fill a create table with demo data
                this.fillTable();

                // retrieves and logs the content od the table
                this.retrieveTableContent();

                // closes connection to the database
                this.closeConnectionToDB();

            } catch (SQLException exception) {
                this.logSQLException(exception);
            }
        }
    }

    /*
     * Connects to a database
     */
    private boolean connectToDB(String connectionString, String user, String password) {
        try {
            this.connectionSource = new JdbcConnectionSource(connectionString, user, password);
            return true;
        } catch (SQLException exception) {
            this.logSQLException(exception);
        }
        return false;
    }

    /*
     * Closes connection to the database
     */
    private void closeConnectionToDB() {
        try {
            this.connectionSource.close();
        } catch (Exception exception) {
            LOGGER.log(Level.SEVERE, "Error message: " + exception.getMessage());
        }
    }

    /*
     * Creates a table. It also demostrate how to clear and drop a table.
     */
    private void performTableOperations() {
        try {
            // clear table for demonstration purposes
            TableUtils.clearTable(this.connectionSource, Department.class);

            // drop table for demonstration purposes
            TableUtils.dropTable(this.connectionSource, Department.class, true);
        } catch (SQLException exception) {
            this.logSQLException(exception);
        }

        try {
            // create table
            TableUtils.createTableIfNotExists(this.connectionSource, Department.class);
        } catch (SQLException exception) {
            this.logSQLException(exception);
        }
    }

    /*
     * Fills table with examplary data.
     */
    private void fillTable() {
        try {
            // TODO: fill table using this.departmentDao

        } catch (SQLException exception) {
            this.logSQLException(exception);
        }
    }

    /*
     * Shows examples retrieving the content of the table.
     */
    private void retrieveTableContent() {
        try {
            // TODO: retrieve table content using this.departmentDao

        } catch (SQLException exception) {
            this.logSQLException(exception);
        }
    }

    private void logSQLException(SQLException exception) {
        LOGGER.log(Level.SEVERE, "Error code: " + exception.getErrorCode());
        LOGGER.log(Level.SEVERE, "Error message: " + exception.getMessage());
    }
}
