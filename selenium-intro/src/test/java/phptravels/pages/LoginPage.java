package phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

/**
 * Created by Ale on 18/07/17.
 */

public class LoginPage extends PageBase {

    @FindBy(name = "username")
    private WebElement usernameInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class, 'alert')]")
    private WebElement errorMessage;
    @FindBy(xpath = "//form[@id='loginfrm']//a[contains(text(), 'Sign Up')]")
    private WebElement signUpLink;

    public LoginPage(WebDriver driver) {
        super(driver);
        waitForURLToContain("/login");
    }

    public AccountPage loginAs(String username, String password) {
        fillInUsername(username);
        fillInPassword(password);
        clickLogin();

        return new AccountPage(driver);
    }

    public LoginPage loginAndExpectErrors(String username, String password) {
        fillInUsername(username);
        fillInPassword(password);
        clickLogin();

        return new LoginPage(driver);
    }

    public void fillInUsername(String username) {
        waitForElementToBeVisible(usernameInput);
        usernameInput.sendKeys(username);
    }

    public void fillInPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public SignUpPage goToSignUpPage() {
        waitForElementToBeVisible(signUpLink);
        signUpLink.click();

        return new SignUpPage(driver);
    }

    public String getErrorMessage() {
        waitForElementToBeVisible(errorMessage);
        return errorMessage.getText();
    }
}
