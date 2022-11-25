package tests.notebooks.matchers;

import elements.Link;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.AppliancesPage;

public class AppliancesTextDisplayMatcher {
    AppliancesPage page;

    public AppliancesTextDisplayMatcher(AppliancesPage page) {
        this.page = page;
    }

    public void pageTitleDisplay(Link element) {
        Assertions.assertTrue(element.isDisplayed(), "Текст не отображается!");
    }
}
