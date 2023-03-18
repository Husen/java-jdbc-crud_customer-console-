package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    static String dbhost = "localhost";
    static String dbPort = "5432"; // your port on sql
    static String dbName = "belajar_jdbc"; // your name db
    static String dbUser = "";
    static String dbPassword = "";
    private String dbUrl = String.format("jdbc:postgresql://%s:%s/%s", dbhost, dbPort, dbName);

    Connection connection;

    public Connection connect() {
        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("Connect to database...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public void close() {
        try {
            connection.close();
            System.out.println("Connection is shutdown...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
