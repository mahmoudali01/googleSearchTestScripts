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

    public static void textPresenceElement(WebElement element, String text, int Time) {
        WebDriverWait wait = explicitWait(Time);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static Boolean waitToBeInvisibleElement(WebElement element, int Time) {
        WebDriverWait wait = explicitWait(Time);
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void WaitAllToBeVisibleList(List<WebElement> element, int Time) {
        WebDriverWait wait = explicitWait(Time);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static void waitAllElementsToBeInvisibleList(List<WebElement> element, int Time) {
        WebDriverWait wait = explicitWait(Time);
        wait.until(ExpectedConditions.invisibilityOfAllElements(element));
    }
}
