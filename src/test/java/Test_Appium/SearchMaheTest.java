package Test_Appium;

import Base_Appium.BaseTest;
import Pages_Appium.HomePage;
import Utils_Appium.TestDataUtils;
import org.testng.annotations.Test;

public class SearchMaheTest extends BaseTest {

    @Test
    public void searchMaheAndFollow() {
        HomePage homePage = new HomePage(driver);
        homePage.tapSearch();
        homePage.searchForMahe(TestDataUtils.getPreservingWhitespace("maheSearchTerm"));
        homePage.selectMaheSearchSuggestion();
        homePage.tapFollow();
    }
}
