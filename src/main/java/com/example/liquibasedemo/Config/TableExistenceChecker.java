package com.example.liquibasedemo.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.sql.*;


@Component
public class TableExistenceChecker {

    @Value("${spring.datasource.url}")
    private static String JDBC_URL = "jdbc:postgresql://localhost:5433/liquibasetest";

    @Value("${spring.datasource.username}")
    private static String USERNAME="postgres";

    @Value("${spring.datasource.password}")
    private static String PASSWORD="postgres";

    public boolean areTablesExist() {
//        return isTableExist("users") && isTableExist("company");
        boolean usersTableExists = isTableExist("users");
        boolean companyTableExists = isTableExist("company");

        System.out.println("Table 'users' exists: " + usersTableExists);
        System.out.println("Table 'company' exists: " + companyTableExists);

        boolean result = usersTableExists && companyTableExists;

        return result;
    }

    private static boolean isTableExist(String tableName) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            DatabaseMetaData metadata = connection.getMetaData();
            ResultSet resultSet = metadata.getTables(null, null, tableName, null);

            // If the result set has at least one row, the table exists
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
            System.out.println("Exception occured while creating table");
            return false; // Assume table doesn't exist in case of an exception
        }
    }
}
