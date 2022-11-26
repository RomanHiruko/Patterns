package pages;


import elements.Block;
import elements.Button;
import elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class StartPage extends BasePage{
    private Logger logger = LogManager.getLogger(StartPage.class);
    private final String URL = "https://www.dns-shop.ru/";

    @FindBy(xpath = "//div[@class='v-confirm-city']")
    private WebElement blockYes;

    @FindBy(xpath = "//a[text()='Бытовая техника']")
    private WebElement linkAppliances;

    @FindBy(xpath = "//a[text()='Приготовление напитков']")
    private WebElement linkDrinksPreparation;

    @FindBy(xpath = "//a[text()='Приготовление напитков']//a")
    private List<WebElement> linksSubmenuDrinksPreparation;

    @FindBy(xpath = "//a[text()='Приготовление напитков']//a[text()='Электрочайники']")
    private WebElement linkElectricKettles;

    @FindBy(xpath = "//a[text()='Встраиваемая техника']")
    private WebElement linkEmbeddedTechnology;

    @FindBy(xpath = "//a[text()='Техника для кухни']")
    private WebElement linkKitchenAppliances;

    @FindBy(xpath = "//a[text()='Техника для дома']")
    private WebElement linkHomeAppliances;

    @FindBy(xpath = "//a[text()='ПК, ноутбуки, периферия']")
    private WebElement linkPcAndPeripheralXpath;

    @FindBy(xpath = "//a[text()='Ноутбуки']")
    private WebElement linkNotebooks;

    public StartPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    public String getURL() {
        logger.info((this.URL) + "");
        return this.URL;
    }

    public Dimension getSize(){
        Dimension size = driver.manage().window().getSize();
        logger.info(size);
        return size;
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info(title);
        return title;
    }

    public void openPage() {
        driver.get(this.URL);
        logger.info("Открыта страница https://www.dns-shop.ru/");
    }

    public Block blockYes() {
        return new Block(blockYes);
    }

    public Link linkAppliances(){
        return new Link(linkAppliances);
    }

    public Link linkDrinksPreparation(){
        return new Link(linkDrinksPreparation);
    }

    public List<WebElement> linksSubmenuDrinksPreparation(){
        return new ArrayList<>(linksSubmenuDrinksPreparation);
    }

    public Link linkElectricKettles(){
        return new Link(linkElectricKettles);
    }

    public Link linkEmbeddedTechnology(){
        return new Link(linkEmbeddedTechnology);
    }

    public Link linkKitchenAppliances(){
        return new Link(linkKitchenAppliances);
    }

    public Link linkHomeAppliances(){
        return new Link(linkHomeAppliances);
    }

    public Link linkPcAndPeripheralXpath(){
        return new Link(linkPcAndPeripheralXpath);
    }

    public Link linkNotebooks(){
        return new Link(linkNotebooks);
    }
}
