package Pages_Appium;

import Utils_Appium.TestDataUtils;
import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

public class BookingSlotPage {
    private final AndroidDriver driver;

    private static final By HOME_BOOKING_DATE =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"" + TestDataUtils.get("homeBookingDate") + "\")");

    private static final By HOME_BOOKING_TIME =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"" + TestDataUtils.get("homeBookingTime") + "\")");

    private static final By JBC_PICKUP_BOOKING_DATE =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"" + TestDataUtils.get("jbcPickupBookingDate") + "\")");

    private static final By JBC_PICKUP_BOOKING_TIME =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"" + TestDataUtils.get("jbcPickupBookingTime") + "\")");

    private static final By USER_DROP_BOOKING_DATE =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"" + TestDataUtils.get("userDropBookingDate") + "\")");

    private static final By USER_DROP_BOOKING_TIME =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"" + TestDataUtils.get("userDropBookingTime") + "\")");

    private static final By NEXT_PAGE_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btn_next_page");

    public BookingSlotPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void selectHomeBookingDate() {
        TestUtils.click(driver, HOME_BOOKING_DATE);
    }

    public void selectHomeBookingTime() {
        TestUtils.click(driver, HOME_BOOKING_TIME);
    }

    public void selectJbcPickupBookingDate() {
        TestUtils.click(driver, JBC_PICKUP_BOOKING_DATE);
    }

    public void selectJbcPickupBookingTime() {
        TestUtils.click(driver, JBC_PICKUP_BOOKING_TIME);
    }

    public void selectUserDropBookingDate() {
        TestUtils.click(driver, USER_DROP_BOOKING_DATE);
    }

    public void selectUserDropBookingTime() {
        TestUtils.click(driver, USER_DROP_BOOKING_TIME);
    }

    public void tapNextPage() {
        TestUtils.click(driver, NEXT_PAGE_BUTTON);
    }

    public boolean isBookingSlotPageDisplayed() {
        try {
            TestUtils.waitForVisible(driver, NEXT_PAGE_BUTTON, Duration.ofSeconds(30));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
