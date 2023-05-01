package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefs","base"},
        dryRun = false,
        monochrome = true,
        plugin = {"pretty" , "html:target/cucumberr-report.html"}
)


public class TestRunner {
}
