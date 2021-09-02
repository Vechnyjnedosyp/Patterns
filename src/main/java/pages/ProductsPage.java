package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage extends LoginPage {

    public String addToCartButton = "button[class = 'btn btn_primary btn_small btn_inventory']";
    public String itemDescription = "div[class = 'inventory_item_description']";
    public SelenideElement tableBody = $("div[class = 'inventory_list']");
    public SelenideElement cartLink = $("a[class = 'shopping_cart_link']");
    public int sizeItemCollection = 0;
    public int numberOfItems = 0;

    @Step("Click the 'Add' button to buy an item.")
    public ProductsPage addItem() {
        tableBody.shouldBe(Condition.visible);
        ElementsCollection itemCollection = tableBody.$$(itemDescription);
        sizeItemCollection = itemCollection.size();
        if(numberOfItems < sizeItemCollection){
            itemCollection.get(numberOfItems).$(By.cssSelector(addToCartButton)).click();
            numberOfItems++;
        }
        return this;
    }
}
