package automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

public class MyPersonalInformationPage extends PageBase {

    @FindBy(xpath = "(//i[@class='icon-chevron-left']/..)[1]")
    private WebElement backToAccountButton;

    public MyPersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage goBackToAccountPage() {
        waitForElementToBeVisible(backToAccountButton);
        backToAccountButton.click();

        return new AccountPage(driver);
    }
}
