package Test_Appium;

import Base_Appium.BaseTest;
import Pages_Appium.AddBicyclePage;
import Pages_Appium.HomePage;
import Pages_Appium.ServiceWelcomePage;
import Pages_Appium.WarrantyManagementPage;
import Utils_Appium.InvoiceDataUtils;
import Utils_Appium.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WarrantyRegistrationTest extends BaseTest {

    @Test
    public void registerWarranty() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.tapService();

        ServiceWelcomePage serviceWelcomePage = new ServiceWelcomePage(driver);
        serviceWelcomePage.tapWarranty();

        WarrantyManagementPage warrantyManagementPage =
                new WarrantyManagementPage(driver);
        Assert.assertTrue(warrantyManagementPage.isWarrantyManagementPageDisplayed(),
                "Warranty management page should be displayed");
        warrantyManagementPage.tapRegisterWarranty();
        warrantyManagementPage.tapUploadWarranty();
        warrantyManagementPage.tapChooseFile();
        warrantyManagementPage.selectFirstFileThumbnail();
        warrantyManagementPage.tapVerify();

        warrantyManagementPage.tapEditInvoice();
        warrantyManagementPage.clearInvoiceNumber();

        warrantyManagementPage.enterInvoiceNumber(
                InvoiceDataUtils.getWarrantyInvoiceNumber());
        warrantyManagementPage.tapOk();
        warrantyManagementPage.tapNext();
        warrantyManagementPage.enterOtp(TestDataUtils.get("otp"));
        warrantyManagementPage.tapVerify();

        AddBicyclePage addBicyclePage = new AddBicyclePage(driver);
        addBicyclePage.scrollToAddBicycleIcon();
        addBicyclePage.openAddBicycleForm();
        Assert.assertTrue(addBicyclePage.isAddBicycleFormDisplayed(),
                "Bicycle details form should be displayed");
        addBicyclePage.selectKidsBicycleType();
        addBicyclePage.selectMultiSpeedGearType();
        addBicyclePage.searchBrand(TestDataUtils.get("brandSearch"));
        Assert.assertTrue(addBicyclePage.isBrandDropdownDisplayed(),
                "Brand dropdown should be displayed after searching");
        addBicyclePage.selectAlaskaBrand();
        addBicyclePage.selectFirstGalleryImage();
        addBicyclePage.selectCheckbox();
        addBicyclePage.submitBicycleDetails();

        warrantyManagementPage.tapBookNow();
    }
}
