package automationpractice.pages;

import automationpractice.builders.ContactMessage;
import automationpractice.enums.SubjectHeading;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import resources.PageBase;

/**
 * Created by Ale on 09/01/18.
 */
public class ContactPage extends PageBase {

    @FindBy(id = "id_contact")
    private WebElement subjectDropdown;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "id_order")
    private WebElement orderReferenceInput;
    @FindBy(id = "message")
    private WebElement messageField;
    @FindBy(id = "submitMessage")
    private WebElement sendButton;

    @FindBy(xpath = "//*[contains(@class, 'alert')]")
    private WebElement statusMessage;

    public ContactPage(WebDriver driver) {
        super(driver);
        waitForURLToContain("contact");
    }

    public ContactPage sendMessage(String subject, String email, String orderReference, String message) {
        selectSubject(subject);
        fillInEmailAddress(email);
        fillInOrderReference(orderReference);
        fillInMessage(message);

        return clickSendMessage();
    }

    public ContactPage sendMessage(SubjectHeading subject, String email, String orderReference, String message) {
        selectSubject(subject.getLabel());
        fillInEmailAddress(email);
        fillInOrderReference(orderReference);
        fillInMessage(message);

        return clickSendMessage();
    }

    public ContactPage sendMessage(ContactMessage contactMessage) {
        if (contactMessage.getSubject() != null)
            selectSubject(contactMessage.getSubject().getLabel());
        fillInEmailAddress(contactMessage.getEmail());
        fillInOrderReference(contactMessage.getOrderReference());
        fillInMessage(contactMessage.getMessage());

        return clickSendMessage();
    }

    private void selectSubject(String subject) {
        new Select(subjectDropdown).selectByVisibleText(subject);
    }

    private void fillInEmailAddress(String email) {
        emailInput.sendKeys(email);
    }

    private void fillInOrderReference(String orderReference) {
        orderReferenceInput.sendKeys(orderReference);
    }

    private void fillInMessage(String message) {
        messageField.sendKeys(message);
    }

    private ContactPage clickSendMessage() {
        sendButton.click();

        return new ContactPage(driver);
    }

    public String getStatusMesage() {
        waitForElementToBeVisible(statusMessage);
        return statusMessage.getText();
    }
}
