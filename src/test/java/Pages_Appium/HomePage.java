package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HomePage {
    private final AndroidDriver driver;

    private static final By PLUS_BUTTON =
            By.id("com.milespeak.jusridemobile:id/fab");

    private static final By PLAN_BUTTON =
            By.id("com.milespeak.jusridemobile:id/fab_plan");

    private static final By GROUP_BUTTON =
            By.id("com.milespeak.jusridemobile:id/fab_group");

    private static final By JUSCARD_BUTTON =
            By.id("com.milespeak.jusridemobile:id/fab_wowcard");

    private static final By EVENTS_BUTTON =
            By.id("com.milespeak.jusridemobile:id/fab_events");

    private static final By CONNECT_WITH_STRAVA_BUTTON =
            AppiumBy.accessibilityId("Connect with Strava");
    private static final By STRAVA_AUTHORIZE_BUTTON = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"com.strava:id/authorize_button\")");
    private static final By SEARCH_BUTTON =
            By.id("com.milespeak.jusridemobile:id/open_search_button");
    private static final By SEARCH_TEXT_FIELD =
            By.id("com.milespeak.jusridemobile:id/search_src_text");
    private static final By MAHE_SEARCH_SUGGESTION = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"com.milespeak.jusridemobile:id/linear_memdetail\").instance(2)");
    private static final By FOLLOW_BUTTON =
            By.id("com.milespeak.jusridemobile:id/but_Inspire");
    private static final By REQUEST_RIDE_BUTTON =
            By.id("com.milespeak.jusridemobile:id/request_Ride");

    private static final By MORE_ICON = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"com.milespeak.jusridemobile:id/navigation_bar_item_icon_view\").instance(3)");
    private static final By EXPLORE_ICON = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"com.milespeak.jusridemobile:id/navigation_bar_item_content_container\").instance(2)");
    private static final By SERVICE_ICON = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"com.milespeak.jusridemobile:id/navigation_bar_item_content_container\").instance(1)");

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tapPlus() {
        TestUtils.click(driver, PLUS_BUTTON);
    }

    public void tapPlan() {
        TestUtils.click(driver, PLAN_BUTTON);
    }

    public void tapGroup() {
        TestUtils.click(driver, GROUP_BUTTON);
    }

    public void tapJuscard() {
        TestUtils.click(driver, JUSCARD_BUTTON);
    }

    public void tapEvents() {
        TestUtils.click(driver, EVENTS_BUTTON);
    }

    public void tapSearch() {
        TestUtils.click(driver, SEARCH_BUTTON);
    }

    public void searchForMahe(String searchTerm) {
        TestUtils.type(driver, SEARCH_TEXT_FIELD, searchTerm);
    }

    public void selectMaheSearchSuggestion() {
        TestUtils.click(driver, MAHE_SEARCH_SUGGESTION);
    }

    public void tapFollow() {
        TestUtils.click(driver, FOLLOW_BUTTON);
    }

    public void tapRequestRide() {
        TestUtils.click(driver, REQUEST_RIDE_BUTTON);
    }

    public void tapConnectWithStrava() {
        TestUtils.click(driver, CONNECT_WITH_STRAVA_BUTTON);
    }

    public void scrollToAuthorizeStrava() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().resourceId(\"com.strava:id/authorize_button\"))"));
    }

    public void tapAuthorizeStrava() {
        TestUtils.click(driver, STRAVA_AUTHORIZE_BUTTON);
    }

    public void refreshHomePage() {
        TestUtils.waitForVisible(driver, PLUS_BUTTON, Duration.ofSeconds(30));

        Dimension screenSize = driver.manage().window().getSize();
        int centerX = screenSize.getWidth() / 2;
        int startY = (int) (screenSize.getHeight() * 0.2);
        int endY = (int) (screenSize.getHeight() * 0.8);

        new Actions(driver)
                .moveToLocation(centerX, startY)
                .clickAndHold()
                .moveToLocation(centerX, endY)
                .release()
                .perform();
    }

    public void tapMore() {
        TestUtils.click(driver, MORE_ICON);
    }

    public void tapExplore() {
        TestUtils.click(driver, EXPLORE_ICON);
    }

    public void tapService() {
        TestUtils.click(driver, SERVICE_ICON);
    }
}
