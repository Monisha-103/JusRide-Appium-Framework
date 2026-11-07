package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ReviewBicyclePage {
    private final AndroidDriver driver;

    private static final By NEXT_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btn_next");

    public ReviewBicyclePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tapNext() {
        TestUtils.click(driver, NEXT_BUTTON);
    }
}
