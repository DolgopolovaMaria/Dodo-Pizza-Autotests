package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class Pizza {

    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    public enum Dough {
        TRADITIONAL,
        THIN
    }

    private final String
        cartButtonText = "Добавить в корзину",
        smallSize = "25 см",
        mediumSize = "30 см",
        largeSize = "35 см",
        traditionalDough = "традиционное тесто",
        thinDough = "тонкое тесто";

    private final SelenideElement
        nameHeader = $(".sc-15fdqut-12.egklNr"),
        addToCartButton = $(withTagAndText("button", cartButtonText)),
        small = $("[data-testid=menu__pizza_size_1]"),
        medium = $("[data-testid=menu__pizza_size_2]"),
        large = $("[data-testid=menu__pizza_size_3]"),
        traditional = $("[data-testid=menu__pizza_dough_1]"),
        thin = $("[data-testid=menu__pizza_dough_2]"),
        information = $(".sc-15fdqut-15.btdNiV");

    private String name;


    public Pizza(String name){
        this.name = name;
    }

    @Step("Check pizza name")
    public Pizza checkName(){
        nameHeader.shouldHave(exactText(name));
        return this;
    }

    @Step("Add pizza to shopping cart")
    public void addToCart(){
        addToCartButton.click();
    }

    @Step("Choose pizza size: {size}")
    public Pizza chooseSize(Size size){
        switch (size){
            case SMALL:
                small.click();
                break;
            case MEDIUM:
                medium.click();
                break;
            case LARGE:
                large.click();
                break;
        }
        return this;
    }

    @Step("Choose pizza dough: {dough}")
    public Pizza chooseDough(Dough dough){
        if(dough.equals(Dough.TRADITIONAL)){
            traditional.click();
        }
        else{
            thin.click();
        }
        return this;
    }

    @Step("Choose pizza options: {size}, {dough}")
    public Pizza configurePizza(Size size, Dough dough){
        chooseSize(size);
        chooseDough(dough);
        return this;
    }

    @Step("Check pizza size: {size}")
    public Pizza checkSize(Size size){
        switch (size){
            case SMALL:
                information.shouldHave(text(smallSize));
                break;
            case MEDIUM:
                information.shouldHave(text(mediumSize));
                break;
            case LARGE:
                information.shouldHave(text(largeSize));
                break;
        }
        return this;
    }

    @Step("Check pizza dough: {dough}")
    public Pizza checkDough(Dough dough){
        if(dough.equals(Dough.TRADITIONAL)){
            information.shouldHave(text(traditionalDough));
        }
        else{
            information.shouldHave(text(thinDough));
        }
        return this;
    }

    @Step("Check pizza options: {size}, {dough}")
    public Pizza checkPizzaOptions(Size size, Dough dough){
        checkSize(size);
        checkDough(dough);
        return this;
    }
}
