
package Pages_Appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourCartPage2 {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private static final By SELECT_SLOT =
            By.id("com.milespeak.jusridemobile:id/btnSelectSlot");

    // Store selection screen locator
    private static final By STORE_BRANCH =
            By.id("com.milespeak.jusridemobile:id/llServiceBranchBg");

    private static final By ANNA_NAGAR_BRANCH =
            By.xpath(
                    "//*[@resource-id='com.milespeak.jusridemobile:id/llServiceBranchBg']" +
                            "[.//*[contains(@text,'Anna Nagar') " +
                            "or contains(@content-desc,'Anna Nagar')]]"
            );

    public YourCartPage2(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver, Duration.ofSeconds(30));
    }

    public void tapSelectSlot() {
        WebElement selectSlotButton = wait.until(
                ExpectedConditions.elementToBeClickable(SELECT_SLOT));

        System.out.println("Select Store displayed: "
                + selectSlotButton.isDisplayed());

        System.out.println("Select Store enabled: "
                + selectSlotButton.isEnabled());

        System.out.println("Select Store text: "
                + selectSlotButton.getText());

        selectSlotButton.click();

        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.presenceOfElementLocated(
                            ANNA_NAGAR_BRANCH),
                    ExpectedConditions.presenceOfElementLocated(
                            STORE_BRANCH)
            ));

            System.out.println(
                    "Store selection screen opened successfully.");

        } catch (TimeoutException e) {
            throw new TimeoutException(
                    "Store selection screen was not detected after clicking Select Store."
                            + "\nCurrent screen source:\n"
                            + driver.getPageSource(),
                    e);
        }
    }

    public boolean isStoreSelectionPageDisplayed() {
        return !driver.findElements(STORE_BRANCH).isEmpty();
    }

    public void selectAnnaNagar() {
        WebElement annaNagar = wait.until(
                ExpectedConditions.elementToBeClickable(
                        ANNA_NAGAR_BRANCH));

        annaNagar.click();

        System.out.println("Anna Nagar branch selected successfully.");
    }
}
