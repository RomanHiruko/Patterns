package steps;

import elements.Link;
import helpers.JavaScriptHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.NotebookPage;

public class NotebookProductPageSteps {
    private static Logger logger = LogManager.getLogger(NotebookProductPageSteps.class);
    private NotebookPage notebookPage;

    public NotebookProductPageSteps(WebDriver driver) {
        notebookPage = new NotebookPage(driver);
        logger.info("Открыта страница [Продукт. Ноутбук]");
    }

    public String getPageTitle() {
        logger.info("Страница [Продукт. Ноутбук]: Получение заголовка текущей страницы");
        return notebookPage.getPageTitle();
    }

    public void clickButtonExpandAll() {
        JavaScriptHelper.scrollIntoView(notebookPage.buttonExpand().getWebElement());
        notebookPage.blockHeader().hide();
        notebookPage.buttonExpand().click();
        JavaScriptHelper.scrollBy(0, -2000);
    }

    public Link textTitle(){
        return notebookPage.textTitle();
    }
}
