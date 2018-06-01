package automationpractice.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

public class OrderConfirmationPage extends PageBase {

    @FindBy(xpath = "//*[contains(text(), 'Your order on My Store is complete.')]")
    private WebElement confirmationMessage;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationMessage() {
        waitForElementToBeVisible(confirmationMessage);
        return confirmationMessage.getText();
    }
}
