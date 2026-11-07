package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CreateRideDetailsPage {
    private final AndroidDriver driver;

    private static final By AVERAGE_SPEED =
            By.id("com.milespeak.jusridemobile:id/avg_speed");
    private static final By RIDE_NAME =
            By.id("com.milespeak.jusridemobile:id/ridename");
    private static final By RIDE_DATE =
            By.id("com.milespeak.jusridemobile:id/ridedate");
    private static final By RIDE_DATE_OPTION =
            AppiumBy.accessibilityId("30 October 2026");
    private static final By START_TIME =
            By.id("com.milespeak.jusridemobile:id/starttime");
    private static final By START_TIME_OPTION =
            AppiumBy.accessibilityId("8");
    private static final By DATE_TIME_PICKER_OK =
            By.id("android:id/button1");
    private static final By NEXT_BUTTON =
            By.id("com.milespeak.jusridemobile:id/plan_ride_details_page_next");

    public CreateRideDetailsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void enterAverageSpeed(String speed) {
        TestUtils.type(driver, AVERAGE_SPEED, speed);
    }

    public void enterRideName(String rideName) {
        TestUtils.type(driver, RIDE_NAME, rideName);
    }

    public void scrollToRideDate() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().resourceId("
                        + "\"com.milespeak.jusridemobile:id/ridedate\"))"));
    }

    public void selectRideDate() {
        TestUtils.click(driver, RIDE_DATE);
        TestUtils.click(driver, RIDE_DATE_OPTION);
        TestUtils.click(driver, DATE_TIME_PICKER_OK);
    }

    public void selectStartTime() {
        TestUtils.click(driver, START_TIME);
        TestUtils.click(driver, START_TIME_OPTION);
        TestUtils.click(driver, DATE_TIME_PICKER_OK);
    }

    public void tapNext() {
        TestUtils.click(driver, NEXT_BUTTON);
    }
}
