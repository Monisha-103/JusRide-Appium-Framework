package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class WarrantyManagementPage {
    private final AndroidDriver driver;

    private static final By REGISTER_WARRANTY =
            By.id("com.milespeak.jusridemobile:id/rlRegisterText");

    private static final By MY_WARRANTY =
            By.id("com.milespeak.jusridemobile:id/rlMyWarrantyText");

    private static final By UPLOAD_WARRANTY =
            By.id("com.milespeak.jusridemobile:id/uploadDocument");

    private static final By CHOOSE_FILE =
            By.id("com.milespeak.jusridemobile:id/tvChooseFile");

    private static final By FIRST_FILE_THUMBNAIL = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"com.android.documentsui:id/icon_thumb\").instance(0)");

    private static final By VERIFY_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btnVerify");

    private static final By EDIT_INVOICE =
            By.id("com.milespeak.jusridemobile:id/iv_edit");

    private static final By INVOICE_NUMBER =
            By.id("com.milespeak.jusridemobile:id/edtInvoice");

    private static final By OK_BUTTON =
            By.id("com.milespeak.jusridemobile:id/okBtn");

    private static final By NEXT_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btn_next");

    private static final By[] OTP_INPUTS = {
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"),
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"),
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"),
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)")
    };

    private static final By BOOK_NOW_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btnBookNow");

    public WarrantyManagementPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tapRegisterWarranty() {
        TestUtils.click(driver, REGISTER_WARRANTY);
    }

    public void tapMyWarranty() {
        TestUtils.click(driver, MY_WARRANTY);
    }

    public void tapUploadWarranty() {
        TestUtils.click(driver, UPLOAD_WARRANTY);
    }

    public void tapChooseFile() {
        TestUtils.click(driver, CHOOSE_FILE);
    }

    public void selectFirstFileThumbnail() {
        TestUtils.click(driver, FIRST_FILE_THUMBNAIL);
    }

    public void tapVerify() {
        TestUtils.click(driver, VERIFY_BUTTON);
    }

    public void tapEditInvoice() {
        TestUtils.click(driver, EDIT_INVOICE);
    }

    public void clearInvoiceNumber() {
        TestUtils.waitForVisible(driver, INVOICE_NUMBER, Duration.ofSeconds(15)).clear();
    }

    public void enterInvoiceNumber(String invoiceNumber) {
        TestUtils.type(driver, INVOICE_NUMBER, invoiceNumber);
    }

    public void tapOk() {
        TestUtils.click(driver, OK_BUTTON);
    }

    public void tapNext() {
        TestUtils.click(driver, NEXT_BUTTON);
    }

    public void enterOtp(String otp) {
        if (otp == null || otp.length() != OTP_INPUTS.length
                || !otp.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("OTP must contain exactly four digits");
        }

        for (int i = 0; i < OTP_INPUTS.length; i++) {
            TestUtils.type(driver, OTP_INPUTS[i], String.valueOf(otp.charAt(i)));
        }
    }

    public void tapBookNow() {
        TestUtils.click(driver, BOOK_NOW_BUTTON);
    }

    public boolean isWarrantyManagementPageDisplayed() {
        return TestUtils.isDisplayed(driver, REGISTER_WARRANTY)
                || TestUtils.isDisplayed(driver, MY_WARRANTY);
    }
}
