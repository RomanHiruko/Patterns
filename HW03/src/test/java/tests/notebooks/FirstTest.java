package tests.notebooks;

import helpers.ScreenshotHelper;
import helpers.WaitHelper;
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
        //Открыть страницу DNS
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        ScreenshotHelper.makeScreenshot();

        //Вывести в логи:
        //Текущий URL
        startPage.getURL();

        //Заголовок страницы
        startPage.getPageTitle();

        //Размер окна браузера
        startPage.getSize();

        //Нажать кнопку Всё верно
        startPage.buttonYes().click();
        WaitHelper.readyStateComplete();
        ScreenshotHelper.makeScreenshot();

        //Нажать на ссылку Бытовая техника
        startPage.linkAppliances().click();
        AppliancesPage appliancesPage = new AppliancesPage(driver);
        ScreenshotHelper.makeScreenshot();

        //3. Assert
        //Проверить, что отображается текст Бытовая техника
        AppliancesTextDisplayMatcher appliancesTextDisplayMatcher = new AppliancesTextDisplayMatcher(appliancesPage);
        appliancesTextDisplayMatcher.pageTitleDisplay(appliancesPage.textAppliances());

        //4. Act
        //Перейти по ссылке Техника для кухни
        appliancesPage.linkKitchenAppliances().click();
        KitchenAppliancesPage kitchenAppliancesPage = new KitchenAppliancesPage(driver);

        //5.Assert
        //Проверить, что отображается текст Техника для кухни
        KitchenAppliancesTextDisplayMatcher kitchenAppliancesTextDisplayMatcher = new KitchenAppliancesTextDisplayMatcher(kitchenAppliancesPage);
        kitchenAppliancesTextDisplayMatcher.pageTitleDisplay(kitchenAppliancesPage.textKitchenAppliances());
        //Проверить, что отображается текст Собери свою кухню
        kitchenAppliancesTextDisplayMatcher.pageTitleDisplay(kitchenAppliancesPage.linkMakeKitchen());

        //Вывести название всех категорий
        kitchenAppliancesPage.allCategories();
    }
}
