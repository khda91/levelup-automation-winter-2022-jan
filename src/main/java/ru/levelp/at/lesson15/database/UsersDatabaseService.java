package ru.levelp.at.lesson15.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ru.levelp.at.lesson15.database.model.UsersDto;

public class UsersDatabaseService {

    private static final String SELECT_ALL_USERS =
        "SELECT u.id, u.first_name, u.last_name, u.age, s.value as sex FROM users u INNER JOIN sex s ON u.sex_id = s.id";

    private static final String SELECT_USER_BY_ID =
        "SELECT u.id, u.first_name, u.last_name, u.age, s.value as sex FROM users u INNER JOIN sex s ON u.sex_id = s.id";

    private static final String INSERT_USER =
        "INSERT INTO users (first_name, last_name, age, sex_id) VALUES (?, ?, ?, ?)";

    private Connection connection;

    public UsersDatabaseService(Connection connection) {
        this.connection = connection;
    }

    public List<UsersDto> getAllUsers() {
        List<UsersDto> results = new ArrayList<>();
        try (var statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);

            while (resultSet.next()) {
                results.add(UsersDto.builder()
                                    .id(resultSet.getInt("id"))
                                    .firstName(resultSet.getString("first_name"))
                                    .lastName(resultSet.getString("last_name"))
                                    .age(resultSet.getInt("age"))
                                    .sex(resultSet.getString("sex"))
                                    .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public void insertUser(String firstName, String lastName, int age, int sexId) {
        try (var statement = connection.prepareStatement(INSERT_USER)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.setInt(4, sexId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
