import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@test",
        plugin = {"pretty", "html:test-output",
                "json:target/cucumber-reports/cucumber.json"
        },
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class RunnerTest {

}

