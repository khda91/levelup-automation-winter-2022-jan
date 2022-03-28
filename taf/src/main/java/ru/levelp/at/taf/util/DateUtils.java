package ru.levelp.at.taf.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateUtils {

    public static String convertDateToFormat(String date, String dateFormat) {
        return ZonedDateTime.parse(date).format(DateTimeFormatter.ofPattern(dateFormat));
    }
}
