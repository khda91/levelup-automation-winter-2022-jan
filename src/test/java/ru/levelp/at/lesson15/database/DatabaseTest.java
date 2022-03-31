package ru.levelp.at.lesson15.database;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson15.database.model.UsersDto;

public class DatabaseTest {

    private Connection connection;

    @BeforeMethod
    public void setUp() {
        connection = PostgresDatabaseConnection.getInstance().getConnection();
    }

    @Test
    public void testSelectDataFromTables() {
        final String selectData = "SELECT u.id, u.first_name, u.last_name, u.age, s.value as sex "
            + "FROM users u INNER JOIN \"sex\" s ON u.sex_id = s.id";

        try (var statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(selectData);

            while (resultSet.next()) {
                System.out.println(String.format("ResultSet [\n"
                        + "id -> %d\n"
                        + "first_name -> %s\n"
                        + "last_name -> %s\n"
                        + "age -> %d\n"
                        + "sex -> %s", resultSet.getInt("id"), resultSet.getString(2),
                    resultSet.getString("last_name"), resultSet.getInt(4),
                    resultSet.getString("sex")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectAllUsers() {
        var expected = List.of(UsersDto.builder()
                                       .id(1)
                                       .firstName("first_name1")
                                       .lastName("last_name2")
                                       .age(20)
                                       .sex("MALE")
                                       .build());

        var userDatabaseService = new UsersDatabaseService(connection);
        var actual = userDatabaseService.getAllUsers();

        System.out.println("actual -> " + actual);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void insertUser() {
        final var faker = new Faker();
        var userDatabaseService = new UsersDatabaseService(connection);

        userDatabaseService.insertUser(faker.name().firstName(), faker.name().lastName(), 25, 2);

        var actual = userDatabaseService.getAllUsers();

        System.out.println("actual -> " + actual);
    }

    @AfterMethod
    public void tearDown() {
        PostgresDatabaseConnection.getInstance().close();
        connection = null;
    }
}
