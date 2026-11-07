package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class RideParticipantsPage {
    private final AndroidDriver driver;

    private static final By SKIP_BUTTON =
            By.id("com.milespeak.jusridemobile:id/txt_skip");

    public RideParticipantsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tapSkip() {
        TestUtils.click(driver, SKIP_BUTTON);
    }

}
