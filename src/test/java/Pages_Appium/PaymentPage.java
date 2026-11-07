
package Pages_Appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private static final By WALLETS_OPTION =
            By.id("com.milespeak.jusridemobile:id/clOtherOptions");

    private static final int WALLETS_OPTION_INDEX = 3;

    private static final By FREECHARGE_PAYMENT_OPTION =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Freecharge PayLater | UPI | Wallet\")"
            );

    private static final By PROCEED_TO_PAY_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btnProceedToPay");

    public PaymentPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(30)
        );
    }

    private WebElement waitForVisible(
            By locator,
            String elementName
    ) {
        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            );

        } catch (TimeoutException e) {
            throw new TimeoutException(
                    elementName + " was not visible within 30 seconds."
                            + "\nLocator: " + locator
                            + "\nCurrent activity: " + driver.currentActivity()
                            + "\nCurrent package: " + driver.getCurrentPackage()
                            + "\nCurrent page source:\n" + driver.getPageSource(),
                    e
            );
        }
    }

    private void clickElement(
            By locator,
            String elementName
    ) {
        try {
            WebElement element = wait.until(
                    ExpectedConditions.elementToBeClickable(locator)
            );

            element.click();

            System.out.println(
                    elementName + " clicked successfully."
            );

        } catch (TimeoutException e) {
            throw new TimeoutException(
                    "Timeout while waiting to click: " + elementName
                            + "\nLocator: " + locator
                            + "\nCurrent activity: " + driver.currentActivity()
                            + "\nCurrent package: " + driver.getCurrentPackage()
                            + "\nCurrent page source:\n" + driver.getPageSource(),
                    e
            );
        }
    }

    public void waitForPaymentPage() {
        try {
            wait.until(d ->
                    !d.findElements(WALLETS_OPTION).isEmpty()
                            || !d.findElements(PROCEED_TO_PAY_BUTTON).isEmpty()
            );

            System.out.println("Payment page displayed.");

        } catch (TimeoutException e) {
            throw new TimeoutException(
                    "Payment page was not displayed within 30 seconds."
                            + "\nCurrent activity: " + driver.currentActivity()
                            + "\nCurrent package: " + driver.getCurrentPackage()
                            + "\nCurrent page source:\n" + driver.getPageSource(),
                    e
            );
        }
    }

    public void selectWallets() {
        try {
            // Wait until the Wallets option elements are loaded.
            wait.until(d -> {
                List<WebElement> options =
                        d.findElements(WALLETS_OPTION);

                return options.size() > WALLETS_OPTION_INDEX
                        && options.get(WALLETS_OPTION_INDEX).isDisplayed()
                        && options.get(WALLETS_OPTION_INDEX).isEnabled();
            });

            List<WebElement> options =
                    driver.findElements(WALLETS_OPTION);

            System.out.println(
                    "Number of Wallets option elements found: "
                            + options.size()
            );

            WebElement walletsOption =
                    options.get(WALLETS_OPTION_INDEX);

            System.out.println(
                    "Selected option text: " + walletsOption.getText()
            );

            walletsOption.click();

            System.out.println(
                    "Wallets option clicked successfully."
            );

        } catch (TimeoutException | IndexOutOfBoundsException e) {
            throw new TimeoutException(
                    "Wallets option could not be located or clicked."
                            + "\nResource ID: " + WALLETS_OPTION
                            + "\nExpected zero-based index: "
                            + WALLETS_OPTION_INDEX
                            + "\nCurrent activity: " + driver.currentActivity()
                            + "\nCurrent package: " + driver.getCurrentPackage()
                            + "\nCurrent page source:\n" + driver.getPageSource(),
                    e
            );
        }
    }

    public void selectFreecharge() {
        clickElement(
                FREECHARGE_PAYMENT_OPTION,
                "Freecharge payment option"
        );
    }

    public void tapProceedToPay() {
        clickElement(
                PROCEED_TO_PAY_BUTTON,
                "Proceed to Pay button"
        );
    }

    public boolean isPaymentPageDisplayed() {
        try {
            wait.until(d ->
                    !d.findElements(WALLETS_OPTION).isEmpty()
                            || !d.findElements(PROCEED_TO_PAY_BUTTON).isEmpty()
            );

            return true;

        } catch (TimeoutException e) {
            System.out.println("Payment page is not displayed.");
            return false;
        }
    }
}
