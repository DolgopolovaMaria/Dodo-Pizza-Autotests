package tests;

import com.codeborne.selenide.Configuration;
import helpers.DriverSettings;
import org.junit.jupiter.api.BeforeAll;
import pages.MainPage;

public class TestBase {

    MainPage mainPage = new MainPage();

    @BeforeAll
    static void setUp() {
        DriverSettings.configure();
    }




}
