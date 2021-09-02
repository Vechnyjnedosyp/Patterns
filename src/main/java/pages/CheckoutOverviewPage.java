package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage extends LoginPage {

    public SelenideElement cancelButton = $("#cancel");
    SelenideElement itemsCartBody = $("div[class= 'cart_list']");
    String itemPriceField = "div[class= 'inventory_item_price']";
    public double sum = 0.0;
    public String subtotalCost = $("div[class= 'summary_subtotal_label']").getText().replaceAll("[Item oal:$]",
                    "");

    @Step("Counting subtotal cost")
    public CheckoutOverviewPage getSubtotalSum() {
        ElementsCollection itemsCost = itemsCartBody.$$(itemPriceField);
        for (SelenideElement selenideElement : itemsCost) {
            sum += Double.parseDouble(selenideElement.getText().replaceAll("[$]", ""));
        }
        System.out.println("Subtotal sum = " + sum);
        return this;
    }

    @Step("Click the 'Cancel' button to cancel a purchase.")
    public CheckoutOverviewPage clickCancel(){
        cancelButton.click();
        return this;
    }
}
