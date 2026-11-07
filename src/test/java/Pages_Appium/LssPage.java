package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LssPage {
    private final AndroidDriver driver;

    private static final By BUY_NOW_BUTTON =
            By.id("com.milespeak.jusridemobile:id/buy_now_btn");
    private static final By EDIT_ADDRESS_BUTTON =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().resourceId(\"com.milespeak.jusridemobile:id/editIcon\")");
    private static final By ADD_ANOTHER_ADDRESS =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Add Another Address\")");
    private static final By ADDRESS_FIELD =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().resourceId(\"com.milespeak.jusridemobile:id/address\")");
    private static final By CITY_FIELD =
            By.id("com.milespeak.jusridemobile:id/edt_city");
    private static final By STATE_FIELD =
            By.id("com.milespeak.jusridemobile:id/edt_state");
    private static final By PINCODE_FIELD =
            By.id("com.milespeak.jusridemobile:id/txt_pincode");
    private static final By MOBILE_NUMBER_FIELD = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.EditText\").instance(4)");
    private static final By TYPE_SPINNER =
            By.id("com.milespeak.jusridemobile:id/typeSpinner");
    private static final By HOME_TYPE =
            AppiumBy.androidUIAutomator("new UiSelector().text(\"Home\")");
    private static final By SAVE_BUTTON =
            By.id("com.milespeak.jusridemobile:id/butSave");
    private static final By PLACE_ORDER_BUTTON =
            By.id("com.milespeak.jusridemobile:id/checkout_button");

    public LssPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tapBuyNow() {
        TestUtils.click(driver, BUY_NOW_BUTTON);
    }

    public void tapEditAddress() {
        TestUtils.click(driver, EDIT_ADDRESS_BUTTON);
    }

    public void tapAddAnotherAddress() {
        TestUtils.click(driver, ADD_ANOTHER_ADDRESS);
    }

    public void enterAddress(String address) {
        TestUtils.type(driver, ADDRESS_FIELD, address);
    }

    public void enterCity(String city) {
        TestUtils.type(driver, CITY_FIELD, city);
    }

    public void enterState(String state) {
        TestUtils.type(driver, STATE_FIELD, state);
    }

    public void enterPincode(String pincode) {
        TestUtils.type(driver, PINCODE_FIELD, pincode);
    }

    public void enterMobileNumber(String mobileNumber) {
        TestUtils.type(driver, MOBILE_NUMBER_FIELD, mobileNumber);
    }

    public void selectHomeType() {
        TestUtils.click(driver, TYPE_SPINNER);
        TestUtils.click(driver, HOME_TYPE);
    }

    public void tapSave() {
        TestUtils.click(driver, SAVE_BUTTON);
    }

    public void tapPlaceOrder() {
        TestUtils.click(driver, PLACE_ORDER_BUTTON);
    }
}
