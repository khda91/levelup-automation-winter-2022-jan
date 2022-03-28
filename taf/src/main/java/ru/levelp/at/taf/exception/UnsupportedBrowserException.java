package ru.levelp.at.taf.exception;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;
import ru.levelp.at.taf.service.driver.BrowserName;

public class UnsupportedBrowserException extends RuntimeException {

    public UnsupportedBrowserException() {
        super("Unsupported browser. Supported browsers are "
            + Arrays.stream(BrowserName.values())
                    .map(name -> name.name().toLowerCase(Locale.ROOT))
                    .collect(Collectors.joining(", ")));
    }
}
