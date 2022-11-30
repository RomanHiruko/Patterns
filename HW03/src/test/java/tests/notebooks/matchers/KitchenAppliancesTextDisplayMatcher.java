package tests.notebooks.matchers;

import elements.Link;
import org.junit.jupiter.api.Assertions;
import pages.KitchenAppliancesPage;

public class KitchenAppliancesTextDisplayMatcher {

    KitchenAppliancesPage page;

    public KitchenAppliancesTextDisplayMatcher(KitchenAppliancesPage page) {
        this.page = page;
    }

    public void pageTitleDisplay(Link[] args) {
        for (Link element : args) {
            Assertions.assertTrue(element.isDisplayed(), "Текст не отображается!");
        }
    }
}
