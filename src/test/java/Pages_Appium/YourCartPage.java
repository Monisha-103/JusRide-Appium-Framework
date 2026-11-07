
package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourCartPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private static final By EDIT_ADDRESS_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btn_change_address");

    private static final By ADD_ANOTHER_ADDRESS =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Add Another Address\")");

    private static final By USE_CURRENT_LOCATION =
            By.id("com.milespeak.jusridemobile:id/txt_currentLocation");

    private static final By LOCATION_SEARCH =
            By.id("com.milespeak.jusridemobile:id/search_src_text");

    private static final By TAMBARAM_RAILWAY_STATION_SUGGESTION =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"Tambaram Railway Station\")");

    private static final By HOUSE_FLAT_NUMBER =
            By.id("com.milespeak.jusridemobile:id/edtHouseNo");

    private static final By SELECT_SLOT =
            By.id("com.milespeak.jusridemobile:id/btnSelectSlot");

    // Booking Slot screen locators
    private static final By BOOKING_SLOT_TITLE =
            By.id("com.milespeak.jusridemobile:id/tv_booking_slot_title");

    private static final By BOOKING_SLOT_NEXT_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btn_next_page");

    private static final By AVAILABLE_SLOTS_MESSAGE =
            By.id("com.milespeak.jusridemobile:id/txtAvailableSlots");

    private static final By SLOT_COUNT =
            By.id("com.milespeak.jusridemobile:id/tv_slot_count");

    private static final By TIME_SLOTS =
            By.id("com.milespeak.jusridemobile:id/rv_time_slots");

    private static final String SCROLLABLE_VIEW =
            "new UiSelector().scrollable(true).instance(0)";

    public YourCartPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver, Duration.ofSeconds(30));
    }

    public void tapEditAddress() {
        TestUtils.click(driver, EDIT_ADDRESS_BUTTON);
    }

    public void tapAddAnotherAddress() {
        TestUtils.click(driver, ADD_ANOTHER_ADDRESS);
    }

    public void searchAndSelectTambaramLocation() {
        TestUtils.type(driver, LOCATION_SEARCH, "Tambaram");

        TestUtils.click(
                driver, TAMBARAM_RAILWAY_STATION_SUGGESTION);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                HOUSE_FLAT_NUMBER));

        dragCartUp();
    }

    public void tapUseCurrentLocation() {
        TestUtils.click(driver, USE_CURRENT_LOCATION);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                HOUSE_FLAT_NUMBER));

        dragCartUp();
    }

    public void enterHouseOrFlatNumber(String houseOrFlatNumber) {
        WebElement houseField = wait.until(
                ExpectedConditions.elementToBeClickable(
                        HOUSE_FLAT_NUMBER));

        houseField.clear();
        houseField.sendKeys(houseOrFlatNumber);

        wait.until(driver ->
                houseOrFlatNumber.equals(
                        driver.findElement(HOUSE_FLAT_NUMBER)
                                .getText())
                        || houseOrFlatNumber.equals(
                        driver.findElement(HOUSE_FLAT_NUMBER)
                                .getAttribute("text")));
    }

    public void scrollToSaveAndProceed() {
        // Use a stable locator if your address screen exposes
        // a resource ID for its Save and Proceed button.
        By saveButton = AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"Save and Proceed\")");

        scrollCartTo(saveButton);

        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
    }

    private void scrollCartTo(By target) {
        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(" + SCROLLABLE_VIEW
                                + ").scrollIntoView("
                                + "new UiSelector().textContains("
                                + "\"Save and Proceed\"))"));
    }

    private void dragCartUp() {
        Dimension screenSize =
                driver.manage().window().getSize();

        int centerX = screenSize.getWidth() / 2;
        int startY = (int) (screenSize.getHeight() * 0.80);
        int endY = (int) (screenSize.getHeight() * 0.35);

        new Actions(driver)
                .moveToLocation(centerX, startY)
                .clickAndHold()
                .moveToLocation(centerX, endY)
                .release()
                .perform();
    }

    public void tapSaveAndProceed() {
        By saveButton = AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"Save and Proceed\")");

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(saveButton));

        button.click();

        wait.until(ExpectedConditions.elementToBeClickable(
                SELECT_SLOT));

        System.out.println(
                "Address saved. Select Slot button is ready.");
    }

    public void tapSelectSlot() {
        WebElement selectSlotButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        SELECT_SLOT));

        System.out.println("Select Slot displayed: "
                + selectSlotButton.isDisplayed());
        System.out.println("Select Slot enabled: "
                + selectSlotButton.isEnabled());
        System.out.println("Select Slot text: "
                + selectSlotButton.getText());

        selectSlotButton.click();

        // Wait for the actual Booking Slot screen.
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                BOOKING_SLOT_TITLE));

        System.out.println(
                "Booking Slot screen opened successfully.");
    }

    public boolean isBookingSlotPageDisplayed() {
        return !driver.findElements(BOOKING_SLOT_TITLE).isEmpty();
    }

    public String getAvailableSlotsMessage() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                AVAILABLE_SLOTS_MESSAGE))
                .getText();
    }

    public String getSlotCount() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                SLOT_COUNT))
                .getText();
    }

    public boolean isTimeSlotAvailable() {
        WebElement slots = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        TIME_SLOTS));

        return !slots.findElements(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().clickable(true)"))
                .isEmpty();
    }

    public boolean isYourCartPageDisplayed() {
        return TestUtils.isDisplayed(driver, SELECT_SLOT);
    }
}
