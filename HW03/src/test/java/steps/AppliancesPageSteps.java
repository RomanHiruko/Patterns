package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.AppliancesPage;

public class AppliancesPageSteps {
    private static final Logger logger = LogManager.getLogger(AppliancesPageSteps.class);
    private final AppliancesPage appliancesPage;

    public AppliancesPageSteps(WebDriver driver) {
        appliancesPage = new AppliancesPage(driver);
        logger.info("Открыта страница [Бытовая техника]");
    }

    public void clickLinkKitchenAppliances() {
        appliancesPage.linkKitchenAppliances().click();
    }
}
