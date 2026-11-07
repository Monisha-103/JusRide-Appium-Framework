
package Pages_Appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectStorePage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private static final By STORE_BRANCH =
            By.id("com.milespeak.jusridemobile:id/llServiceBranchBg");

    private static final By ANNA_NAGAR_BRANCH =
            By.xpath(
                    "//*[@resource-id='com.milespeak.jusridemobile:id/llServiceBranchBg']" +
                            "[.//*[contains(@text,'Anna Nagar') " +
                            "or contains(@content-desc,'Anna Nagar')]]"
            );

    private static final By NEXT_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btnNext");

    public SelectStorePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(30)
        );
    }

    public boolean isSelectStorePageDisplayed() {
        try {
            wait.until(
                    ExpectedConditions.presenceOfElementLocated(STORE_BRANCH)
            );

            System.out.println("Store selection page displayed.");
            return true;

        } catch (TimeoutException e) {
            System.out.println("Store selection page was not displayed.");
            System.out.println("Current page source:\n" + driver.getPageSource());
            return false;
        }
    }

    public void selectAnnaNagar() {
        clickElement(ANNA_NAGAR_BRANCH, "Anna Nagar branch");
    }

    public void tapNext() {
        clickElement(NEXT_BUTTON, "Next button");
    }

    private void clickElement(By locator, String elementName) {
        try {
            WebElement element = wait.until(
                    ExpectedConditions.elementToBeClickable(locator)
            );

            element.click();
            System.out.println(elementName + " clicked successfully.");

        } catch (TimeoutException e) {
            throw new TimeoutException(
                    "Timed out waiting for: " + elementName
                            + "\nLocator: " + locator
                            + "\nCurrent page source:\n" + driver.getPageSource(),
                    e
            );
        }
    }
}
