package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CreateGroupPage {
    private final AndroidDriver driver;

    private static final By CREATE_GROUP =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().resourceId(\"com.milespeak.jusridemobile:id/linear_create\")");
    private static final By EXPLORE_GROUPS =
            By.id("com.milespeak.jusridemobile:id/linear_explore");
    private static final By GROUP_NAME =
            By.id("com.milespeak.jusridemobile:id/edt_groupname");
    private static final By LOCATION =
            By.id("com.milespeak.jusridemobile:id/query_text");
    private static final By LOCATION_SEARCH =
            By.id("com.milespeak.jusridemobile:id/search_src_text");
    private static final By PUBLIC_GROUP =
            By.id("com.milespeak.jusridemobile:id/pbl_group");
    private static final By PRIVATE_GROUP =
            By.id("com.milespeak.jusridemobile:id/pvt_group");
    private static final By CREATE_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btn_creategrp");

    public CreateGroupPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tapCreateGroup() {
        TestUtils.click(driver, CREATE_GROUP);
    }

    public void tapExploreGroups() {
        TestUtils.click(driver, EXPLORE_GROUPS);
    }

    public void enterGroupName(String groupName) {
        TestUtils.type(driver, GROUP_NAME, groupName);
    }

    public void enterLocation(String location) {
        TestUtils.click(driver, LOCATION);
        TestUtils.type(driver, LOCATION_SEARCH, location);
    }

    public void selectLocationSuggestion(String location) {
        TestUtils.click(driver, AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.widget.TextView\")"
                        + ".textContains(\"" + location + "\")"));
    }

    public void selectPublicPrivacy() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().resourceId("
                        + "\"com.milespeak.jusridemobile:id/pbl_group\"))"));
        TestUtils.click(driver, PUBLIC_GROUP);
    }

    public void selectPrivatePrivacy() {
        TestUtils.click(driver, PRIVATE_GROUP);
    }

    public void tapCreate() {
        TestUtils.click(driver, CREATE_BUTTON);
    }
}
