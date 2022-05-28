package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayName("Dodo pizza main page tests")
public class MainPageTests extends TestBase {

    private final String
        drinks = "Напитки",
        deserts = "Десерты",
        pizza = "Пицца";

    @DisplayName("Open main page")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Main page")
    @Story("Open main page")
    @BaseAnnotation
    @Test
    void openMainSpbTest() {
        mainPage.openPage();
    }

    @DisplayName("Open pizza card")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Pizza information card")
    @Story("Open pizza information card")
    @BaseAnnotation
    @Test
    void openPizzaCardTest() {
        mainPage.openPage().openPizza(cheesePizza);
    }

    @DisplayName("Go to section:")
    @Severity(SeverityLevel.MINOR)
    @Feature("Main page")
    @Story("Go to section")
    @BaseAnnotation
    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {
            drinks,
            deserts
    })
    void goToSectionTest(String section) {
        mainPage.openPage().goToSection(section).checkThatSectionOpen(section);
    }

    @DisplayName("Go to sections several times")
    @Severity(SeverityLevel.MINOR)
    @Feature("Main page")
    @Story("Go to section")
    @BaseAnnotation
    @Test
    void goToSectionSeveralTimesTest() {
        mainPage.openPage().goToSection(drinks).checkThatSectionOpen(drinks)
                .goToSection(deserts).checkThatSectionOpen(deserts)
                .goToSection(pizza).checkThatSectionOpen(pizza);
    }
}
