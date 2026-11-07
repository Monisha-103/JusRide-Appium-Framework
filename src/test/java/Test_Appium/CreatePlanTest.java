package Test_Appium;

import Base_Appium.BaseTest;
import Pages_Appium.ChooseLocationPage;
import Pages_Appium.CreateRideDetailsPage;
import Pages_Appium.HomePage;
import Pages_Appium.RideChecklistPage;
import Pages_Appium.RideOrganizerPage;
import Pages_Appium.RideParticipantsPage;
import Pages_Appium.RideTagsPage;
import Pages_Appium.RoutePage;
import Utils_Appium.TestDataUtils;
import org.testng.annotations.Test;

public class CreatePlanTest extends BaseTest {

    @Test
    public void createRidePlan() {
        HomePage homePage = new HomePage(driver);
        homePage.tapPlus();
        homePage.tapPlan();

        RoutePage routePage = new RoutePage(driver);
       // routePage.tapNext();
       // routePage.tapNext();
      //  routePage.tapNext();
        routePage.tapMapIcon();

        routePage.tapStartLocation();
        ChooseLocationPage chooseLocationPage = new ChooseLocationPage(driver);
        chooseLocationPage.searchLocation(TestDataUtils.get("startLocation"));
        chooseLocationPage.selectTambaramRailwayStation();

        routePage.tapDestinationLocation();
        chooseLocationPage.searchLocation(TestDataUtils.get("destinationLocation"));
        chooseLocationPage.selectFirstEgmoreResult();

        CreateRideDetailsPage rideDetailsPage = new CreateRideDetailsPage(driver);
        rideDetailsPage.enterAverageSpeed(TestDataUtils.get("averageSpeed"));
        rideDetailsPage.enterRideName(TestDataUtils.get("rideName"));
        rideDetailsPage.scrollToRideDate();
        rideDetailsPage.selectRideDate();
        rideDetailsPage.selectStartTime();
        rideDetailsPage.tapNext();

        RideTagsPage rideTagsPage = new RideTagsPage(driver);
        rideTagsPage.selectTimeTrial();
        rideTagsPage.selectZoneThree();
        rideTagsPage.tapNext();

        RideChecklistPage checklistPage = new RideChecklistPage(driver);
        checklistPage.selectPunctureRepairKit();
        checklistPage.tapNext();

        RideParticipantsPage participantsPage = new RideParticipantsPage(driver);
        participantsPage.tapSkip();

        RideOrganizerPage organizerPage = new RideOrganizerPage(driver);
        organizerPage.tapCreatePlan();
    }
}
