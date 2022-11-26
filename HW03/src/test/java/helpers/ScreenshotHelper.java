package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {
    private static Logger logger = LogManager.getLogger(ScreenshotHelper.class);
    private static WebDriver screen;
    private static int number = 0;

    public static void init(WebDriver driver){
        screen = driver;
    }

    public static void makeScreenshot(){
        try {
            Actions actions = new Actions(screen);
            actions
                    .sendKeys(Keys.END)
                    .sendKeys(Keys.HOME)
                    .perform();
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(screen);
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\FirstCaseScreen_" + number + ".png"));
            number += 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
