package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ale on 09/08/17.
 */
public class Header extends PageBase {

    @FindBy(className = "logo")
    private WebElement siteLogo;
    @FindBy(xpath = "//div[@class='navbar']//i[contains(@class, 'icon_set_1_icon-70')]")
    private WebElement userAccountButton;
    @FindBy(partialLinkText = "Logout")
    private WebElement logoutDropDownOption;
    @FindBy(linkText = "Account")
    private WebElement accountLink;

    public Header(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        waitForElementToBeVisible(siteLogo);
        siteLogo.click();

        return new HomePage(driver);
    }

    public LoginPage logOut() throws InterruptedException {
        clickUserAccountButton();
        waitForElementToBeVisible(logoutDropDownOption);
        logoutDropDownOption.click();

        return new LoginPage(driver);
    }

    public AccountPage goToMyAccount() {
        clickUserAccountButton();
        waitForElementToBeVisible(accountLink);
        accountLink.click();

        return new AccountPage(driver);
    }

    public void clickUserAccountButton() {
        waitForElementToBeVisible(userAccountButton);
        userAccountButton.click();
    }
}
