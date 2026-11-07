package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class RideOrganizerPage {
    private final AndroidDriver driver;

    private static final By CREATE_PLAN_BUTTON =
            By.id("com.milespeak.jusridemobile:id/butOrgCreatePlan");

    public RideOrganizerPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tapCreatePlan() {
        TestUtils.click(driver, CREATE_PLAN_BUTTON);
    }
}
