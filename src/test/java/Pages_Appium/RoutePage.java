package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class RoutePage {
    private final AndroidDriver driver;

    private static final By NEXT_BUTTON =
            By.id("com.milespeak.jusridemobile:id/text_next");
    private static final By MAP_ICON =
            By.id("com.milespeak.jusridemobile:id/mapride");
    private static final By START_LOCATION =
            By.id("com.milespeak.jusridemobile:id/startLoc");
    private static final By DESTINATION_LOCATION =
            By.id("com.milespeak.jusridemobile:id/destLoc");

    public RoutePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tapNext() {
        TestUtils.click(driver, NEXT_BUTTON);
    }

    public void tapMapIcon() {
        TestUtils.click(driver, MAP_ICON);
    }

    public void tapStartLocation() {
        TestUtils.click(driver, START_LOCATION);
    }

    public void tapDestinationLocation() {
        TestUtils.click(driver, DESTINATION_LOCATION);
    }
}
