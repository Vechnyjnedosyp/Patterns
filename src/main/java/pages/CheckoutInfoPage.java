package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutInfoPage extends LoginPage {

    SelenideElement firstNameField = $("#first-name");
    SelenideElement lastNameField = $("#last-name");
    SelenideElement postalCodeField = $("#postal-code");
    SelenideElement continueButton = $("#continue");

    @Step("Fill information in fields")
    public CheckoutInfoPage enterInfo() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/properties/checkoutInfo.properties"));
        firstNameField.sendKeys(props.getProperty("checkoutInfo.firstName"));
        lastNameField.sendKeys(props.getProperty("checkoutInfo.lastName"));
        postalCodeField.sendKeys(props.getProperty("checkoutInfo.postalCode"));
        continueButton.click();
        return this;
    }
}
