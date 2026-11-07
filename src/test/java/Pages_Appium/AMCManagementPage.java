package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class AMCManagementPage {
    private final AndroidDriver driver;

    private static final By ACTIVATE_AMC =
            By.id("com.milespeak.jusridemobile:id/rlActivateText");

    private static final By MY_AMC =
            By.id("com.milespeak.jusridemobile:id/rlMyAmcText");

    private static final By UPLOAD_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btnUpload");

    private static final By CHOOSE_FILE =
            By.id("com.milespeak.jusridemobile:id/tvChooseFile");

    private static final By FIRST_FILE_THUMBNAIL = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"com.android.documentsui:id/icon_thumb\").instance(0)");

    private static final By SUBMIT_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btnSubmit");

    private static final By EDIT_INVOICE =
            By.id("com.milespeak.jusridemobile:id/editIcon");

    private static final By INVOICE_NUMBER =
            By.id("com.milespeak.jusridemobile:id/edtInvoice");

    private static final By OK_BUTTON =
            By.id("com.milespeak.jusridemobile:id/okBtn");

    private static final By YES_PROCEED_BUTTON =
            By.id("com.milespeak.jusridemobile:id/yesProceed");

    private static final By SEND_OTP = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Send OTP\")");

    private static final By[] OTP_INPUTS = {
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"),
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"),
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"),
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)")
    };

    private static final By VERIFY_OTP_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btnVerifyOtp");

    private static final By FINISH_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btnFinish");

    private static final By BOOK_NOW_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btnBookNow");

    public AMCManagementPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tapActivateAMC() {
        TestUtils.click(driver, ACTIVATE_AMC);
    }

    public void tapMyAMC() {
        TestUtils.click(driver, MY_AMC);
    }

    public void tapUpload() {
        TestUtils.click(driver, UPLOAD_BUTTON);
    }

    public void tapChooseFile() {
        TestUtils.click(driver, CHOOSE_FILE);
    }

    public void selectFirstFileThumbnail() {
        TestUtils.click(driver, FIRST_FILE_THUMBNAIL);
    }

    public void tapSubmit() {
        TestUtils.click(driver, SUBMIT_BUTTON);
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

    public void tapYesProceed() {
        TestUtils.click(driver, YES_PROCEED_BUTTON);
    }

    public void tapSendOtp() {
        TestUtils.click(driver, SEND_OTP);
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

    public void tapVerifyOtp() {
        TestUtils.click(driver, VERIFY_OTP_BUTTON);
    }

    public void tapFinish() {
        TestUtils.click(driver, FINISH_BUTTON);
    }

    public void tapBookNow() {
        TestUtils.click(driver, BOOK_NOW_BUTTON);
    }

    public boolean isAMCManagementPageDisplayed() {
        return TestUtils.isDisplayed(driver, ACTIVATE_AMC)
                || TestUtils.isDisplayed(driver, MY_AMC);
    }
}
