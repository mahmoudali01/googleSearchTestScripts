package Gen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDef.Hook;

import java.time.Duration;
import java.util.List;

public class Wait {
    private static WebDriverWait explicitWait(int Time) {

        return new WebDriverWait(Hook.driver, Duration.ofSeconds(Time));
    }

    public static void waitVisibilityOfElement(WebElement element, int Time) {
        WebDriverWait wait = explicitWait(Time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitToBeClickableElement(WebElement element, int Time) {
        WebDriverWait wait = explicitWait(Time);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }
}
