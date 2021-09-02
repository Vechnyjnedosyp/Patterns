package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class UserCartPage extends LoginPage {

    String cartItemDescription = "div[class = 'cart_item']";
    String removeButton = "button[class = 'btn btn_secondary btn_small cart_button']";
    SelenideElement itemsCartBody = $("div[class= 'cart_list']");
    public SelenideElement checkoutButton = $("#checkout");
    int sizeItemsFromCartBefore = 0;
    int numRemovedItems = 0;
    public int sizeItemsFromCartAfter = 0;

    @Step("Click the 'Remove' button to delete an item.")
    public UserCartPage removeItem() {
        ElementsCollection itemsFromCart = itemsCartBody.$$(cartItemDescription);
        sizeItemsFromCartBefore = itemsFromCart.size();
        numRemovedItems = sizeItemsFromCartBefore - 1;

        if (sizeItemsFromCartAfter <= sizeItemsFromCartBefore) {
            itemsFromCart.get(numRemovedItems).$(removeButton).click();
            sizeItemsFromCartAfter = itemsFromCart.size();
        }
        return this;
    }
}