package ru.levelp.at.lesson15.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PostgresDatabaseConnection {

    private static PostgresDatabaseConnection instance;

    @Getter
    private Connection connection;

    private void createConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Postgres JDBC driver was not found. Include it into your classpath.");
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/levelp",
                "postgres", "example");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            instance = null;
        }
    }

    public static PostgresDatabaseConnection getInstance() {
        if (instance == null) {
            instance = new PostgresDatabaseConnection();
            instance.createConnection();
        }
        return instance;
    }
}
