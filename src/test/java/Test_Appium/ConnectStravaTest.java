package Test_Appium;

import Base_Appium.BaseTest;
import Pages_Appium.HomePage;
import org.testng.annotations.Test;

public class ConnectStravaTest extends BaseTest {

    @Test
    public void connectWithStrava() {
        HomePage homePage = new HomePage(driver);
        homePage.tapConnectWithStrava();
        homePage.scrollToAuthorizeStrava();
        homePage.tapAuthorizeStrava();
        homePage.refreshHomePage();
    }
}
