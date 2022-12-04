package tests.notebooks;

import elements.Link;
import org.junit.jupiter.api.Test;
import pages.AppliancesPage;
import pages.KitchenAppliancesPage;
import steps.AppliancesPageSteps;
import steps.StartPageSteps;
import tests.BaseTest;
import tests.notebooks.matchers.AppliancesTextDisplayMatcher;
import tests.notebooks.matchers.KitchenAppliancesTextDisplayMatcher;

public class FirstTest extends BaseTest {
    @Test
    public void textAppliancesDisplayedDnsTest() {
        AppliancesPage ap = new AppliancesPage(driver);

        //1. Arrange -

        //2.Act
        //Открыть страницу DNS
        AppliancesPageSteps appliancesPage = clickLinkAppliances();

        //3. Assert
        //Проверить, что отображается текст Бытовая техника
        AppliancesTextDisplayMatcher appliancesTextDisplayMatcher = new AppliancesTextDisplayMatcher(appliancesPage);
        appliancesTextDisplayMatcher.pageTitleDisplay(ap.textAppliances());
    }

    @Test
    public void kitchenTextDisplayedDnsTest() {
        KitchenAppliancesPage ktp = new KitchenAppliancesPage(driver);

        //1. Arrange
        Link[] args = {ktp.textKitchenAppliances(), ktp.linkMakeKitchen()};

        //2.Act
        //Перейти по ссылке Техника для кухни
        KitchenAppliancesPage kitchenAppliancesPage = clickKitchenAppliances();

        //3.Assert
        //Проверить, что отображается текст Техника для кухни
        //Проверить, что отображается текст Собери свою кухню
        KitchenAppliancesTextDisplayMatcher kitchenAppliancesTextDisplayMatcher = new KitchenAppliancesTextDisplayMatcher(kitchenAppliancesPage);
        kitchenAppliancesTextDisplayMatcher.pageTitleDisplay(args);
    }

    @Test
    public void displayAllCategoriesDnsTest() {
        KitchenAppliancesPage kitchenAppliancesPage;

        //1. Arrange

        //2.Act
        //Вывести название всех категорий
        kitchenAppliancesPage = displayAllCategories();
    }

    public static AppliancesPageSteps clickLinkAppliances() {
        StartPageSteps startPage = new StartPageSteps(driver);

        //Перейти по ссылке DNS
        startPage.openPage();

        //Нажать кнопку Всё верно
        startPage.clickButtonYes();

        //Скрыть хэдэр
        startPage.hideHeader();

        //Вывести в логи:
        //Текущий URL
        //Заголовок страницы
        //Размер окна браузера
        startPage.printInfo();

        //Нажать на ссылку Бытовая техника
        startPage.clickLinkAppliances();

        return new AppliancesPageSteps(driver);
    }

    public static KitchenAppliancesPage clickKitchenAppliances() {
        AppliancesPageSteps appliancesPage = clickLinkAppliances();
        appliancesPage.clickLinkKitchenAppliances();
        return new KitchenAppliancesPage(driver);
    }

    public static KitchenAppliancesPage displayAllCategories() {
        KitchenAppliancesPage kitchenAppliancesPage = clickKitchenAppliances();
        kitchenAppliancesPage.allCategories();
        return new KitchenAppliancesPage(driver);
    }
}
