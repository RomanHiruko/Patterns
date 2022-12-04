package steps;

import helpers.JavaScriptHelper;
import helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.NotebooksPage;

public class NotebooksPageSteps {
    private static Logger logger = LogManager.getLogger(NotebooksPageSteps.class);
    private NotebooksPage notebooksPage;

    public NotebooksPageSteps(WebDriver driver) {
        notebooksPage = new NotebooksPage(driver);
        logger.info("Открыта страница [Ноутбуки]");
    }

    public void orderBy(String type) {
        notebooksPage.accordeonSort().show();
        notebooksPage.radioButtonSort(type).setSelected(true);
        logger.info("Страница [Ноутбуки]: Установка сортировки <" + type + ">");
    }

    public void filterByRAM(int ram) {
        JavaScriptHelper.scrollBy(0, 600);
        notebooksPage.accordeonRAM().show();
        JavaScriptHelper.scrollBy(0, 400);
        notebooksPage.checkboxRAM(ram + " ГБ").setChecked(true);
        logger.info("Страница [Ноутбуки]: Установка фильтра \"Объем оперативной памяти\" - <" + ram + ">");
    }

    public void applyFilter() {
        JavaScriptHelper.scrollIntoView(notebooksPage.buttonApply().getWebElement());
        notebooksPage.buttonApply().click();
        logger.info("Страница [Ноутбуки]: Применение фильтров");
    }

    public void goToFirstProduct() {
        JavaScriptHelper.scrollBy(0, -2000);
        notebooksPage.linkFirstProduct().openInNewWindow();
        logger.info("Страница [Ноутбуки]: Переход на страницу первого продукта в списке");
    }

    public void filterByCompany(String company) {
        JavaScriptHelper.scrollBy(0, 800);
        notebooksPage.checkBoxCompany(company).setChecked(true);
    }

    public String getName(){
        WaitHelper.propertyLoad(notebooksPage.linkCatalog().getWebElement(), "style", "[]");
        return notebooksPage.linkFirstProduct().getAttribute("outerText");
    }
}
