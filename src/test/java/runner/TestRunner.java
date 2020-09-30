package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/woolies_challenge/api", "src/test/java/com/woolies_challenge/checkout"},
        glue = {"com.woolies_challenge.stepdef"},
        plugin = {"html:target/site/cucumber-pretty", "json:target/cucumber.json"}
)
public class TestRunner {
}
