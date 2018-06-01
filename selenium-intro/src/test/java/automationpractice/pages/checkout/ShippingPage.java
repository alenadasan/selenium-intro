package automationpractice.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

public class ShippingPage extends PageBase {

    @FindBy(id = "uniform-cgv")
    private WebElement acceptTermsCheckbox;
    @FindBy(name = "processCarrier")
    private WebElement proceedToCheckoutButton;

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage agreeAndProceedToCheckout() {
        moveNearElement(acceptTermsCheckbox);
        waitForElementToBeVisible(acceptTermsCheckbox);
        if (!acceptTermsCheckbox.isSelected())
            acceptTermsCheckbox.click();
        moveNearElement(proceedToCheckoutButton);
        proceedToCheckoutButton.click();

        return new PaymentPage(driver);
    }
}
