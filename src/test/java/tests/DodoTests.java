package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Dodo pizza tests")
public class DodoTests extends TestBase {

    @DisplayName("Open main page Test")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Main Page")
    @Story("Open main page")
    @Owner(owner)
    @Link(value = "Dodo Pizza", url = "https://dodopizza.ru")
    @Test
    void openMainSpbTest() {
        mainPage.openPage();
    }
}
