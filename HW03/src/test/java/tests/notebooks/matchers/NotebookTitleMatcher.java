package tests.notebooks.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.NotebookPage;

public class NotebookTitleMatcher {
    private static Logger logger = LogManager.getLogger(NotebookTitleMatcher.class);
    NotebookPage page;

    public NotebookTitleMatcher(NotebookPage page){
        this.page = page;
    }

    public void pageTitleEquals(String titleOldWindow){
        String titleNewWindow = page.textTitle().getAttribute("outerText");
        Assertions.assertTrue(titleOldWindow.contains(titleNewWindow), "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }
}
