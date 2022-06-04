package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.Cart;
import pages.components.Pizza;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private final ElementsCollection
            productNames = $$("[data-gtm-id=product-title]"),
            sections = $$(".sc-176km0j-0.iPVMjx.ymp2tw-5.kZstOz");

    private final SelenideElement
        headerDelivery = $("span.header__about-slogan-text"),
        headerCity = $(".header__about-slogan-text_locality"),
        cartButton = $(byTagAndText("button", "Корзина")),
        cartQuantity = $("[data-testid=cart-button__quantity]");

    @Step("Open main Saint-Petersburg page")
    public MainPage openPage(){
        Selenide.open("/peterburg");
        headerDelivery.shouldHave(Condition.text("Доставка пиццы"));
        headerCity.shouldHave((Condition.text("Санкт-Петербург")));

        return this;
    }

    @Step("Open pizza information")
    public Pizza openPizza(String pizzaName){
        SelenideElement pizzaElement = productNames.find(Condition.text(pizzaName));
        pizzaElement.click();
        Pizza pizza = new Pizza(pizzaName);
        pizza.checkName();

        return pizza;
    }

    @Step("Go to section: {section}")
    public MainPage goToSection(String section){
        SelenideElement sectionElement = sections.findBy(Condition.text(section));
        sectionElement.click();

        return this;
    }

    @Step("Check that section is open: {section}")
    public MainPage checkThatSectionOpen(String section){
        SelenideElement sectionElement = sections.findBy(Condition.text(section));
        sectionElement.shouldHave(attribute("data-active", "true"));

        return this;
    }

    @Step("Go to cart")
    public Cart goToCart(){
        cartButton.click();

        return new Cart();
    }

    @Step("Check cart quantity")
    public MainPage checkCartQuantity(int value){
        cartQuantity.shouldHave(exactText(String.valueOf(value)));

        return this;
    }
}
