package tests.notebooks.matchers;

import org.junit.jupiter.api.Assertions;
import pages.BasePage;
import pages.KitchenAppliancesPage;

import java.util.List;

public class CategoriesCountMatcher {

    BasePage page;

    public CategoriesCountMatcher(BasePage page) {
        this.page = page;
    }

    public void allCategories(List elements){
        Assertions.assertTrue(elements.size() > 5, "Количество категорий меньше или равно 5");
    }
}
