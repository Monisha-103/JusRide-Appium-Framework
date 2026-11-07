package Pages_Appium;

import Utils_Appium.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ChoosePackagePage {
    private final AndroidDriver driver;

    private static final By BASIC_PACKAGE =
            By.id("com.milespeak.jusridemobile:id/btn_service");
    private static final By NEXT_BUTTON =
            By.id("com.milespeak.jusridemobile:id/btn_next");
    private static final By FAB_SUPPORT =
            By.id("com.milespeak.jusridemobile:id/fabSupport");

    public ChoosePackagePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void selectBasicPackage() {
        TestUtils.click(driver, BASIC_PACKAGE);
    }

    public void tapNext() {
        TestUtils.click(driver, NEXT_BUTTON);
    }

    public void liftFabSupportButton() {
        WebElement fabSupport = TestUtils.waitForVisible(
                driver, FAB_SUPPORT, Duration.ofSeconds(15));
        Dimension screenSize = driver.manage().window().getSize();
        int targetY = screenSize.getHeight() / 3;
        int distanceToLift = fabSupport.getLocation().getY() - targetY;

        if (distanceToLift > 0) {
            new Actions(driver)
                    .clickAndHold(fabSupport)
                    .moveByOffset(0, -distanceToLift)
                    .release()
                    .perform();
        }
    }
}
