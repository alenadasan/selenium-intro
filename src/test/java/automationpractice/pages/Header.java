package automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

public class Header extends PageBase {

    @FindBy(partialLinkText = "Contact us")
    private WebElement contactUsButton;
    @FindBy(id = "search_query_top")
    private WebElement searchField;
    @FindBy(name = "submit_search")
    private WebElement searchButton;
    @FindBy(xpath = "//a[@class='account']/span")
    private WebElement accountButton;

    public Header(WebDriver driver) {
        super(driver);
    }

    public ContactPage clickContactUs() {
        waitForElementToBeVisible(contactUsButton);
        contactUsButton.click();

        return new ContactPage(driver);
    }

    public ResultsPage searchFor(String query) {
        waitForElementToBeVisible(searchField);
        searchField.clear();
        searchField.sendKeys(query);
        searchButton.click();

        return new ResultsPage(driver);
    }

    public String getLoggedInUserName() {
        waitForElementToBeVisible(accountButton);
        return accountButton.getText();
    }
}
