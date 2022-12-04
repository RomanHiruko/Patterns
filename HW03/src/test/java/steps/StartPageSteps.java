package steps;

import helpers.ActionHelper;
import helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.StartPage;

public class StartPageSteps {
    private static final Logger logger = LogManager.getLogger(StartPageSteps.class);
    private final StartPage startPage;

    public StartPageSteps(WebDriver driver) {
        // ***** Стартовая страница сайта DNS *****
        startPage = new StartPage(driver);
    }

    public void clickButtonYes() {
        startPage.buttonYes().click();
        WaitHelper.sleep(1000);
    }

    public void openPage() {
        startPage.openPage();
        logger.info("Открыта страница [Стартовая страница DNS]");
    }

    public void goToNotebooksPage() {
        startPage.linkPcAndPeripheral().focusOnLink();
        WaitHelper.clickabilityOfElement(startPage.linkNotebooks().getWebElement());
        startPage.linkNotebooks().click();
        logger.info("Страница [Стартовая страница DNS]: Переход на страницу \"Ноутбуки\"");
    }

    public void hideHeader() {
        startPage.blockHeader().hide();
    }

    public void focusOnLinkDrinksPreparation() {
        ActionHelper.scrollTo(startPage.linkAppliances().getWebElement());
        startPage.linkAppliances().focusOnLink();
        WaitHelper.clickabilityOfElement(startPage.linkDrinksPreparation().getWebElement());
        startPage.linkDrinksPreparation().focusOnLink();
        WaitHelper.visibilityOfElement(startPage.linkElectricKettles().getWebElement());
    }

    public void focusLinkAppliances() {
        ActionHelper.scrollTo(startPage.linkAppliances().getWebElement());
        startPage.linkAppliances().focusOnLink();
        WaitHelper.clickabilityOfElement(startPage.linkKitchenAppliances().getWebElement());
        WaitHelper.sleep(3000);
    }

    public void clickLinkElectricKettles() {
        ActionHelper.scrollTo(startPage.linkAppliances().getWebElement());
        startPage.linkAppliances().focusOnLink();
        WaitHelper.clickabilityOfElement(startPage.linkDrinksPreparation().getWebElement());
        startPage.linkDrinksPreparation().focusOnLink();
        WaitHelper.visibilityOfElement(startPage.linkElectricKettles().getWebElement());
        startPage.linkElectricKettles().click();
    }

    public void printInfo() {
        startPage.getURL();
        startPage.getPageTitle();
        startPage.getSize();
    }

    public void clickLinkAppliances() {
        ActionHelper.scrollTo(startPage.linkAppliances().getWebElement());
        startPage.linkAppliances().click();
    }
}
