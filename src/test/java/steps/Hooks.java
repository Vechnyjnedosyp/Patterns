package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void beforeTest(Scenario scenario) {
        System.out.println("--- Старт сценария '" + scenario.getName() + "' ---");


    }

    @After
    public void afterTest(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("--- Сценарий '" + scenario.getName() + "' провалился ---");
        } else {
            System.out.println("--- Сценарий '" + scenario.getName() + "' выполнен успешно ---");
        }
    }
}
