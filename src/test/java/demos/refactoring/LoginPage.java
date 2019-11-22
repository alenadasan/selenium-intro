package demos.refactoring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assume.assumeThat;

public class LoginPage extends PageBase {

    @FindBy(id = "identifierId")
    private WebElement emailField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//content[@class='CwaK9']")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        assumeThat(driver.getCurrentUrl(), containsString("https://accounts.google.com/signin/"));
    }

    public void loginAs(String email, String password) {
        waitForElementToBeVisible(emailField);
        emailField.clear();
        emailField.sendKeys(email);

        signInButton.click();

        waitForElementToBeVisible(passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);

        signInButton.click();

    }
}
