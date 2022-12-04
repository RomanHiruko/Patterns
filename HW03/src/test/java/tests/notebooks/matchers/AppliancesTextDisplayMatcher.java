package tests.notebooks.matchers;

import elements.Link;
import org.junit.jupiter.api.Assertions;
import pages.AppliancesPage;
import steps.AppliancesPageSteps;

public class AppliancesTextDisplayMatcher {
    AppliancesPageSteps page;

    public AppliancesTextDisplayMatcher(AppliancesPageSteps page) {
        this.page = page;
    }

    public void pageTitleDisplay(Link element) {
        Assertions.assertTrue(element.isDisplayed(), "Текст не отображается!");
    }
}
