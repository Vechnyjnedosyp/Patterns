package steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import pages.ProductsPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Steps {

    @Допустим("^открыта страница \"([^\"]*)\"$")
    public void openPage(String pageURL) {
        open(pageURL);
        Configuration.startMaximized = true;
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
        $(By.id(button +"-button")).click();
    }

    @Тогда("^откроется страница с товарами \"([^\"]*)\"$")
    public void checkLinkName(String title) {
        String actualTitle = $(By.cssSelector("span[class = 'title']")).getText();
        assertEquals(title, actualTitle, "Названия заголовков не совпадают");
    }

    @Допустим("^добавлен товар в корзину$")
    public void addItem() {
        ProductsPage productsPage = new ProductsPage();
        productsPage.addItem();
    }

    @Тогда("^в корзине появится \"([^\"]*)\" товар$")
    public void checkCart(String numItem) {
        String actualNum = $(By.cssSelector("span[class = 'shopping_cart_badge']")).getText();
        assertEquals(numItem, actualNum);
    }
}
