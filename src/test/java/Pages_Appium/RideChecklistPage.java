package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class RideChecklistPage {
    private final AndroidDriver driver;

    private static final By PUNCTURE_REPAIR_KIT =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Punture repair kit\")");
    private static final By COMPLETE_BUTTON =
            By.id("com.milespeak.jusridemobile:id/complete_but");

    public RideChecklistPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void selectPunctureRepairKit() {
        TestUtils.click(driver, PUNCTURE_REPAIR_KIT);
    }

    public void tapNext() {
        TestUtils.click(driver, COMPLETE_BUTTON);
    }
}
