package pages;

import elements.Link;
import elements.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KitchenAppliancesPage extends BasePage {
    private Logger logger = LogManager.getLogger(KitchenAppliancesPage.class);

    @FindBy(xpath = "//a[text()='Собрать свою кухню']")
    private WebElement linkMakeKitchen;

    @FindBy(xpath = "//div[@class='subcategory__item-container ']/a")
    private WebElement linksSubCategories;

    @FindBy(xpath = "//h1[text()='Техника для кухни']")
    private WebElement textKitchenAppliances;

    public KitchenAppliancesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Link linksSubCategories(){
        return new Link(linksSubCategories);
    }

    public Link linkMakeKitchen(){
        return new Link(linkMakeKitchen);
    }

    public Text textKitchenAppliances(){
        return new Text(textKitchenAppliances);
    }
}
