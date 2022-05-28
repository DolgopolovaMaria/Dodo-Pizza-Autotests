package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.components.Cart;
import pages.components.Pizza;

import java.lang.annotation.*;

@DisplayName("Dodo pizza card tests")
public class PizzaCardTests extends TestBase {

    @DisplayName("Choose pizza size:")
    @OptionsAnnotation
    @ParameterizedTest(name = "{0}")
    @EnumSource(Pizza.Size.class)
    void chooseSizeTest(Pizza.Size size) {
        mainPage.openPage().openPizza(cheesePizza).chooseSize(size).checkSize(size);
    }

    @DisplayName("Choose pizza dough:")
    @OptionsAnnotation
    @ParameterizedTest(name = "{0}")
    @EnumSource(Pizza.Dough.class)
    void chooseDoughTest(Pizza.Dough dough) {
        mainPage.openPage().openPizza(cheesePizza).chooseDough(dough).checkDough(dough);
    }

    @DisplayName("Change pizza size several times")
    @OptionsAnnotation
    @Test
    void changeSizeSeveralTimesTest() {
        mainPage.openPage().openPizza(cheesePizza).chooseSize(Pizza.Size.SMALL)
                .chooseSize(Pizza.Size.LARGE).chooseSize(Pizza.Size.MEDIUM).checkSize(Pizza.Size.MEDIUM);
    }

    @DisplayName("Change pizza dough several times")
    @OptionsAnnotation
    @Test
    void changeDoughSeveralTimesTest() {
        mainPage.openPage().openPizza(cheesePizza).chooseDough(Pizza.Dough.THIN).chooseDough(Pizza.Dough.TRADITIONAL)
                .checkDough(Pizza.Dough.TRADITIONAL);
    }

    @DisplayName("Choose pizza size and dough")
    @OptionsAnnotation
    @Test
    void chooseSizeAndDoughTest() {
        mainPage.openPage().openPizza(cheesePizza).configurePizza(Pizza.Size.LARGE, Pizza.Dough.THIN)
                .checkPizzaOptions(Pizza.Size.LARGE, Pizza.Dough.THIN);
    }

    @DisplayName("Add pizza to shopping cart")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Pizza information card")
    @Story("Add to shopping cart")
    @BaseAnnotation
    @Test
    void addToCartTest() {
        mainPage.openPage().openPizza(cheesePizza).addToCart();
        Cart cart = mainPage.goToCart();
        cart.checkOpen().checkContainsProduct(cheesePizza);
    }

    @DisplayName("Special test to be failed")
    @OptionsAnnotation
    @Test
    void failedTest() {
        mainPage.openPage().openPizza(cheesePizza).chooseSize(Pizza.Size.LARGE).checkSize(Pizza.Size.SMALL);
    }

    @Documented
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Pizza information card")
    @Story("Choose Pizza Options")
    @BaseAnnotation
    public @interface OptionsAnnotation { }
}
