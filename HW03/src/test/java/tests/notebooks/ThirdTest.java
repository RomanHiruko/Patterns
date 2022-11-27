package tests.notebooks;

import helpers.*;
import org.junit.jupiter.api.Test;
import pages.NotebookPage;
import pages.NotebooksPage;
import pages.StartPage;
import tests.BaseTest;
import tests.notebooks.matchers.LinkContainsValueMatcher;
import tests.notebooks.matchers.NotebookTitleMatcher;

public class ThirdTest extends BaseTest {
    String titleOldWindow;
    String titleDescription;
    String textRam;

    @Test
    public void dnsTest() {
        //1. Arrange
        String expected = "Купить 16\" Ноутбук ASUS ROG Flow X16 GV601RW-M6064X черный";
        String company = "ASUS";
        String ram = "32 ГБ";
        String type = "Сначала дорогие";

        //2. Act
        NotebookPage notebookPage = getNotebookPage(company, ram, type);

        //3. Assert
        NotebookTitleMatcher notebookTitleMatcher = new NotebookTitleMatcher(notebookPage);
        notebookTitleMatcher.pageTitleEquals(titleOldWindow);
        notebookTitleMatcher.pageExpectedEquals(expected);
        LinkContainsValueMatcher linkContainsValueMatcher = new LinkContainsValueMatcher(notebookPage);
        linkContainsValueMatcher.linkContainsValue(notebookPage.textDescription(), titleDescription);
        linkContainsValueMatcher.linkContainsValue(notebookPage.textRam(), textRam);

    }

    public NotebookPage getNotebookPage(String company, String ram, String type) {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.buttonYes().click();
        WaitHelper.readyStateComplete();
        ScreenshotHelper.makeScreenshot();
        startPage.linkPcAndPeripheral().focusOnLink();
        WaitHelper.clickabilityOfElement(startPage.linkNotebooks().getWebElement());
        ScreenshotHelper.makeScreenshot();
        startPage.linkPcAndPeripheral().focusOnLink();
        WaitHelper.clickabilityOfElement(startPage.linkNotebooks().getWebElement());
        startPage.linkNotebooks().click();

        NotebooksPage notebooksPage = new NotebooksPage(driver);
        ScreenshotHelper.makeScreenshot();
        notebooksPage.blockHeader().hide();
        ScreenshotHelper.makeScreenshot();
        notebooksPage.accordeonSort().show();
        notebooksPage.radioButtonSort(type).setSelected(true);
        JavaScriptHelper.scrollTo(notebooksPage.checkBoxCompany(company).getWebElement());
        notebooksPage.checkBoxCompany(company).setChecked(true);
        JavaScriptHelper.scrollBy(0, 600);
        notebooksPage.accordeonRAM().show();
        notebooksPage.checkboxRAM(ram).setChecked(true);
        JavaScriptHelper.scrollBy(0, 600);
        notebooksPage.buttonApply().click();
        WaitHelper.propertyLoad(notebooksPage.linkCatalog().getWebElement(), "style", "[]");
        ScreenshotHelper.makeScreenshot();
        this.titleOldWindow = notebooksPage.linkFirstProduct().getAttribute("outerText");
        notebooksPage.linkFirstProduct().openInNewWindow();

        NotebookPage notebookPage = new NotebookPage(driver);
        ScreenshotHelper.makeScreenshot();
        JavaScriptHelper.scrollTo(notebookPage.buttonExpand().getWebElement());
        notebooksPage.blockHeader().hide();
        notebookPage.buttonExpand().click();
        JavaScriptHelper.scrollBy(0, -2000);
        this.titleDescription = notebookPage.textDescription().getText();
        this.textRam = notebookPage.textRam().getText();
        return new NotebookPage(driver);
    }
}
