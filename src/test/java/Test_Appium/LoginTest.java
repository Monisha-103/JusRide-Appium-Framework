package Test_Appium;

import Base_Appium.BaseTest;
import Pages_Appium.OTPPage;
import Pages_Appium.WelcomePage;
import Utils_Appium.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithMobileNumber() {
        WelcomePage welcomePage = new WelcomePage(driver);
        Assert.assertTrue(welcomePage.isWelcomePageDisplayed(),
                "Login page should be displayed");

        welcomePage.enterMobileNumber(TestDataUtils.get("mobileNumber"));
        welcomePage.tapAgreeCheckbox();
        welcomePage.tapContinue();

        OTPPage otpPage = new OTPPage(driver);
        Assert.assertTrue(otpPage.isOtpScreenVisible(),
                "OTP screen should be displayed after continuing");
        otpPage.enterOtpManually();
        otpPage.clickSubmit();
    }
}
