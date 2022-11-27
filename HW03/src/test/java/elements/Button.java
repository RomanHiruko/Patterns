package elements;

import helpers.ActionHelper;
import helpers.JavaScriptHelper;
import helpers.WaitHelper;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement {
    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }

    public void hide() {
        JavaScriptHelper.displayNone(webElement);
    }
}
