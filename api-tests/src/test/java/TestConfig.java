import org.aeonbits.owner.Config;

@Config.Sources({"file:config.properties"})
public interface TestConfig extends Config {
    @Key("baseUrl")
    String baseUrl();
}