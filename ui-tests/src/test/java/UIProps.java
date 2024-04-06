import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/test/resources/config.properties"
})
public interface UIProps extends Config {
    @Key("CHROME_VERSION")
    String chromeVersion();
    @Key("selenoidUrl")
    String selenoidUrl();
}