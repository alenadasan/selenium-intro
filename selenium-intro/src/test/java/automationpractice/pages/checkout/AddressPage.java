package automationpractice.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

public class AddressPage extends PageBase {

    @FindBy(name = "processAddress")
    private WebElement proceedToCheckoutButton;

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public ShippingPage proceedToCheckout() {
        moveNearElement(proceedToCheckoutButton);
        waitForElementToBeVisible(proceedToCheckoutButton);
        proceedToCheckoutButton.click();

        return new ShippingPage(driver);
    }
}
