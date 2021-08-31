package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;

public class Hooks {

    @Before
    public void beforeTest(Scenario scenario) {
        System.out.println("--- Старт сценария '" + scenario.getName() + "' ---");
    }

    @After
    public void afterTest(Scenario scenario) {
        String screenshotName = scenario.getName().replace(" ","_");
        if (scenario.isFailed()) {
            System.out.println("--- Сценарий '" + scenario.getName() + "' провалился ---");
            byte[] screenshotAsBytes = Selenide.screenshot(OutputType.BYTES);
            scenario.attach(screenshotAsBytes, "image/png", screenshotName);
        } else {
            System.out.println("--- Сценарий '" + scenario.getName() + "' выполнен успешно ---");
        }
    }
}
