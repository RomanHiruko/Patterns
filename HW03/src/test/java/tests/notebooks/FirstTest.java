package tests.notebooks;

import org.junit.jupiter.api.Test;
import pages.AppliancesPage;
import pages.KitchenAppliancesPage;
import pages.StartPage;
import tests.BaseTest;
import tests.notebooks.matchers.AppliancesTextDisplayMatcher;

public class FirstTest extends BaseTest {
    @Test
    public void dnsTest(){
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.getURL();
        startPage.getPageTitle();
        startPage.getSize();
        startPage.buttonYes().hide();
        startPage.linkAppliances().click();

        AppliancesPage appliancesPage = new AppliancesPage(driver);
        appliancesPage.linkKitchenAppliances().click();

        AppliancesTextDisplayMatcher appliancesTextDisplayMatcher = new AppliancesTextDisplayMatcher(appliancesPage);
        appliancesTextDisplayMatcher.pageTitleDisplay(appliancesPage.textAppliances());

        KitchenAppliancesPage kitchenAppliancesPage = new KitchenAppliancesPage(driver);

    }
}
