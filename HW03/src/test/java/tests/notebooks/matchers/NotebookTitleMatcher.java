package tests.notebooks.matchers;

import org.junit.jupiter.api.Assertions;
import pages.NotebookPage;

public class NotebookTitleMatcher {
    NotebookPage page;

    public NotebookTitleMatcher(NotebookPage page) {
        this.page = page;
    }

    public void pageTitleEquals(String titleOldWindow, String expected) {
        String titleNewWindow = page.textTitle().getAttribute("outerText");
        Assertions.assertEquals(expected, titleNewWindow, "Ошибка! Заголовок не соответствует ожидаемому");
        Assertions.assertTrue(titleOldWindow.contains(titleNewWindow), "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }
}
