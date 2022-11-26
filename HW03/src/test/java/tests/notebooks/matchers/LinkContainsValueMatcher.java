package tests.notebooks.matchers;

import elements.Link;
import org.junit.jupiter.api.Assertions;
import pages.NotebookPage;

public class LinkContainsValueMatcher {
    NotebookPage page;

    public LinkContainsValueMatcher(NotebookPage page){
        this.page = page;
    }

    public void linkContainsValue(Link link, String value){
        Assertions.assertTrue(link.getText().contains(value), "Текст не содержит значение!");
    }
}
