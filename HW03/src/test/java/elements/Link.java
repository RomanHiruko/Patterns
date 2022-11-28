package elements;

import helpers.NavigationHelper;
import helpers.SwitchHelper;
import helpers.WaitHelper;
import helpers.WindowHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class Link extends BaseElement {
    private final Logger logger = LogManager.getLogger(Link.class);

    public Link(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }

    public String getAttribute(String attr) {
        return webElement.getAttribute(attr);
    }

    public void openInNewWindow() {
        String URL = this.getURL();
        SwitchHelper.switchToNewWindow();
        WindowHelper.maximizeWindow();
        NavigationHelper.navigateTo(URL);
    }

    public String getURL() {
        return webElement.getAttribute("href");
    }

    public String getText() {
        return webElement.getText();
    }

    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public String Text() {
        return webElement.getText();
    }
}
