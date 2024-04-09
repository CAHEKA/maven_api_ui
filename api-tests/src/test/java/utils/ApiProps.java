package utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/test/resources/config.properties"
})
public interface ApiProps extends Config {
    @Key("baseUrl")
    String baseUrl();
}