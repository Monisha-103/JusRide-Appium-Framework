package Base_Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;
    protected static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        try {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setAutomationName("UiAutomator2")
                    .setDeviceName("32005356f0416543")
                    .setUdid("32005356f0416543")
                    .setAppPackage("com.milespeak.jusridemobile")
                    .setAppActivity("com.milespeak.jusridemobile.ui.splashscreen.SplashScreen")
                    .setNoReset(true)
                    .setNewCommandTimeout(Duration.ofSeconds(300));

            driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkipException(
                    "Skipping Appium tests because the Appium session could not be created: "
                            + e.getMessage(), e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}