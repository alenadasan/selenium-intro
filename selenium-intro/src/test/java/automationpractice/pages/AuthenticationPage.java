package automationpractice.pages;

import automationpractice.pages.checkout.AddressPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

/**
 * Created by Ale on 15/01/18.
 */
public class AuthenticationPage extends PageBase {

    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;
    @FindBy(xpath = "//*[contains(@class, 'alert')]")
    private WebElement statusMessage;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage loginAs(String email, String password) {
        fillInLoginForm(email, password);

        return new AccountPage(driver);
    }

    public AuthenticationPage loginAndExpectErrors(String email, String password) {
        fillInLoginForm(email, password);

        return new AuthenticationPage(driver);
    }

    public AddressPage loginAndContinueCheckout(String email, String password) {
        fillInLoginForm(email, password);

        return new AddressPage(driver);
    }

    private void fillInLoginForm(String email, String password) {
        waitForElementToBeVisible(emailInput);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }


    public String getStatusMessage() {
        waitForElementToBeVisible(statusMessage);
        return statusMessage.getText();
    }
}
