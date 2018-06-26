package automationpractice.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

public class PaymentPage extends PageBase {

    @FindBy(className = "bankwire")
    private WebElement bankwirePaymentButton;
    @FindBy(className = "cheque")
    private WebElement checkPaymentButton;
    @FindBy(xpath = "//span[contains(text(), 'I confirm my order')]")
    private WebElement confirmOrderButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage payByBankwire() {
        waitForElementToBeVisible(bankwirePaymentButton);
        bankwirePaymentButton.click();

        return new PaymentPage(driver);
    }

    public PaymentPage payByCheck() {
        waitForElementToBeVisible(checkPaymentButton);
        checkPaymentButton.click();

        return new PaymentPage(driver);
    }

    public OrderConfirmationPage confirmOrder() {
        waitForElementToBeVisible(confirmOrderButton);
        confirmOrderButton.click();

        return new OrderConfirmationPage(driver);
    }
}
