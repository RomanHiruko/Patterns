package tests.notebooks;

import helpers.JavaScriptHelper;
import helpers.ScreenshotHelper;
import helpers.WaitHelper;
import listeners.Listeners;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import pages.NotebookPage;
import pages.NotebooksPage;
import pages.StartPage;
import tests.BaseTest;
import tests.notebooks.matchers.LinkContainsValueMatcher;
import tests.notebooks.matchers.NotebookTitleMatcher;

public class ThirdTest extends BaseTest {
    String titleOldWindow;
    String titleDescription;
    String textRam;

    @Test
    public void dnsTest() {
        //1. Arrange
        String expected = "16\" Ноутбук ASUS ROG Flow X16 GV601RW-M6064X черный";
        String company = "ASUS";
        String ram = "32 ГБ";
        String type = "Сначала дорогие";

        //2. Act
        NotebookPage notebookPage = getNotebookPage(company, ram, type);

        //3. Assert
        //Проверить, что первый товар соответствует ожидаемому
        NotebookTitleMatcher notebookTitleMatcher = new NotebookTitleMatcher(notebookPage);
        notebookTitleMatcher.pageTitleEquals(titleOldWindow);
        notebookTitleMatcher.pageExpectedEquals(expected);

        //Проверить, что в разделе Характеристики содержится значение ASUS
        LinkContainsValueMatcher linkContainsValueMatcher = new LinkContainsValueMatcher(notebookPage);
        linkContainsValueMatcher.linkContainsValue(notebookPage.textDescription(), titleDescription);

        //Проверить, что значение ОЗУ равно 32 ГБ
        linkContainsValueMatcher.linkContainsValue(notebookPage.textRam(), textRam);

    }

    public NotebookPage getNotebookPage(String company, String ram, String type) {
        //Регистрация слушателя событий
        Listeners listener = new Listeners();
        WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

        //Открыть страницы DNS
        StartPage startPage = new StartPage(eventFiringWebDriver);
        startPage.openPage();

        //Нажать кнопку всё верно и сделать скриншот
        startPage.buttonYes().click();
        WaitHelper.readyStateComplete();
        ScreenshotHelper.makeScreenshot();

        //Навести курсор на ссылку Компьютеры и периферия и сделать скриншот после открытия меню
        startPage.linkPcAndPeripheral().focusOnLink();
        WaitHelper.clickabilityOfElement(startPage.linkNotebooks().getWebElement());
        ScreenshotHelper.makeScreenshot();

        //Перейти по ссылке Ноутбуки
        startPage.linkPcAndPeripheral().focusOnLink();
        WaitHelper.clickabilityOfElement(startPage.linkNotebooks().getWebElement());
        startPage.linkNotebooks().click();

        //Сделать скриншот
        NotebooksPage notebooksPage = new NotebooksPage(eventFiringWebDriver);
        ScreenshotHelper.makeScreenshot();

        //Скрыть header и сделать скриншот
        notebooksPage.blockHeader().hide();
        ScreenshotHelper.makeScreenshot();

        //Выбрать сортировку Сначала дорогое
        notebooksPage.accordeonSort().show();
        notebooksPage.radioButtonSort(type).setSelected(true);

        //Выбрать в фильтре Производитель значение ASUS
        JavaScriptHelper.scrollBy(0, 600);
        notebooksPage.checkBoxCompany(company).setChecked(true);

        //Выбрать в фильтре Объем оперативной памяти значение 32 ГБ
        JavaScriptHelper.scrollBy(0, 600);
        notebooksPage.accordeonRAM().show();
        notebooksPage.checkboxRAM(ram).setChecked(true);

        //Применить фильтры и сделать скриншот
        JavaScriptHelper.scrollBy(0, 600);
        notebooksPage.buttonApply().click();
        WaitHelper.propertyLoad(notebooksPage.linkCatalog().getWebElement(), "style", "[]");
        ScreenshotHelper.makeScreenshot();

        //Перейти на страницу первого продукта в списке
        //Страница открывается в новом окне
        //Страница открывается в максимизированном режиме (не fullscreen)
        //Получить название первого товара
        this.titleOldWindow = notebooksPage.linkFirstProduct().getAttribute("outerText");
        notebooksPage.linkFirstProduct().openInNewWindow();

        //Сделать скриншот
        NotebookPage notebookPage = new NotebookPage(eventFiringWebDriver);
        ScreenshotHelper.makeScreenshot();

        //Нажать кнопку Развернуть все
        JavaScriptHelper.scrollTo(notebookPage.buttonExpand().getWebElement());
        notebooksPage.blockHeader().hide();
        notebookPage.buttonExpand().click();
        JavaScriptHelper.scrollBy(0, -2000);


        //Проверить значение в разделе характеристики и ОЗУ
        this.titleDescription = notebookPage.textDescription().getText();
        this.textRam = notebookPage.textRam().getText();
        return new NotebookPage(eventFiringWebDriver);
    }
}
