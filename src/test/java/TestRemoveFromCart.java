import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestRemoveFromCart {

    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("User remove an item from the shopping cart.")
    public void removeItem() throws IOException {
        new LoginPage()
                .openLoginPage()
                .login();
        new ProductsPage()
                .addItem()
                .addItem()
                .cartLink.click();
        UserCartPage userCartPage = new UserCartPage();
        userCartPage.removeItem()
                    .removeItem();
        Assertions.assertEquals(0, userCartPage.sizeItemsFromCartAfter);
    }
}
