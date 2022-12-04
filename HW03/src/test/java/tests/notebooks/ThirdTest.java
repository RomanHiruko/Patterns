package tests.notebooks;

import elements.Link;
import helpers.WaitHelper;
import listeners.Listeners;
import models.BL;
import models.BLBuilder;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import models.valueobjects.Type;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import pages.NotebookPage;
import steps.NotebookProductPageSteps;
import steps.NotebooksPageSteps;
import steps.StartPageSteps;
import tests.BaseTest;
import tests.notebooks.matchers.NotebookProductPageMatcher;

public class ThirdTest extends BaseTest {
    String titleOldWindow;

    @Test
    public void expectedEqualsActualTitleDnsTest() {

        //1. Arrange
        String expected = "16\" Ноутбук ASUS ROG Flow x16 GV601RM-M6059W черный";
        String company = "ASUS";
        int ram = 32;
        int rom = 256;
        String model = "S22";
        String type = "Сначала дорогие";
        BLBuilder blbuilder = new BLBuilder(
                new Ram(ram),
                new Company(company),
                new Type(type))
                .setRom(rom)
                .setModel(model);
        BL bl = blbuilder.build();

        //2. Act
        NotebookProductPageSteps notebookPage = getNotebookPage(bl);

        //3. Assert
        //Проверить, что первый товар соответствует ожидаемому
        NotebookProductPageMatcher notebookProductPageMatcher = new NotebookProductPageMatcher(notebookPage);
        notebookProductPageMatcher.pageTitleEquals(titleOldWindow, expected);
    }

    @Test
    public void linkContainsValueDnsTest() {
        NotebookPage np = new NotebookPage(driver);

        //1. Arrange
        Link[] links = {np.textDescription(), np.textRam()};
        String[] values = {"ASUS", "32 ГБ"};
        String company = "ASUS";
        int ram = 32;
        int rom = 256;
        String model = "S22";
        String type = "Сначала дорогие";
        BLBuilder blbuilder = new BLBuilder(
                new Ram(ram),
                new Company(company),
                new Type(type))
                .setRom(rom)
                .setModel(model);
        BL bl = blbuilder.build();

        //2. Act
        NotebookProductPageSteps notebookPage = getNotebookPage(bl);

        //3. Assert
        //Проверить, что в разделе Характеристики содержится значение ASUS
        //Проверить, что значение ОЗУ равно 32 ГБ
        NotebookProductPageMatcher notebookProductPageMatcher = new NotebookProductPageMatcher(notebookPage);
        notebookProductPageMatcher.linkContainsValue(links, values);
    }

    public NotebookProductPageSteps getNotebookPage(BL bl) {
        //Регистрация слушателя событий
        Listeners listener = new Listeners();
        WebDriver eventFiringWebDriver = new EventFiringDecorator<>(listener).decorate(driver);

        //Открыть страницы DNS
        StartPageSteps startPage = new StartPageSteps(eventFiringWebDriver);

        //Перейти по ссылке Ноутбуки
        startPage.goToNotebooksPage();
        NotebooksPageSteps notebooksPage = new NotebooksPageSteps(eventFiringWebDriver);

        //Выбрать сортировку Сначала дорогое
        notebooksPage.orderBy(bl.getType().getType());

        //Выбрать в фильтре Производитель значение ASUS
        notebooksPage.filterByCompany(bl.getCompany().getCompany());

        //Выбрать в фильтре Объем оперативной памяти значение 32 ГБ
        notebooksPage.filterByRAM(bl.getRam().getRam());

        //Применить фильтры и сделать скриншот
        notebooksPage.applyFilter();

        //Перейти на страницу первого продукта в списке
        //Страница открывается в новом окне
        //Страница открывается в максимизированном режиме (не fullscreen)
        //Получить название первого товара
        WaitHelper.sleep(1000);
        this.titleOldWindow = notebooksPage.getName();
        notebooksPage.goToFirstProduct();

        //Нажать кнопку Развернуть все
        NotebookProductPageSteps notebookProductPageSteps =
                new NotebookProductPageSteps(eventFiringWebDriver);
        notebookProductPageSteps.clickButtonExpandAll();

        return new NotebookProductPageSteps(eventFiringWebDriver);
    }
}
