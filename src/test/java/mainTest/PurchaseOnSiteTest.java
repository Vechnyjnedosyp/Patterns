//package mainTest;
//
//import com.codeborne.selenide.Condition;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import pages.*;
//import utils.TestsEach;
//
//import java.io.IOException;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class PurchaseOnSiteTest extends TestsEach {
//
//    @Test
//    @DisplayName("User login on website.")
//    public void testUserLogin() throws IOException {
//        LoginPage loginPage = new LoginPage();
//        loginPage.openLoginPage()
//                .login()
//                .titleHeader.shouldBe(Condition.visible);
//        Assertions.assertEquals("PRODUCTS", loginPage.titleHeader.getText(),
//                "It's not products page");
//    }
//
//    @Test
//    @DisplayName("User add an item to the shopping cart.")
//    public void testAddItem() throws IOException {
//        LoginPage loginPage = new LoginPage();
//        loginPage.openLoginPage()
//                .login();
//        ProductsPage productsPage = new ProductsPage()
//                .addItem();
//        Assertions.assertEquals("1", productsPage.cartLink.getText());
//    }
//
//    @Test
//    @DisplayName("User cancel his purchase.")
//    public void testCancelPurchase() throws IOException {
//        LoginPage loginPage = new LoginPage()
//                .openLoginPage()
//                .login();
//        ProductsPage productsPage = new ProductsPage();
//        productsPage.addItem().cartLink.click();
//        UserCartPage userCartPage = new UserCartPage();
//        userCartPage.checkoutButton.click();
//        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage();
//        checkoutInfoPage.enterInfo();
//        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
//        checkoutOverviewPage.cancelButton.click();
//        Assertions.assertEquals("PRODUCTS", loginPage.titleHeader.getText(),
//                "It's not products page");
//    }
//
//    @Test
//    @DisplayName("User remove an item from the shopping cart.")
//    public void testRemoveItem() throws IOException {
//        LoginPage loginPage = new LoginPage();
//        loginPage.openLoginPage()
//                .login();
//        ProductsPage productsPage = new ProductsPage();
//        productsPage.addItem()
//                .addItem()
//                .cartLink.click();
//        UserCartPage userCartPage = new UserCartPage();
//        userCartPage.removeItem()
//                .removeItem();
//        Assertions.assertEquals(0, userCartPage.sizeItemsFromCartAfter);
//    }
//
//    @Test
//    @DisplayName("Check to correct the summary cost of a shopping cart.")
//    public void testCheckSum() throws IOException {
//        LoginPage loginPage = new LoginPage();
//        loginPage.openLoginPage()
//                .login();
//        ProductsPage productsPage = new ProductsPage();
//        productsPage
//                .addItem()
//                .addItem()
//                .cartLink.click();
//        UserCartPage userCartPage = new UserCartPage();
//        userCartPage.checkoutButton.click();
//        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage();
//        checkoutInfoPage.enterInfo();
//        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
//        checkoutOverviewPage.getSubtotalSum();
//        Assertions.assertEquals(String.valueOf(checkoutOverviewPage.sum),checkoutOverviewPage.subtotalCost,
//                "Subtotal cost of a shopping cart is wrong.");
//    }
//}
