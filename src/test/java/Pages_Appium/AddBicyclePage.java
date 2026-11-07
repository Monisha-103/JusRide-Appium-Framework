package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AddBicyclePage {
    private final AndroidDriver driver;

    private static final By ADD_BICYCLE_IMAGE =
            By.id("com.milespeak.jusridemobile:id/addYourBikeImage");
    private static final By KIDS_BICYCLE_TYPE = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"com.milespeak.jusridemobile:id/radioButton\").instance(3)");
    private static final By MULTI_SPEED_GEAR_TYPE = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"com.milespeak.jusridemobile:id/radioButton\").instance(5)");
    private static final By BRAND_SEARCH =
            By.id("com.milespeak.jusridemobile:id/search_src_text");
    private static final By ALASKA_BRAND =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Alaska\")");
    private static final By CHOOSE_FROM_GALLERY =
            By.id("com.milespeak.jusridemobile:id/chooseFromGallery");
    private static final By FIRST_GALLERY_IMAGE = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"com.google.android.gms.optional_photopicker:id/icon_thumbnail\").instance(0)");
    private static final By GALLERY_ADD_BUTTON = By.xpath(
            "//*[@resource-id='com.google.android.providers.media.module:id/button_add'"
                    + " or @resource-id='com.google.android.gms.optional_photopicker:id/button_add'"
                    + " or @resource-id='com.google.android.gms.optional_photopicker:id/add_button'"
                    + " or contains(@text,'Add') or contains(@content-desc,'Add')]");
    private static final By SUBMIT_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btnSubmit");
    private static final By CHECKBOX =
            By.id("com.milespeak.jusridemobile:id/checkbox");

    public AddBicyclePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void scrollToAddBicycleIcon() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().resourceId("
                        + "\"com.milespeak.jusridemobile:id/addYourBikeImage\"))"));
    }

    public void openAddBicycleForm() {
        TestUtils.click(driver, ADD_BICYCLE_IMAGE);
    }

    public boolean isAddBicycleFormDisplayed() {
        return TestUtils.isDisplayed(driver, KIDS_BICYCLE_TYPE)
                || TestUtils.isDisplayed(driver, BRAND_SEARCH);
    }

    public void selectKidsBicycleType() {
        TestUtils.click(driver, KIDS_BICYCLE_TYPE);
    }

    public void selectMultiSpeedGearType() {
        TestUtils.click(driver, MULTI_SPEED_GEAR_TYPE);
    }

    public void searchBrand(String brand) {
        TestUtils.click(driver, BRAND_SEARCH);
        TestUtils.type(driver, BRAND_SEARCH, brand);
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }
    }

    public boolean isBrandDropdownDisplayed() {
        return TestUtils.isDisplayed(driver, ALASKA_BRAND);
    }

    public void selectAlaskaBrand() {
        TestUtils.click(driver, ALASKA_BRAND);
    }

    public void selectFirstGalleryImage() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().resourceId("
                        + "\"com.milespeak.jusridemobile:id/chooseFromGallery\"))"));
        TestUtils.click(driver, CHOOSE_FROM_GALLERY);
        TestUtils.click(driver, FIRST_GALLERY_IMAGE);
        TestUtils.click(driver, GALLERY_ADD_BUTTON);
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }
        scrollToSubmitButton();
    }

    public void scrollToSubmitButton() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().resourceId("
                        + "\"com.milespeak.jusridemobile:id/btnSubmit\"))"));
    }

    public void submitBicycleDetails() {
        TestUtils.click(driver, SUBMIT_BUTTON);
    }

    public void selectCheckbox() {
        TestUtils.click(driver, CHECKBOX);
    }
}
