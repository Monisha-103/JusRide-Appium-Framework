package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MorePage {
    private final AndroidDriver driver;

    private static final By SETTINGS_ICON =
            By.id("com.milespeak.jusridemobile:id/img_setting");
    private static final By LSS_BLOCK =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().resourceId(\"com.milespeak.jusridemobile:id/shop\")");

    public MorePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tapSettings() {
        TestUtils.click(driver, SETTINGS_ICON);
    }

    public void tapLssBlock() {
        TestUtils.click(driver, LSS_BLOCK);
    }
}
