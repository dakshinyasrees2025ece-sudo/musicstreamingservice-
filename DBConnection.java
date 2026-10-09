package musicstreaming.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection()
            throws SQLException {

        String url =
            "jdbc:mysql://localhost:3306/musicstreaming-db";
        String user = "root";
        String password = "root";

        return DriverManager.getConnection(
            url, user, password);
    }

    public static void main(String[] args) {
        try (Connection con = getConnection()) {
            System.out.println(
                "MySQL Connected Successfully!");
        } catch (SQLException e) {
            System.out.println(
                "Connection Failed: " + e.getMessage());
        }
    }
}