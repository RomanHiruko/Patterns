package tests.notebooks;

import elements.Link;
import helpers.ActionHelper;
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
        StartPage startPage = new StartPage(driver);

        //1. Arrange
        Link[] args = {startPage.linkKitchenAppliances(), startPage.linkHomeAppliances(), startPage.linkEmbeddedTechnology()};

        //2. Act
        //Перейти по ссылке DNS
        startPage = focusLinkAppliancesAndMakeScreen();

        //3. Assert
        //Проверить, что отображается текст
        //Техника для дома
        //Техника для кухни
        //Встроенная техника
        StartPageTextDisplayMatcher startPageTextDisplayMatcher = new StartPageTextDisplayMatcher(startPage);
        startPageTextDisplayMatcher.linkDisplay(args);

        //4. Act
        //Навести на ссылку Приготовление напитков
        startPage = linkDrinksPreparationAndScreen();

        //5. Assert
        //Проверить, что количество ссылок в подменю Приготовление напитков больше 5
        CategoriesCountMatcher categoriesCountMatcher = new CategoriesCountMatcher(startPage);
        categoriesCountMatcher.allCategories(startPage.linksSubmenuDrinksPreparation());

        //6. Act
        //Перейти по ссылке Электрочайники
        KettlesPage kettlesPage = linkKettlesAndScreen();

        //7. Assert
        //Проверить, что  количество продуктов по ссылке Электрочайники больше 1000
        TitleCountProductPageMatcher titleCountProductPageMatcher = new TitleCountProductPageMatcher(kettlesPage);
        titleCountProductPageMatcher.productCount(kettlesPage.textProductCount());
    }

    public static StartPage focusLinkAppliancesAndMakeScreen() {
        StartPage startPage = new StartPage(driver);

        //Открыть сайт DNS
        startPage.openPage();

        //Нажать кнопку Всё верно
        startPage.buttonYes().click();
        WaitHelper.readyStateComplete();
        ScreenshotHelper.makeScreenshot();

        //Скрыть хэдэр
        startPage.blockHeader().hide();


        ActionHelper.scrollTo(startPage.linkAppliances().getWebElement());
        startPage.linkAppliances().focusOnLink();
        WaitHelper.clickabilityOfElement(startPage.linkDrinksPreparation().getWebElement());
        startPage.linkDrinksPreparation().focusOnLink();
        WaitHelper.visibilityOfElement(startPage.linkElectricKettles().getWebElement());
        ScreenshotHelper.makeScreenshot();
        ActionHelper.scrollTo(startPage.linkAppliances().getWebElement());
        startPage.linkAppliances().focusOnLink();
        WaitHelper.clickabilityOfElement(startPage.linkDrinksPreparation().getWebElement());
        startPage.linkDrinksPreparation().focusOnLink();
        WaitHelper.visibilityOfElement(startPage.linkElectricKettles().getWebElement());

        return new StartPage(driver);
    }

    public static StartPage linkDrinksPreparationAndScreen() {
        StartPage startPage = new StartPage(driver);

        ActionHelper.scrollTo(startPage.linkAppliances().getWebElement());
        startPage.linkAppliances().focusOnLink();
        WaitHelper.clickabilityOfElement(startPage.linkDrinksPreparation().getWebElement());
        startPage.linkDrinksPreparation().focusOnLink();
        WaitHelper.visibilityOfElement(startPage.linkElectricKettles().getWebElement());
        ScreenshotHelper.makeScreenshot();
        ActionHelper.scrollTo(startPage.linkAppliances().getWebElement());
        startPage.linkAppliances().focusOnLink();
        WaitHelper.clickabilityOfElement(startPage.linkDrinksPreparation().getWebElement());
        startPage.linkDrinksPreparation().focusOnLink();
        WaitHelper.visibilityOfElement(startPage.linkElectricKettles().getWebElement());

        return new StartPage(driver);
    }

    public static KettlesPage linkKettlesAndScreen() {
        StartPage startPage = new StartPage(driver);

        startPage.linkDrinksPreparation().focusOnLink();
        startPage.linkElectricKettles().click();
        ScreenshotHelper.makeScreenshot();

        return new KettlesPage(driver);
    }
}
