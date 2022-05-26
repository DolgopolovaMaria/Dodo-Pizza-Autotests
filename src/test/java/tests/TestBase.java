package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import helpers.DriverSettings;
import org.junit.jupiter.api.BeforeAll;
import pages.MainPage;

public class TestBase {

    final static String owner = "Mariya Dolgopolova";

    MainPage mainPage = new MainPage();

    @BeforeAll
    static void setUp() {
        DriverSettings.configure();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }




}
