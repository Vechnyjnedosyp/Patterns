import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestLogin {

    @BeforeEach
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }


    @Test
    @DisplayName("User login on website.")
    public void userLogin() throws IOException {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage()
                 .login()
                 .titleHeader.shouldBe(Condition.visible);
        Assertions.assertEquals("PRODUCTS", loginPage.titleHeader.getText(),
                "It's not products page");
    }

}
