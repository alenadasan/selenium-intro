package automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

/**
 * Created by Ale on 16/01/18.
 */
public class AccountPage extends PageBase {

    @FindBy(xpath = "//span[text()='My personal information']")
    private WebElement myPersonalInformationButton;

    private Header header;

    public AccountPage(WebDriver driver) {
        super(driver);
        waitForURLToContain("account");
        header = new Header(driver);
    }

    public MyPersonalInformationPage clickMyPersonalInformation() {
        waitForElementToBeVisible(myPersonalInformationButton);
        myPersonalInformationButton.click();

        return new MyPersonalInformationPage(driver);
    }

    public Header getHeader() {
        return header;
    }
}
