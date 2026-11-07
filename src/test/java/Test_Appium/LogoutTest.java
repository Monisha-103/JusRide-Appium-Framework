package Test_Appium;

import Base_Appium.BaseTest;
import Pages_Appium.HomePage;
import Pages_Appium.MorePage;
import Pages_Appium.SettingsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutFromSettings() {
        HomePage homePage = new HomePage(driver);
        homePage.tapMore();

        MorePage morePage = new MorePage(driver);
        morePage.tapSettings();

        SettingsPage settingsPage = new SettingsPage(driver);
        Assert.assertTrue(settingsPage.isLogoutDisplayed(),
                "Logout option should be displayed in Settings");
        settingsPage.tapLogout();
        settingsPage.confirmLogout();
    }
}
