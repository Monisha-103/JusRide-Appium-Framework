package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class WelcomePage {
    private final AndroidDriver driver;

    private static final By MOBILE_NUMBER_INPUT = By.id("com.milespeak.jusridemobile:id/edtMobileNumber");
    private static final By AGREE_CHECKBOX = By.id("com.milespeak.jusridemobile:id/cbAgree");
    private static final By CONTINUE_BUTTON = By.id("com.milespeak.jusridemobile:id/btnContinue");
    private static final By SKIP_BUTTON = By.id("com.milespeak.jusridemobile:id/loginskip");

    public WelcomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void enterMobileNumber(String mobileNumber) {
        TestUtils.type(driver, MOBILE_NUMBER_INPUT, mobileNumber);
    }

    public void tapAgreeCheckbox() {
        TestUtils.click(driver, AGREE_CHECKBOX);
    }

    public void tapContinue() {
        TestUtils.click(driver, CONTINUE_BUTTON);
    }

    public void tapSkip() {
        TestUtils.click(driver, SKIP_BUTTON);
    }

    public boolean isWelcomePageDisplayed() {
        return TestUtils.isDisplayed(driver, MOBILE_NUMBER_INPUT)
                || TestUtils.isDisplayed(driver, CONTINUE_BUTTON);
    }

    public void tapGetStarted() {
        tapContinue();
    }

    public void tapLogin() {
        tapSkip();
    }

    public boolean isWelcomeScreenVisible() {
        return isWelcomePageDisplayed();
    }
}