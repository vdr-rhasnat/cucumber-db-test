package steps;

import io.cucumber.java.en.Given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTestStep {
    @Given("Sql server connection")
    public void sqlServerConnection() {
        /*String url = "jdbc:sqlserver://wvd-3;databaseName=Contact";
        String user = "sa";
        String password = "sa123";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }*/

        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=Contact;"
                        + "user=sa;"
                        + "password=sa123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=15;";

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            System.out.println("Connected");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        /*String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Contact;user=sa;password=sa123";

        try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                System.out.println("Connected");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }*/
    }
}
