package tests.notebooks.matchers;

import elements.Link;
import org.junit.jupiter.api.Assertions;
import steps.NotebookProductPageSteps;

public class NotebookProductPageMatcher {
    NotebookProductPageSteps page;

    public NotebookProductPageMatcher(NotebookProductPageSteps page) {
        this.page = page;
    }

    public void pageTitleEquals(String titleOldWindow, String expected) {
        String titleNewWindow = page.textTitle().getAttribute("outerText");
        System.out.println(titleNewWindow);
        System.out.println(titleOldWindow);
        System.out.println(expected);
        Assertions.assertEquals(expected, titleNewWindow, "Ошибка! Заголовок не соответствует ожидаемому");
        Assertions.assertTrue(titleOldWindow.contains(titleNewWindow), "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }

    public void linkContainsValue(Link[] links, String[] values) {
        for (int i = 0; i < links.length; i++) {
            Assertions.assertTrue(links[i].getText().contains(values[i]), "Текст не содержит значение!");
        }
    }
}
