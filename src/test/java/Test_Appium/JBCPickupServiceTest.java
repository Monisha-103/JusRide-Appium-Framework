
package Test_Appium;

import Base_Appium.BaseTest;
import Pages_Appium.AddBicyclePage;
import Pages_Appium.BookingSlotPage;
import Pages_Appium.ChoosePackagePage;
import Pages_Appium.HomePage;
import Pages_Appium.OTPPage;
import Pages_Appium.PaymentPage;
import Pages_Appium.ReviewBicyclePage;
import Pages_Appium.SelectServicePage;
import Pages_Appium.ServiceWelcomePage;
import Pages_Appium.YourCartPage;
import Utils_Appium.TestDataUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JBCPickupServiceTest extends BaseTest {

    @Test
    public void bookJBCPickupService() {

        // Step 1: Open Service and validate pincode
        HomePage homePage = new HomePage(driver);
        homePage.tapService();

        ServiceWelcomePage serviceWelcomePage =
                new ServiceWelcomePage(driver);

        serviceWelcomePage.selectChennai();
        serviceWelcomePage.enterPincode(TestDataUtils.get("servicePincode"));
        serviceWelcomePage.tapCheck();

        // Step 2: Select Home Service
        SelectServicePage selectServicePage = new SelectServicePage(driver);
        Assert.assertTrue(selectServicePage.isSelectServicePageDisplayed(),
                "Service selection page should be displayed");
        selectServicePage.selectServiceAtStoreJbcPickup();

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

        // Step 6: Update address in Your Cart
        YourCartPage yourCartPage =
                new YourCartPage(driver);

        Assert.assertTrue(
                yourCartPage.isYourCartPageDisplayed(),
                "Your Cart page should be displayed"
        );

        yourCartPage.tapEditAddress();
        yourCartPage.tapAddAnotherAddress();
        yourCartPage.searchAndSelectTambaramLocation();
        yourCartPage.enterHouseOrFlatNumber(TestDataUtils.get("serviceHouseNumber"));
        yourCartPage.scrollToSaveAndProceed();
        yourCartPage.tapSaveAndProceed();

        // Step 7: Open Booking Slot screen
        yourCartPage.tapSelectSlot();

        Assert.assertTrue(
                yourCartPage.isBookingSlotPageDisplayed(),
                "Booking Slot screen should be displayed"
        );

        // Step 8: Select date and time
        BookingSlotPage bookingSlotPage =
                new BookingSlotPage(driver);

        Assert.assertTrue(
                bookingSlotPage.isBookingSlotPageDisplayed(),
                "Booking Slot page should be displayed"
        );

        bookingSlotPage.selectJbcPickupBookingDate();
        bookingSlotPage.selectJbcPickupBookingTime();

        // Proceed from Booking Slot to the next screen
        bookingSlotPage.tapNextPage();

        // Step 9: Verify and proceed to payment
        PaymentPage paymentPage =
                new PaymentPage(driver);
        yourCartPage.tapSelectSlot();

        paymentPage.waitForPaymentPage();

        Assert.assertTrue(
                paymentPage.isPaymentPageDisplayed(),
                "Payment page should be displayed"
        );

        // Select payment method
        paymentPage.selectWallets();
        paymentPage.selectFreecharge();

        // Proceed to payment
        paymentPage.tapProceedToPay();

        // Step 10: Complete OTP verification
        System.out.println(
                "Enter the payment OTP manually on the device."
        );

        OTPPage otpPage = new OTPPage(driver);
        otpPage.enterOtpManually();
    }
}
