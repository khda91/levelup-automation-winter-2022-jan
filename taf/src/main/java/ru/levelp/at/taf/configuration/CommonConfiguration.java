package ru.levelp.at.taf.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigFactory;

@LoadPolicy(LoadType.MERGE)
@Sources({"classpath:config/${env}/dev.properties",
    "system:properties",
    "system:env"})
public interface CommonConfiguration extends Config {

    @Key("browser.name")
    String browserName();

    @Key("site.url")
    String siteUrl();

    @Key("explicitly.wait.timeout.in.seconds")
    int explicitlyWaitTimeoutInSeconds();

    static CommonConfiguration getInstance() {
        return ConfigFactory.create(CommonConfiguration.class);
    }
}
