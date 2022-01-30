package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import javax.xml.transform.Result;
import java.sql.*;

public class DBTestStep {
    private Connection connection;
    private String connectionStatus;

    @Given("Sql server connection")
    public void sqlServerConnection() {
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Contact;user=sa;password=sa123";

        try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            connection = DriverManager.getConnection(connectionUrl);
            System.out.println("Connected");
            connectionStatus = "Success";

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connectionStatus = "Error";
            //e.printStackTrace();
        }
    }

    @Then("I should get connection status {string}")
    public void iShouldGetConnectionStatus(String status) {
        Assert.assertEquals(status, connectionStatus);
    }

    @And("Table {string} should exists")
    public void tableShouldExists(String table) throws SQLException {
        boolean isTableExists;
        DatabaseMetaData dbm = connection.getMetaData();
        ResultSet tables = dbm.getTables(null, null, table, null);
        if (tables.next()) {
            isTableExists = true;
        }
        else {
            isTableExists = false;
        }

        Assert.assertTrue(isTableExists);
    }

    @And("I should get data from table")
    public void iShouldGetDataFromTable() throws SQLException {
        String sql = "select count(*) from Contacts";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        Assert.assertNotEquals(0, count);
    }
}
