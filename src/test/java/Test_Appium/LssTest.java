package Test_Appium;

import Base_Appium.BaseTest;
import Pages_Appium.HomePage;
import Pages_Appium.LssPage;
import Pages_Appium.MorePage;
import Utils_Appium.TestDataUtils;
import org.testng.annotations.Test;

public class LssTest extends BaseTest {

    @Test
    public void updateLssAddress() {
        HomePage homePage = new HomePage(driver);
        homePage.tapMore();

        MorePage morePage = new MorePage(driver);
        morePage.tapLssBlock();

        LssPage lssPage = new LssPage(driver);
        lssPage.tapBuyNow();
        lssPage.tapEditAddress();
        lssPage.tapAddAnotherAddress();
        lssPage.enterAddress(TestDataUtils.get("lssAddress"));
        lssPage.enterCity(TestDataUtils.get("lssCity"));
        lssPage.enterState(TestDataUtils.get("lssState"));
        lssPage.enterPincode(TestDataUtils.get("lssPincode"));
        lssPage.enterMobileNumber(TestDataUtils.get("mobileNumber"));
        lssPage.selectHomeType();
        lssPage.tapSave();
        lssPage.tapPlaceOrder();
    }
}
