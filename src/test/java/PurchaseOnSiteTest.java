import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.*;
import utils.TestsEach;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PurchaseOnSiteTest extends TestsEach {


    @Epic("TESTING FOR https://www.saucedemo.com/ tasks")
    @Feature(value = "Tests for task 6")
    @Severity(SeverityLevel.BLOCKER)
    @Description("In this test we will login with correct credentials. When we logged we see page with products.")
    @Story(value = "Test for login with correct credentials")
    @Step
    @Test
    @DisplayName("User login on website.")
    public void testUserLogin() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage()
                .login()
                .titleHeader.shouldBe(Condition.visible);
        Assertions.assertEquals("PRODUCTS", loginPage.titleHeader.getText(),
                "It's not products page");
    }

    @Epic("TESTING FOR https://www.saucedemo.com/ tasks")
    @Feature(value = "Tests for task 6")
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will add one item in shopping cart. When we added it, a value in shopping cart will be 1. ")
    @Story(value = "Test opportunity add item in shopping cart")
    @Step
    @Test
    @DisplayName("User add an item to the shopping cart.")
    public void testAddItem() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage()
                .login();
        ProductsPage productsPage = new ProductsPage()
                .addItem();
        Assertions.assertEquals("1", productsPage.cartLink.getText());
    }

    @Epic("TESTING FOR https://www.saucedemo.com/ tasks")
    @Feature(value = "Tests for task 6")
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will cancel a purchase. When we canceled a purchase we see page with products.")
    @Story(value = "Test opportunity cancel a purchase")
    @Step
    @Test
    @DisplayName("User cancel his purchase.")
    public void testCancelPurchase() throws IOException {
        LoginPage loginPage = new LoginPage()
                .openLoginPage()
                .login();
        ProductsPage productsPage = new ProductsPage();
        productsPage.addItem().cartLink.click();
        UserCartPage userCartPage = new UserCartPage();
        userCartPage.checkoutButton.click();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage();
        checkoutInfoPage.enterInfo();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutOverviewPage.clickCancel();
        Assertions.assertEquals("PRODUCTS", loginPage.titleHeader.getText(),
                "It's not products page");
    }

    @Epic("TESTING FOR https://www.saucedemo.com/ tasks")
    @Feature(value = "Tests for task 6")
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will remove an item. When we removed it , a value in shopping cart will be 0.")
    @Story(value = "Test opportunity remove an item in shopping cart")
    @Step
    @Test
    @DisplayName("User remove an item from the shopping cart.")
    public void testRemoveItem() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage()
                .login();
        ProductsPage productsPage = new ProductsPage();
        productsPage.addItem()
                .addItem()
                .cartLink.click();
        UserCartPage userCartPage = new UserCartPage();
        userCartPage.removeItem()
                .removeItem();
        Assertions.assertEquals(0, userCartPage.sizeItemsFromCartAfter);
    }

    @Epic("TESTING FOR https://www.saucedemo.com/ tasks")
    @Feature(value = "Tests for task 6")
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test, we will check the correct subtotal cost of the shopping cart.The sum of all items should be equal to the subtotal cost.")
    @Story(value = "Test the correct subtotal cost")
    @Step
    @Test
    @DisplayName("Check to correct the summary cost of a shopping cart.")
    public void testCheckSum() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage()
                .login();
        ProductsPage productsPage = new ProductsPage();
        productsPage
                .addItem()
                .addItem()
                .cartLink.click();
        UserCartPage userCartPage = new UserCartPage();
        userCartPage.checkoutButton.click();
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage();
        checkoutInfoPage.enterInfo();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutOverviewPage.getSubtotalSum();
        Assertions.assertEquals(String.valueOf(checkoutOverviewPage.sum),checkoutOverviewPage.subtotalCost,
                "Subtotal cost of a shopping cart is wrong.");
    }
}
