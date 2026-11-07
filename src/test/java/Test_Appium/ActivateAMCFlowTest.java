package Test_Appium;

import Base_Appium.BaseTest;
import Pages_Appium.AMCManagementPage;
import Pages_Appium.AddBicyclePage;
import Pages_Appium.HomePage;
import Pages_Appium.ServiceWelcomePage;
import Utils_Appium.InvoiceDataUtils;
import Utils_Appium.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivateAMCFlowTest extends BaseTest {

    @Test
    public void activateAMC() {
        HomePage homePage = new HomePage(driver);
        homePage.tapService();

        ServiceWelcomePage serviceWelcomePage = new ServiceWelcomePage(driver);
        serviceWelcomePage.tapActivateAMC();

        AMCManagementPage amcManagementPage = new AMCManagementPage(driver);
        Assert.assertTrue(amcManagementPage.isAMCManagementPageDisplayed(),
                "AMC management page should be displayed");
        amcManagementPage.tapActivateAMC();
        amcManagementPage.tapUpload();
        amcManagementPage.tapChooseFile();
        amcManagementPage.selectFirstFileThumbnail();
        amcManagementPage.tapSubmit();

        amcManagementPage.tapEditInvoice();
        amcManagementPage.clearInvoiceNumber();
        amcManagementPage.enterInvoiceNumber(InvoiceDataUtils.getAmcInvoiceNumber());
        amcManagementPage.tapOk();
        amcManagementPage.tapYesProceed();
        amcManagementPage.tapSendOtp();
        amcManagementPage.enterOtp(TestDataUtils.get("otp"));
        amcManagementPage.tapVerifyOtp();

        AddBicyclePage addBicyclePage =
                new AddBicyclePage(driver);


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

        //amcManagementPage.tapFinish();
        amcManagementPage.tapBookNow();
    }
}
