import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestCancelPurchase {

    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("User cancel his purchase.")
    public void cancelPurchase() throws IOException {
        LoginPage loginPage = new LoginPage()
                .openLoginPage()
                .login();
        ProductsPage productsPage = new ProductsPage();
        UserCartPage userCartPage = new UserCartPage();
        productsPage.addItem()
                    .cartLink.click();
        userCartPage.checkoutButton.click();
        new CheckoutInfoPage().enterInfo();
        new CheckoutOverviewPage().cancelButton.click();
        Assertions.assertEquals("PRODUCTS", loginPage.titleHeader.getText(),
                "It's not products page");
    }
}
