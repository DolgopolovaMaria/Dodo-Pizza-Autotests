package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:local.properties",
        "classpath:remote.properties"
})
public interface ProjectConfig extends Config {
    @Key("remote")
    @DefaultValue("false")
    boolean remote();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("baseUrl")
    //@DefaultValue("https://dodopizza.ru/")
    String baseUrl();

    @Key("user")
    String user();
    @Key("password")
    String password();
    @Key("remoteUrl")
    String remoteUrl();
}
