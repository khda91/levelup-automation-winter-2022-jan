package ru.levelp.at.lesson15.database.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class UsersDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String sex;
}
