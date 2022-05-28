package helpers;

import com.codeborne.selenide.Configuration;
import config.Project;
import config.ProjectConfig;
import org.aeonbits.owner.ConfigFactory;

public class DriverSettings {
    public static void configure() {
        Configuration.browser = Project.config.browser();
        Configuration.browserVersion = Project.config.browserVersion();
        Configuration.browserSize = Project.config.browserSize();
        Configuration.baseUrl = Project.config.baseUrl();

        if (Project.isRemoteWebDriver()) {
            String user = Project.config.user();
            String password = Project.config.password();
            String remoteUrl = Project.config.remoteUrl();
            // https://user1:1234@selenoid.autotests.cloud/wd/hub
            Configuration.remote = "https://" + user + ":" + password + "@" + remoteUrl;
            System.out.println(Configuration.remote);
        }
    }
}
