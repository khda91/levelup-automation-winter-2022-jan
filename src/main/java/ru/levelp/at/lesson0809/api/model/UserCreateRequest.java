package ru.levelp.at.lesson0809.api.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class UserCreateRequest {

    private String name;
    private String job;
}
