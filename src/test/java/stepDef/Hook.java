package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hook {
    public static WebDriver driver;
    private static String browser;
    public static void  setBrowser(String browser) {
        Hook.browser = browser;
    }
    @Before
    public void openBrowser() {
        if(browser.equals("Chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        }
        else if(browser.equals("Firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
        }
        else if(browser.equals("Edge")){
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(edgeOptions);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

//    @AfterStep
//    public void TakeScreen(Scenario scenario) {
//        String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//
//        byte[] decodeScreenshot = Base64.decodeBase64(screenshot);
//        scenario.attach(decodeScreenshot, "img/png", scenario.getName());
//
//        if (scenario.getStatus().toString().equalsIgnoreCase("PASSED")) {
//            ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, "Step Screen", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
//        } else if (scenario.getStatus().toString().equalsIgnoreCase("SKIPPED")) {
//            ExtentCucumberAdapter.getCurrentStep().log(Status.SKIP, "Step Screen", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
//        } else if (scenario.isFailed()) {
//            ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, "Step Screen", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
//        }
//
//    }


    @After
    public void TearDown(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        driver.quit();
    }
}