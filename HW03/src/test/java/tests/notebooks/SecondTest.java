package tests.notebooks;

import helpers.ScreenshotHelper;
import helpers.WaitHelper;
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
        //Перейти по ссылке DNS
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        ScreenshotHelper.makeScreenshot();

        //Нажать кнопку Всё верно
        startPage.buttonYes().click();
        WaitHelper.readyStateComplete();
        ScreenshotHelper.makeScreenshot();

        //Навести на ссылку Бытовая техника
        startPage.linkAppliances().focusOnLink();
        WaitHelper.sleep(500);
        ScreenshotHelper.makeScreenshot();

        //3. Assert
        //Проверить, что отображается текст
        StartPageTextDisplayMatcher startPageTextDisplayMatcher = new StartPageTextDisplayMatcher(startPage);

        //Техника для дома
        startPageTextDisplayMatcher.linkDisplay(startPage.linkHomeAppliances());

        //Техника для кухни
        startPageTextDisplayMatcher.linkDisplay(startPage.linkKitchenAppliances());

        //Встроенная техника
        startPageTextDisplayMatcher.linkDisplay(startPage.linkEmbeddedTechnology());

        //4. Act
        //Навести на ссылку Приготовление напитков
        startPage.linkDrinksPreparation().focusOnLink();
        WaitHelper.sleep(500);
        ScreenshotHelper.makeScreenshot();

        //5. Assert
        //Проверить, что количество ссылок в подменю Приготовление напитков больше 5
        CategoriesCountMatcher categoriesCountMatcher = new CategoriesCountMatcher(startPage);
        categoriesCountMatcher.allCategories(startPage.linksSubmenuDrinksPreparation());

        //6. Act
        //Перейти по ссылке Электрочайники
        startPage.linkDrinksPreparation().focusOnLink();
        startPage.linkElectricKettles().click();
        ScreenshotHelper.makeScreenshot();

        //7. Assert
        //Проверить, что  количество продуктов по ссылке Электрочайники больше 1000
        KettlesPage kettlesPage = new KettlesPage(driver);
        TitleCountProductPageMatcher titleCountProductPageMatcher = new TitleCountProductPageMatcher(kettlesPage);
        titleCountProductPageMatcher.productCount(kettlesPage.textProductCount());
    }
}
