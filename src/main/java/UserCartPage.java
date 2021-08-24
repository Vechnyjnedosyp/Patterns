import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UserCartPage extends LoginPage {

    String cartItemDescription = "div[class = 'cart_item']";
    String removeButton = "button[class = 'btn btn_secondary btn_small cart_button']";
    SelenideElement itemsCartBody = $("div[class= 'cart_list']");
    SelenideElement checkoutButton = $("#checkout");
    int sizeItemsFromCartBefore = 0;
    int numRemovedItems = 0;
    int sizeItemsFromCartAfter = 0;

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