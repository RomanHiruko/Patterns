package tests.notebooks.matchers;

import elements.Link;
import org.junit.jupiter.api.Assertions;
import pages.StartPage;

public class StartPageTextDisplayMatcher {
    StartPage page;

    public StartPageTextDisplayMatcher(StartPage page){
        this.page = page;
    }

    public void linkDisplay(Link element){
        Assertions.assertTrue(element.isDisplayed(), "Ссылка не отображается");
    }
}
