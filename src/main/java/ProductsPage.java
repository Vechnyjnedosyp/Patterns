import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage extends LoginPage {

    String addToCartButton = "button[class = 'btn btn_primary btn_small btn_inventory']";
    String itemDescription = "div[class = 'inventory_item_description']";
    SelenideElement tableBody = $("div[class = 'inventory_list']");
    SelenideElement cartLink = $("a[class = 'shopping_cart_link']");
    int sizeItemCollection = 0;
    int numberOfItems = 0;

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
