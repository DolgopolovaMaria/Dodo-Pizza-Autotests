package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import helpers.DriverSettings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.MainPage;

import java.lang.annotation.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.Attachments.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestBase {

    final static String owner = "Mariya Dolgopolova";

    final String pizzaName = "Ветчина и сыр",
            pizzaApiBodyId = "12036",
            pizzaApiHeaderId = "000D3A22FA54A81411E99F2BD4DA1614";


    MainPage mainPage = new MainPage();

    @BeforeAll
    static void setUp() {
        DriverSettings.configure();

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    @Step("Check logs, add attachments, close webdriver")
    void afterEach(){
        addAttachments();
        consoleShouldNotHaveErrors();
        closeWebDriver();
    }

    @Step("Add attachments")
    void addAttachments(){
        addScreenshot();
        addPageSource();
        addBrowserConsoleLogs();
    }

    @Step("Check that console log contains no errors")
    public void consoleShouldNotHaveErrors(){
        String consoleLogs = getConsoleLogs();
        String errorText = "SEVERE";

        assertThat(consoleLogs).doesNotContain(errorText);
    }

    @Documented
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Owner(owner)
    @Link(value = "Dodo Pizza", url = "https://dodopizza.ru")
    public @interface BaseAnnotation { }

}
