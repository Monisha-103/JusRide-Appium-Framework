package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ServiceWelcomePage {
    private final AndroidDriver driver;

    private static final By NEXT_BUTTON = By.id("com.milespeak.jusridemobile:id/text_next");
    private static final By CHENNAI_CITY = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Chennai\")");
    private static final By PINCODE_INPUT = By.id("com.milespeak.jusridemobile:id/edtPincode");
    private static final By CHECK_BUTTON = By.id("com.milespeak.jusridemobile:id/btnCheck");
    private static final By WARRANTY_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btnWarranty");
    private static final By ACTIVATE_AMC_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btnActivateAMC");

    public ServiceWelcomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tapNext() {
        TestUtils.click(driver, NEXT_BUTTON);
    }

    public void selectChennai() {
        TestUtils.click(driver, CHENNAI_CITY);
    }

    public void enterPincode(String pincode) {
        if (pincode == null || !pincode.matches("\\d{6}")) {
            throw new IllegalArgumentException("Pincode must contain exactly six digits");
        }
        TestUtils.type(driver, PINCODE_INPUT, pincode);
    }

    public void tapCheck() {
        TestUtils.click(driver, CHECK_BUTTON);
    }

    public void tapWarranty() {
        TestUtils.click(driver, WARRANTY_BUTTON);
    }

    public void tapActivateAMC() {
        TestUtils.click(driver, ACTIVATE_AMC_BUTTON);
    }

    public boolean isPincodeScreenDisplayed() {
        return TestUtils.isDisplayed(driver, PINCODE_INPUT)
                || TestUtils.isDisplayed(driver, CHECK_BUTTON);
    }
}
