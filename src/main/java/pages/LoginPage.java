package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    SelenideElement loginField = $("#user-name");
    SelenideElement passwordField = $("#password");
    SelenideElement buttonLogin = $("input[class='submit-button btn_action']");
    public SelenideElement titleHeader = $("span[class = 'title']");

    public LoginPage login() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/user.properties"));
        loginField.sendKeys(props.getProperty("user.username"));
        passwordField.sendKeys(props.getProperty("user.password"));
        buttonLogin.click();
        return this;
    }

    public LoginPage openLoginPage() {
        open("https://www.saucedemo.com/");
        return this;
    }
}
