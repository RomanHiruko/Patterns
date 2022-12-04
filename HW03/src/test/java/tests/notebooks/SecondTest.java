package tests.notebooks;

import elements.Link;
import org.junit.jupiter.api.Test;
import pages.KettlesPage;
import pages.StartPage;
import steps.StartPageSteps;
import tests.BaseTest;
import tests.notebooks.matchers.StartPageMatcher;
import tests.notebooks.matchers.TitleCountProductPageMatcher;

public class SecondTest extends BaseTest {

    @Test
    public void appliancesTextArrestDnsTest() {
        StartPage sp = new StartPage(driver);

        //1. Arrange
        Link[] args = {sp.linkKitchenAppliances(), sp.linkHomeAppliances(), sp.linkEmbeddedTechnology()};

        //2. Act
        //Перейти по ссылке DNS
        StartPageSteps startPage = focusLinkAppliances();

        //3. Assert
        //Проверить, что отображается текст
        //Техника для дома
        //Техника для кухни
        //Встроенная техника
        StartPageMatcher startPageMatcher = new StartPageMatcher(startPage);
        startPageMatcher.linkDisplay(args);
    }

    @Test
    public void drinkPreparationCountDnsTest() {
        StartPage sp = new StartPage(driver);
        //1. Arrange -

        //2. Act
        StartPageSteps startPage = focusLinkDrinksPreparation();

        //3. Assert
        //Проверить, что количество ссылок в подменю Приготовление напитков больше 5
        StartPageMatcher startPageMatcher = new StartPageMatcher(startPage);
        startPageMatcher.allCategories(sp.linksSubmenuDrinksPreparation());
    }

    @Test
    public void kettlesCountDnsTest() {
        //1. Arrange -

        //2. Act
        KettlesPage kettlesPage = clickLinkKettles();

        //3. Assert
        //Проверить, что  количество продуктов по ссылке Электрочайники больше 1000
        TitleCountProductPageMatcher titleCountProductPageMatcher = new TitleCountProductPageMatcher(kettlesPage);
        titleCountProductPageMatcher.productCount(kettlesPage.textProductCount());
    }

    public static StartPageSteps focusLinkAppliances() {
        StartPageSteps startPage = new StartPageSteps(driver);

        startPage.openPage();

        //Нажать кнопку Всё верно
        startPage.clickButtonYes();

        //Скрыть хэдэр
        startPage.hideHeader();

        //Навести на ссылку Бытовая техника
        startPage.focusLinkAppliances();

        return new StartPageSteps(driver);
    }

    public static StartPageSteps focusLinkDrinksPreparation() {
        StartPageSteps startPage = new StartPageSteps(driver);

        startPage.openPage();

        //Навести на ссылку Приготовление напитков
        startPage.clickButtonYes();
        startPage.focusLinkAppliances();
        startPage.focusOnLinkDrinksPreparation();

        return new StartPageSteps(driver);
    }

    public static KettlesPage clickLinkKettles() {
        StartPageSteps startPage = new StartPageSteps(driver);

        startPage = focusLinkDrinksPreparation();

        startPage.clickLinkElectricKettles();

        return new KettlesPage(driver);
    }
}
