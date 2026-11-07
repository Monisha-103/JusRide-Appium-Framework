package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.IntStream;

public class OTPPage {
    private final AndroidDriver driver;

    private static final By OTP_TITLE = AppiumBy.androidUIAutomator(
            "new UiSelector().textContains(\"OTP\")");
    private static final By SUBMIT_BUTTON = By.id("com.milespeak.jusridemobile:id/submit");
    private static final int OTP_LENGTH = 6;
    private static final Duration MANUAL_OTP_TIMEOUT = Duration.ofMinutes(2);

    public OTPPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isOtpScreenVisible() {
        return TestUtils.isDisplayed(driver, OTP_TITLE) || isOtpInputDisplayed();
    }

    public void enterOtpManually() {
        System.out.println("Enter the six-digit OTP manually on the device.");
        new WebDriverWait(driver, MANUAL_OTP_TIMEOUT)
                .until(ignored -> isOtpComplete());
    }

    public void clickSubmit() {
        TestUtils.click(driver, SUBMIT_BUTTON);
    }

    private boolean isOtpInputDisplayed() {
        return TestUtils.isDisplayed(driver, otpField(0));
    }

    private boolean isOtpComplete() {
        return IntStream.range(0, OTP_LENGTH)
                .allMatch(index -> {
                    WebElement field = driver.findElement(otpField(index));
                    String value = field.getAttribute("text");
                    return value != null && !value.isBlank();
                });
    }

    private By otpField(int index) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.widget.EditText\").instance(" + index + ")");
    }
}
