package tests.notebooks;

import helpers.JavaScriptHelper;
import org.junit.jupiter.api.Test;
import pages.KettlesPage;
import pages.StartPage;
import tests.BaseTest;
import tests.notebooks.matchers.CategoriesCountMatcher;
import tests.notebooks.matchers.StartPageTextDisplayMatcher;
import tests.notebooks.matchers.TitleCountProductPageMatcher;

public class SecondTest extends BaseTest {
    @Test
    public void dnsTest() {
        //1. Arrange -
        //2. Act
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.blockYes().hide();
        JavaScriptHelper.scrollBy(0, 50);
        startPage.linkAppliances().focusOnLink();
        //3. Assert
        StartPageTextDisplayMatcher startPageTextDisplayMatcher = new StartPageTextDisplayMatcher(startPage);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startPageTextDisplayMatcher.linkDisplay(startPage.linkHomeAppliances());
        startPageTextDisplayMatcher.linkDisplay(startPage.linkKitchenAppliances());
        startPageTextDisplayMatcher.linkDisplay(startPage.linkEmbeddedTechnology());
        //4. Act
        startPage.linkDrinksPreparation().focusOnLink();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //5. Assert
        CategoriesCountMatcher categoriesCountMatcher = new CategoriesCountMatcher(startPage);
        categoriesCountMatcher.allCategories(startPage.linksSubmenuDrinksPreparation());
        //6. Act
        startPage.linkDrinksPreparation().focusOnLink();
        startPage.linkElectricKettles().click();
        //7. Assert
        KettlesPage kettlesPage = new KettlesPage(driver);
        TitleCountProductPageMatcher titleCountProductPageMatcher = new TitleCountProductPageMatcher(kettlesPage);
        titleCountProductPageMatcher.productCount(kettlesPage.textProductCount());

    }
}
