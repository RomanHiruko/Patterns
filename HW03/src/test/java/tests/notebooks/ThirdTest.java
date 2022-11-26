package tests.notebooks;

import helpers.JavaScriptHelper;
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
        String company = "ASUS";
        String ram = "32 ГБ";
        String type = "Сначала дорогие";

        //2. Act
        NotebookPage notebookPage = getNotebookPage(company, ram, type);

        //3. Assert
        NotebookTitleMatcher notebookTitleMatcher = new NotebookTitleMatcher(notebookPage);
        notebookTitleMatcher.pageTitleEquals(titleOldWindow);
        LinkContainsValueMatcher linkContainsValueMatcher = new LinkContainsValueMatcher(notebookPage);
        linkContainsValueMatcher.linkContainsValue(notebookPage.textDescription(), titleDescription);
        linkContainsValueMatcher.linkContainsValue(notebookPage.textRam(), textRam);

    }

    public NotebookPage getNotebookPage(String company, String ram, String type) {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.blockYes().hide();
        startPage.linkPcAndPeripheralXpath().focusOnLink();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startPage.linkNotebooks().click();

        NotebooksPage notebooksPage = new NotebooksPage(driver);
        notebooksPage.blockHeader().hide();
        notebooksPage.accordeonSort().show();
        notebooksPage.radioButtonSort(type).setSelected(true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavaScriptHelper.scrollBy(0, 900);
        notebooksPage.checkBoxCompany(company).setChecked(true);
        JavaScriptHelper.scrollBy(0, 500);
        notebooksPage.accordeonRAM().show();
        notebooksPage.checkboxRAM(ram).setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);
        notebooksPage.buttonApply().click();
        JavaScriptHelper.scrollBy(0, -2000);
        String titleOldWindow = notebooksPage.linkFirstProduct().getAttribute("outerText");
        this.titleOldWindow = titleOldWindow;
        notebooksPage.linkFirstProduct().openInNewWindow();

        NotebookPage notebookPage = new NotebookPage(driver);
        notebookPage.blockYes().hide();
        JavaScriptHelper.scrollBy(0, 700);
        notebookPage.buttonExpand().click();
        this.titleDescription = notebookPage.textDescription().getText();
        JavaScriptHelper.scrollBy(0, 600);
        this.textRam = notebookPage.textRam().getText();
        return new NotebookPage(driver);
    }
}
