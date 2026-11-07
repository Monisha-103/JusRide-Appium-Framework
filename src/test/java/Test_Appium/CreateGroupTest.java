package Test_Appium;

import Base_Appium.BaseTest;
import Pages_Appium.CreateGroupPage;
import Pages_Appium.HomePage;
import Utils_Appium.TestDataUtils;
import org.testng.annotations.Test;

public class CreateGroupTest extends BaseTest {

    @Test
    public void createPublicGroup() {
        HomePage homePage = new HomePage(driver);
        homePage.tapPlus();
        homePage.tapGroup();

        CreateGroupPage createGroupPage = new CreateGroupPage(driver);
        createGroupPage.tapCreateGroup();
        createGroupPage.enterGroupName(TestDataUtils.get("groupName"));
        createGroupPage.enterLocation(TestDataUtils.get("groupLocation"));
        createGroupPage.selectLocationSuggestion(TestDataUtils.get("groupLocation"));
        createGroupPage.selectPublicPrivacy();
        createGroupPage.tapCreate();
    }
}
