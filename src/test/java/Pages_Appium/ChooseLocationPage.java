package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ChooseLocationPage {
    private static final By SEARCH_FIELD =
            By.id("com.milespeak.jusridemobile:id/search_src_text");
    private static final By TAMBARAM_STATION = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Tambaram Railway Station, Tambaram, "
                    + "Tambaram Railway Station West Entrance, Tambaram, Chengalpattu, "
                    + "Tamil Nadu, 600045, India\")");
    private static final By FIRST_EGMORE_RESULT = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.LinearLayout\").instance(7)");

    private final AndroidDriver driver;

    public ChooseLocationPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void searchLocation(String location) {
        TestUtils.type(driver, SEARCH_FIELD, location);
    }

    public void selectTambaramRailwayStation() {
        TestUtils.click(driver, TAMBARAM_STATION);
    }

    public void selectFirstEgmoreResult() {
        TestUtils.click(driver, FIRST_EGMORE_RESULT);
    }
}
