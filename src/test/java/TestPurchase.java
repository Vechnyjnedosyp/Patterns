import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestPurchase {

    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("User add an item to the shopping cart.")
    public void addItem() throws IOException {
        new LoginPage().openLoginPage().login();
        ProductsPage productsPage = new ProductsPage()
                .addItem();
        Assertions.assertEquals("1", productsPage.cartLink.getText());
    }
}
