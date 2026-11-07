package Test_Appium;

import Base_Appium.BaseTest;
import Pages_Appium.CreateProfilePage;
import Pages_Appium.OTPPage;
import Pages_Appium.WelcomePage;
import Utils_Appium.ManualOtpReader;
import Utils_Appium.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateProfileTest extends BaseTest {

    @Test
    public void createUserProfile() {
        WelcomePage welcomePage = new WelcomePage(driver);
        Assert.assertTrue(welcomePage.isWelcomePageDisplayed(),
                "Welcome page should be displayed");

        welcomePage.enterMobileNumber(TestDataUtils.get("mobileNumber"));
        welcomePage.tapAgreeCheckbox();
        welcomePage.tapContinue();

        OTPPage otpPage = new OTPPage(driver);
        Assert.assertTrue(otpPage.isOtpScreenVisible(),
                "OTP page should be displayed");
        otpPage.enterOtpManually();
        otpPage.clickSubmit();

        CreateProfilePage profilePage = new CreateProfilePage(driver);
        profilePage.allowLocationPermissionIfPresent();
        Assert.assertTrue(profilePage.isCreateProfilePageDisplayed(),
                "Create profile page should be displayed");

        profilePage.enterName(TestDataUtils.get("firstName"));
        profilePage.enterNickName(TestDataUtils.get("nickName"));
        profilePage.enterEmail(TestDataUtils.get("email"));
        profilePage.tapCreate();

        Assert.assertTrue(profilePage.isProfileCreatedSuccessfully(),
                "Profile creation success message should be displayed");
    }
}
