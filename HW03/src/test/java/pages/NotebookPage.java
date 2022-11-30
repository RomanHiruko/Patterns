package pages;

import elements.Block;
import elements.Button;
import elements.Link;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotebookPage extends BasePage {
    @FindBy(xpath = "//button[text()='Развернуть все']")
    private WebElement buttonExpand;

    @FindBy(xpath = "//div[@class='product-card-description__title']")
    private WebElement textDescription;

    @FindBy(xpath = "//div[text()=' Объем оперативной памяти ']/..//div[not(text()=' Объем оперативной памяти ')]")
    private WebElement textRam;

    @FindBy(xpath = "//div[@class='product-card-top__name']")
    private WebElement textTitle;

    @FindBy(xpath = "//div[@class='v-confirm-city']")
    private WebElement blockYes;

    public NotebookPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Link textRam() {
        return new Link(textRam);
    }

    public Block blockYes() {
        return new Block(blockYes);
    }

    public Link textTitle() {
        return new Link(textTitle);
    }

    public Link textDescription() {
        return new Link(textDescription);
    }

    public Button buttonExpand() {
        return new Button(buttonExpand);
    }
}
