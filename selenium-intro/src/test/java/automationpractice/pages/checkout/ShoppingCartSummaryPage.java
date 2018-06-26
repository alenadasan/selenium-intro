package automationpractice.pages.checkout;

import automationpractice.pages.AuthenticationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

public class ShoppingCartSummaryPage extends PageBase {

    @FindBy(xpath = "//a[@title='Proceed to checkout' and contains(@href, 'step=1')]")
    private WebElement proceedToCheckoutButton;

    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
    }

    public AuthenticationPage proceedToCheckout() {
        moveNearElement(proceedToCheckoutButton);
        waitForElementToBeVisible(proceedToCheckoutButton);
        proceedToCheckoutButton.click();

        return new AuthenticationPage(driver);
    }
}
