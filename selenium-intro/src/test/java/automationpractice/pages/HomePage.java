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

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ContactPage clickContactUs() {
        waitForElementToBeVisible(contactUsButton);
        contactUsButton.click();

        return new ContactPage(driver);
    }

}
