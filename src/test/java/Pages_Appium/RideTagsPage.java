package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class RideTagsPage {
    private final AndroidDriver driver;

    private static final By TIME_TRIAL =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Time Trial\")");
    private static final By ZONE_THREE =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Zone 3\")");
    private static final By NEXT_BUTTON =
            By.id("com.milespeak.jusridemobile:id/nextPlanButton");

    public RideTagsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void selectTimeTrial() {
        TestUtils.click(driver, TIME_TRIAL);
    }

    public void selectZoneThree() {
        TestUtils.click(driver, ZONE_THREE);
    }

    public void tapNext() {
        TestUtils.click(driver, NEXT_BUTTON);
    }
}
