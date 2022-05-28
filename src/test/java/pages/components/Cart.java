package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Cart {

    private final SelenideElement cartTitle = $(".cart-title");

    private final ElementsCollection products = $$(".sc-1mwp4sh-5.bqoDDR");

    @Step("Check that cart is open")
    public Cart checkOpen(){
        cartTitle.shouldBe(Condition.visible);
        return this;
    }

    @Step("Check that cart contains product")
    public Cart checkContainsProduct(String product){
        products.shouldHave(itemWithText(product));
        return this;
    }
}
