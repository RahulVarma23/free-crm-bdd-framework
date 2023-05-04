package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefs","base"},
        dryRun = false,
        monochrome = true,
        plugin = {"pretty" , "html:target/cucumber-report.html"}
)

public class TestRunner {
    @BeforeClass
    public static void cleanUp() {
        String directoryToClean = ".//logs";
        File file = new File(directoryToClean);
        try {
            FileUtils.cleanDirectory(file);
        } catch (IOException e) {
            throw new RuntimeException("Directory not found" +e);
        }
    }
}
