package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SelectServicePage {
    private final AndroidDriver driver;

    private static final By NEXT_BUTTON =
            By.id("com.milespeak.jusridemobile:id/text_next");

    private static final By SERVICE_AT_HOME =
            By.id("com.milespeak.jusridemobile:id/service_at_home");

    private static final By SERVICE_AT_STORE_JBC_PICKUP =
            By.id("com.milespeak.jusridemobile:id/service_at_store_jbc_pickup");

    private static final By SERVICE_AT_STORE_USER_DROP =
            By.id("com.milespeak.jusridemobile:id/service_at_store_user_drop");

    public SelectServicePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tapNext() {
        TestUtils.click(driver, NEXT_BUTTON);
    }

    public void selectServiceAtHome() {
        TestUtils.click(driver, SERVICE_AT_HOME);
    }

    public void selectServiceAtStoreJbcPickup() {
        TestUtils.click(driver, SERVICE_AT_STORE_JBC_PICKUP);
    }

    public void selectServiceAtStoreUserDrop() {
        TestUtils.click(driver, SERVICE_AT_STORE_USER_DROP);
    }

    public boolean isSelectServicePageDisplayed() {
        return TestUtils.isDisplayed(driver, SERVICE_AT_HOME)
                || TestUtils.isDisplayed(driver, SERVICE_AT_STORE_JBC_PICKUP)
                || TestUtils.isDisplayed(driver, SERVICE_AT_STORE_USER_DROP);
    }
}
