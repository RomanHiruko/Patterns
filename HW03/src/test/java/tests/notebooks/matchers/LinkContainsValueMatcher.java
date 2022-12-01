package tests.notebooks.matchers;

import elements.Link;
import org.junit.jupiter.api.Assertions;
import pages.NotebookPage;

public class LinkContainsValueMatcher {
    NotebookPage page;

    public LinkContainsValueMatcher(NotebookPage page) {
        this.page = page;
    }

    public void linkContainsValue(Link[] links, String[] values) {
        for (int i = 0; i < links.length; i++) {
            Assertions.assertTrue(links[i].getText().contains(values[i]), "Текст не содержит значение!");
        }
    }
}
