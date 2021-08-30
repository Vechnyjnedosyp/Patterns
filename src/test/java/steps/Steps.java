package steps;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pages.CheckoutInfoPage;
import pages.CheckoutOverviewPage;
import pages.ProductsPage;
import pages.UserCartPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Steps {

    @Допустим("^открыта страница \"([^\"]*)\"$")
    public void openPage(String pageURL) {
        open(pageURL);
        String currentPageURL = getWebDriver().getCurrentUrl();
        assertEquals(pageURL, currentPageURL, "Значения ссылок не сопадают");
    }

    @Допустим("^в строку 'Username' введено значение \"([^\"]*)\"$")
    public void enterUsername(String text) {
        $("#user-name").setValue(text);
    }

    @Допустим("^в строку 'Password' введено значение \"([^\"]*)\"$")
    public void enterPassword(String text) {
        $("#password").setValue(text);
    }

    @Допустим("^нажата кнопка \"([^\"]*)\"$")
    public void clickOnButton(String button) {
        $(By.id(button)).click();
    }

    @Тогда("^откроется страница с товарами \"([^\"]*)\"$")
    public void checkLinkName(String title) {
        String actualTitle = $(By.cssSelector("span[class = 'title']")).getText();
        assertEquals(title, actualTitle, "Названия заголовков не совпадают");
    }

    @Допустим("^добавлен \"([^\"]*)\" товар в корзину$")
    public void addItem(String num) {
        ProductsPage productsPage = new ProductsPage();
        int x = Integer.parseInt(num);
        for (int i = 0; i < x; i++){
            productsPage.addItem();
        }
        System.out.println("productsPage.numberOfItems " + productsPage.numberOfItems);
        System.out.println("productsPage.sizeItemCollection " + productsPage.sizeItemCollection);
    }

    @Тогда("^в корзине находится \"([^\"]*)\" товар$")
    public void checkCart(String numItem) {
        String actualNum = $(By.cssSelector("span[class = 'shopping_cart_badge']")).getText();
        assertEquals(numItem, actualNum);
    }

    @Допустим("^нажата ссылка \"([^\"]*)\"$")
    public void clickOnLink(String link) {
        $(By.cssSelector("a[class = '" + link +"_link'")).click();
    }

    @Затем("^удален \"([^\"]*)\" товар из корзины$")
    public void removeItem(String num) {
        UserCartPage userCartPage = new UserCartPage();
        int x = Integer.parseInt(num);
        for (int i = 0; i < x; i++) {
            userCartPage.removeItem();
        }
    }

    @Допустим("^вводится информация$")
    public void enterInfo() throws IOException {
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage();
        checkoutInfoPage.enterInfo();
    }

    @Тогда("^отменяется покупка$")
    public void cancelPurchase() {
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutOverviewPage.cancelButton.click();
    }

    @Тогда("^в корзине осталось \"([^\"]*)\" товаров$")
    public void afterCheckCart(String numItem) {
        UserCartPage userCartPage = new UserCartPage();
        String actualNum = String.valueOf(userCartPage.sizeItemsFromCartAfter);
        assertEquals(numItem, actualNum);
    }

    @Тогда("^проверяется точность итоговой суммы до налогообложения$")
    public void checkSum() {
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutOverviewPage.getSubtotalSum();
        Assertions.assertEquals(String.valueOf(checkoutOverviewPage.sum),checkoutOverviewPage.subtotalCost,
                "Subtotal cost of a shopping cart is wrong.");
    }
}
