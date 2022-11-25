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
        startPage.buttonYes().click();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        startPage.linkAppliances().click();



        AppliancesPage appliancesPage = new AppliancesPage(driver);
        AppliancesTextDisplayMatcher appliancesTextDisplayMatcher = new AppliancesTextDisplayMatcher(appliancesPage);
        appliancesTextDisplayMatcher.pageTitleDisplay(appliancesPage.textAppliances());
        appliancesPage.linkKitchenAppliances().click();



        KitchenAppliancesPage kitchenAppliancesPage = new KitchenAppliancesPage(driver);

    }
}
