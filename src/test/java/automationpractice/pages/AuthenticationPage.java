package automationpractice.pages;

import automationpractice.pages.checkout.AddressPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

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

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountButton;
    @FindBy(id = "create_account_error")
    private WebElement createAccountError;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage loginAs(String email, String password) {
        wait.until(visibilityOf(emailInput));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();

        return new AccountPage(driver);
    }

    public AuthenticationPage loginAndExpectErrors(String email, String password) {
        wait.until(visibilityOf(emailInput));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();

        return new AuthenticationPage(driver);
    }

    public AddressPage loginAndContinueCheckout(String email, String password) {
        waitForElementToBeVisible(emailInput);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();

        return new AddressPage(driver);
    }


    public String getStatusMessage() {
        waitForElementToBeVisible(statusMessage);
        return statusMessage.getText();
    }

    public void clickCreateAccount() {
        waitForElementToBeVisible(createAnAccountButton);
        createAnAccountButton.click();
    }

    public String getError() {
        waitForElementToBeVisible(createAccountError);
        return createAccountError.getText();
    }
}
