package Utils_Appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestUtils {

    public static WebElement waitForVisible(AndroidDriver driver, By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(AndroidDriver driver, By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void click(AndroidDriver driver, By locator) {
        waitForClickable(driver, locator, Duration.ofSeconds(15)).click();
    }

    public static void type(AndroidDriver driver, By locator, String text) {
        WebElement element = waitForVisible(driver, locator, Duration.ofSeconds(15));
        element.clear();
        element.sendKeys(text);
    }

    public static boolean isDisplayed(AndroidDriver driver, By locator) {
        try {
            return waitForVisible(driver, locator, Duration.ofSeconds(5)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}