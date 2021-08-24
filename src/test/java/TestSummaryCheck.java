import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestSummaryCheck {

    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Check to correct the summary cost of a shopping cart.")
    public void checkSum() throws IOException {
        new LoginPage().openLoginPage().login();
        ProductsPage productsPage = new ProductsPage();
        productsPage
                .addItem()
                .addItem()
                .cartLink.click();
        new UserCartPage().checkoutButton.click();
        new CheckoutInfoPage().enterInfo();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutOverviewPage.getSubtotalSum();
        Assertions.assertEquals(String.valueOf(checkoutOverviewPage.sum),checkoutOverviewPage.subtotalCost,
                "Subtotal cost of a shopping cart is wrong.");
    }
}
