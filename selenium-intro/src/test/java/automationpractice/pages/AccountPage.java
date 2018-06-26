package automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

/**
 * Created by Ale on 16/01/18.
 */
public class AccountPage extends PageBase {

    @FindBy(xpath = "//a[@class='account']/span")
    private WebElement accountButton;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInUserName() {
        waitForElementToBeVisible(accountButton);
        return accountButton.getText();
    }
}
