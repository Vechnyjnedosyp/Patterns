import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage extends LoginPage {

    SelenideElement cancelButton = $("#cancel");
    SelenideElement itemsCartBody = $("div[class= 'cart_list']");
    String itemPriceField = "div[class= 'inventory_item_price']";
    double sum = 0.0;
    String subtotalCost = $("div[class= 'summary_subtotal_label']").getText().replaceAll("[Item oal:$]",
                    "");

    public void getSubtotalSum() {
        ElementsCollection itemsCost = itemsCartBody.$$(itemPriceField);
        for (SelenideElement selenideElement : itemsCost) {
            sum += Double.parseDouble(selenideElement.getText().replaceAll("[$]", ""));
        }
        System.out.println("Subtotal sum = " + sum);
    }
}
