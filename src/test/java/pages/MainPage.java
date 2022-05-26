package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement
        headerDelivery = $("span.header__about-slogan-text"),
        headerCity = $(".header__about-slogan-text_locality");

    @Step("Open main Saint-Petersburg page")
    public MainPage openPage(){
        Selenide.open("/peterburg");
        headerDelivery.shouldHave(Condition.text("Доставка пиццы"));
        headerCity.shouldHave((Condition.text("Санкт-Петербург")));

        return this;
    }
}
