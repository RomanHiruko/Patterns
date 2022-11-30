package tests.notebooks;

import elements.Link;
import helpers.ActionHelper;
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
        KitchenAppliancesPage ktp = new KitchenAppliancesPage(driver);

        //1. Arrange
        Link[] args = {ktp.textKitchenAppliances(), ktp.linkMakeKitchen()};

        //2.Act
        //Открыть страницу DNS
        AppliancesPage appliancesPage = clickLinkAppliancesAndMakeScreen();

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
        //Проверить, что отображается текст Собери свою кухню
        KitchenAppliancesTextDisplayMatcher kitchenAppliancesTextDisplayMatcher = new KitchenAppliancesTextDisplayMatcher(kitchenAppliancesPage);
        kitchenAppliancesTextDisplayMatcher.pageTitleDisplay(args);

        //Вывести название всех категорий
        kitchenAppliancesPage.allCategories();
    }

    public static AppliancesPage clickLinkAppliancesAndMakeScreen() {
        StartPage startPage = new StartPage(driver);

        //Перейти по ссылке DNS
        startPage.openPage();

        //Нажать кнопку Всё верно и сделать скриншот
        startPage.buttonYes().click();
        WaitHelper.readyStateComplete();
        ScreenshotHelper.makeScreenshot();

        //Скрыть хэдэр
        startPage.blockHeader().hide();

        //Вывести в логи:
        //Текущий URL
        startPage.getURL();

        //Заголовок страницы
        startPage.getPageTitle();

        //Размер окна браузера
        startPage.getSize();

        //Нажать на ссылку Бытовая техника
        ActionHelper.scrollTo(startPage.linkAppliances().getWebElement());
        startPage.linkAppliances().click();
        ScreenshotHelper.makeScreenshot();

        return new AppliancesPage(driver);
    }
}
