package tests.notebooks.matchers;

import elements.Link;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.KettlesPage;

public class TitleCountProductPageMatcher {
    KettlesPage page;

    public TitleCountProductPageMatcher(KettlesPage page) {
        this.page = page;
    }
    public void productCount(Link element){
        String countProduct = element.Text();
        int count = Integer.parseInt(countProduct.split(" ")[0]);
        Assertions.assertTrue(count > 1000, "в тексте Электрические чайники [количество] товаров количество товаров меньше или равно 1000");
    }
}
