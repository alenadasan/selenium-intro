package pages.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import java.util.ArrayList;
import java.util.List;

public class SignUpPage extends PageBase {

    @FindBy(name = "firstname")
    private WebElement firstnameInput;
    @FindBy(name = "lastname")
    private WebElement lastnameInput;
    @FindBy(name = "phone")
    private WebElement phoneInput;
    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(name = "confirmpassword")
    private WebElement confirmPasswordInput;
    @FindBy(xpath = "//button[contains(@class, 'signup')]")
    private WebElement signUpButton;

    @FindBy(xpath = "//div[@class= 'resultsignup']//*[not(child::*)]")
    private List<WebElement> errorMessages;


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage signUpAs(String firstname, String lastname, String phone, String email,
                                String password, String confirmedPassword) {
        fillInFirstName(firstname);
        fillInLastName(lastname);
        fillInPhone(phone);
        fillInEmail(email);
        fillInPassword(password);
        fillInConfirmPassword(confirmedPassword);
        clickSignUp();

        return new AccountPage(driver);
    }

    public SignUpPage signUpWithWrongCredentials(String firstname, String lastname, String phone, String email, String password, String confirmpassword) {
        fillInFirstName(firstname);
        fillInLastName(lastname);
        fillInPhone(phone);
        fillInEmail(email);
        fillInPassword(password);
        fillInConfirmPassword(confirmpassword);
        clickSignUp();

        return new SignUpPage(driver);
    }

    public void fillInFirstName(String firstname) {
        waitForElementToBeVisible(firstnameInput);
        firstnameInput.sendKeys(firstname);
    }

    public void fillInLastName(String lastname) {
        lastnameInput.sendKeys(lastname);
    }

    public void fillInPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void fillInEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void fillInPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void fillInConfirmPassword(String confirmpassword) {
        confirmPasswordInput.sendKeys(confirmpassword);
    }

    public void clickSignUp() {
        signUpButton.click();
    }

    public List<String> getErrorMessages() {
        waitForElementsToBeVisible(errorMessages);
        List<String> errorStrings = new ArrayList<String>();
        for (WebElement message : errorMessages)
            errorStrings.add(message.getText());

        return errorStrings;
    }
}
