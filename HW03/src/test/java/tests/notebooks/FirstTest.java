package tests.notebooks;

import org.junit.jupiter.api.Test;
import pages.AppliancesPage;
import pages.KitchenAppliancesPage;
import pages.StartPage;
import tests.BaseTest;
import tests.notebooks.matchers.AppliancesTextDisplayMatcher;
import tests.notebooks.matchers.KitchenAppliancesTextDisplayMatcher;

public class FirstTest extends BaseTest {
    @Test
    public void dnsTest() {
        //1. Arrange -
        //2.Act
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.getURL();
        startPage.getPageTitle();
        startPage.getSize();
        startPage.blockYes().hide();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startPage.linkAppliances().click();

        AppliancesPage appliancesPage = new AppliancesPage(driver);
        //3. Assert
        AppliancesTextDisplayMatcher appliancesTextDisplayMatcher = new AppliancesTextDisplayMatcher(appliancesPage);
        appliancesTextDisplayMatcher.pageTitleDisplay(appliancesPage.textAppliances());
        //4. Act
        appliancesPage.linkKitchenAppliances().click();

        KitchenAppliancesPage kitchenAppliancesPage = new KitchenAppliancesPage(driver);
        //5.Assert
        KitchenAppliancesTextDisplayMatcher kitchenAppliancesTextDisplayMatcher = new KitchenAppliancesTextDisplayMatcher(kitchenAppliancesPage);
        kitchenAppliancesTextDisplayMatcher.pageTitleDisplay(kitchenAppliancesPage.textKitchenAppliances());
        kitchenAppliancesTextDisplayMatcher.pageTitleDisplay(kitchenAppliancesPage.linkMakeKitchen());
        kitchenAppliancesPage.allCategories();
    }
}
