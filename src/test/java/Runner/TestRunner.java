package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import StepDef.Hook;


@CucumberOptions(
        features = "src\\main\\resources\\Features",
        glue = {"StepDef"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@regression"



)

public class TestRunner extends AbstractTestNGCucumberTests {
        @Parameters({"browserName"})
        @BeforeTest
        public void beforeTest(String browserName) throws InterruptedException {
                Hook.setBrowser(browserName);
        }

}