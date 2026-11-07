package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CreateProfilePage {
    private final AndroidDriver driver;

    private static final By NAME_INPUT =
            By.id("com.milespeak.jusridemobile:id/edt_fname");

    private static final By NICKNAME_INPUT =
            By.id("com.milespeak.jusridemobile:id/nick_name");

    private static final By EMAIL_INPUT =
            By.id("com.milespeak.jusridemobile:id/emailID");

    private static final By CREATE_BUTTON =
            By.id("com.milespeak.jusridemobile:id/editPrefrences");

    private static final By ALLOW_FOREGROUND_LOCATION_BUTTON =
            By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");

    private static final By PROFILE_CREATED_MESSAGE = AppiumBy.androidUIAutomator(
            "new UiSelector().textMatches(\"(?i).*profile.*(created|success).*|.*success.*profile.*\")");

    public CreateProfilePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        TestUtils.type(driver, NAME_INPUT, name);
    }

    public void enterNickName(String nickName) {
        TestUtils.type(driver, NICKNAME_INPUT, nickName);
    }

    public void enterEmail(String email) {
        TestUtils.type(driver, EMAIL_INPUT, email);
    }

    public void tapCreate() {
        TestUtils.click(driver, CREATE_BUTTON);
    }

    public void allowLocationPermissionIfPresent() {
        if (TestUtils.isDisplayed(driver, ALLOW_FOREGROUND_LOCATION_BUTTON)) {
            TestUtils.click(driver, ALLOW_FOREGROUND_LOCATION_BUTTON);
        }
    }

    public boolean isCreateProfilePageDisplayed() {
        return TestUtils.isDisplayed(driver, NAME_INPUT)
                || TestUtils.isDisplayed(driver, NICKNAME_INPUT)
                || TestUtils.isDisplayed(driver, EMAIL_INPUT);
    }

    public boolean isProfileCreatedSuccessfully() {
        return TestUtils.isDisplayed(driver, PROFILE_CREATED_MESSAGE);
    }
}