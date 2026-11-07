
package Test_Appium;

import Base_Appium.BaseTest;
import Pages_Appium.*;
import Utils_Appium.TestDataUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserDropServiceTest extends BaseTest {

    @Test
    public void bookUserDropService() {

        // Step 1: Open Service and validate pincode
        HomePage homePage = new HomePage(driver);
        homePage.tapService();

        ServiceWelcomePage serviceWelcomePage =
                new ServiceWelcomePage(driver);

        serviceWelcomePage.selectChennai();
        serviceWelcomePage.enterPincode(TestDataUtils.get("servicePincode"));
        serviceWelcomePage.tapCheck();

        // Step 2: Select I'll Drop & Pickup
        SelectServicePage selectServicePage =
                new SelectServicePage(driver);

        Assert.assertTrue(
                selectServicePage.isSelectServicePageDisplayed(),
                "Service selection page should be displayed"
        );

        selectServicePage.selectServiceAtStoreUserDrop();

        // Step 3: Add bicycle details
        AddBicyclePage addBicyclePage =
                new AddBicyclePage(driver);

        addBicyclePage.scrollToAddBicycleIcon();
        addBicyclePage.openAddBicycleForm();

        Assert.assertTrue(
                addBicyclePage.isAddBicycleFormDisplayed(),
                "Bicycle details form should be displayed"
        );

        addBicyclePage.selectKidsBicycleType();
        addBicyclePage.selectMultiSpeedGearType();
        addBicyclePage.searchBrand(TestDataUtils.get("brandSearch"));

        Assert.assertTrue(
                addBicyclePage.isBrandDropdownDisplayed(),
                "Brand dropdown should be displayed"
        );

        addBicyclePage.selectAlaskaBrand();
        addBicyclePage.selectFirstGalleryImage();
        addBicyclePage.submitBicycleDetails();

        // Step 4: Review bicycle
        ReviewBicyclePage reviewBicyclePage =
                new ReviewBicyclePage(driver);

        reviewBicyclePage.tapNext();

        // Step 5: Select service package
        ChoosePackagePage choosePackagePage =
                new ChoosePackagePage(driver);

        choosePackagePage.liftFabSupportButton();
        choosePackagePage.selectBasicPackage();
        choosePackagePage.tapNext();

        // Step 6: Verify Your Cart
        YourCartPage2 yourCartPage2 =
                new YourCartPage2(driver);



        // Step 7: Open store selection
        yourCartPage2.tapSelectSlot();

        SelectStorePage selectStorePage =
                new SelectStorePage(driver);

        Assert.assertTrue(
                selectStorePage.isSelectStorePageDisplayed(),
                "Store selection page should be displayed"
        );

        selectStorePage.selectAnnaNagar();
        selectStorePage.tapNext();

        // Step 8: Select booking date and time
        BookingSlotPage bookingSlotPage =
                new BookingSlotPage(driver);

        Assert.assertTrue(
                bookingSlotPage.isBookingSlotPageDisplayed(),
                "Booking Slot page should be displayed"
        );

        bookingSlotPage.selectUserDropBookingDate();
        bookingSlotPage.selectUserDropBookingTime();

        // Step 9: Proceed to payment
        bookingSlotPage.tapNextPage();

        PaymentPage paymentPage =
                new PaymentPage(driver);
        yourCartPage2.tapSelectSlot();

        paymentPage.waitForPaymentPage();

        Assert.assertTrue(
                paymentPage.isPaymentPageDisplayed(),
                "Payment page should be displayed"
        );

        paymentPage.selectWallets();
        paymentPage.selectFreecharge();
        paymentPage.tapProceedToPay();

        // Step 10: Complete OTP verification
        System.out.println(
                "Enter the payment OTP manually on the device."
        );

        OTPPage otpPage = new OTPPage(driver);
        otpPage.enterOtpManually();
    }
}
