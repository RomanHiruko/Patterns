package tests.notebooks.matchers;

import elements.Link;
import org.junit.jupiter.api.Assertions;
import steps.StartPageSteps;

import java.util.List;

public class StartPageMatcher {
    StartPageSteps page;

    public StartPageMatcher(StartPageSteps page) {
        this.page = page;
    }

    public void allCategories(List elements) {
        Assertions.assertTrue(elements.size() > 5, "Количество категорий меньше или равно 5");
    }

    public void linkDisplay(Link[] args) {
        for (Link element : args) {
            Assertions.assertTrue(element.isDisplayed(), "Ссылка не отображается");
        }
    }
}
