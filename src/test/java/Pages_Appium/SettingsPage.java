package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SettingsPage {
    private final AndroidDriver driver;

    private static final By LOGOUT_OPTION =
            By.id("com.milespeak.jusridemobile:id/txt_logout");
    private static final By LOGOUT_CONFIRM_BUTTON =
            By.id("com.milespeak.jusridemobile:id/but_logout");

    public SettingsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isLogoutDisplayed() {
        return TestUtils.isDisplayed(driver, LOGOUT_OPTION);
    }

    public void tapLogout() {
        TestUtils.click(driver, LOGOUT_OPTION);
    }

    public void confirmLogout() {
        TestUtils.click(driver, LOGOUT_CONFIRM_BUTTON);
    }
}
