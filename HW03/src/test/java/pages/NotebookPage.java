package pages;

import elements.Button;
import elements.Text;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotebookPage extends BasePage {
    @FindBy(xpath = "//button[text()='Развернуть все']")
    private WebElement buttonExpand;

    @FindBy(xpath = "//div[@class='product-card-description__title']")
    private WebElement textTitle;

    @FindBy(xpath = "//div[text()=' Объем оперативной памяти ']/..//div[not(text()=' Объем оперативной памяти ')]")
    private WebElement textRam;

    public NotebookPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Button buttonExpand() {
        return new Button(buttonExpand);
    }

    public Text textTitle() {
        return new Text(textTitle);
    }

    public Text textRam() {
        return new Text(textRam);
    }
}
