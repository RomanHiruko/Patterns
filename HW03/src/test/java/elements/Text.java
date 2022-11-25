package elements;

import org.openqa.selenium.WebElement;

public class Text extends BaseElement {
    public Text(WebElement webElement) {
        super(webElement);
    }

    public String getText() {
        String text = webElement.getText();
        return text;
    }
}
