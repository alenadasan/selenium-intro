package automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

/**
 * Created by Ale on 15/01/18.
 */
public class HomePage extends PageBase{


    @FindBy(partialLinkText = "Contact us")
    private WebElement contactUsButton;
    @FindBy(id = "search_query_top")
    private WebElement searchField;
    @FindBy(name = "submit_search")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
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
}
