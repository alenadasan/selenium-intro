package automationpractice.tests;

import automationpractice.pages.AuthenticationPage;
import automationpractice.pages.HomePage;
import automationpractice.pages.checkout.*;
import org.junit.Before;
import org.junit.Test;
import resources.TestBase;

import static automationpractice.LoginUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CheckoutTest extends TestBase {

    private HomePage homePage;

    @Before
    public void setUp() {
        driver.get(HOME_PAGE_URL);
        homePage = new HomePage(driver);
    }

    @Test
    public void canCheckoutAProduct() {
        ShoppingCartSummaryPage cartPage = homePage.addToCartAndCheckoutProductWithIndex(0);

        AuthenticationPage loginPage = cartPage.proceedToCheckout();
        AddressPage addressPage = loginPage.loginAndContinueCheckout(TEST_EMAIL, TEST_PASSWORD);
        ShippingPage shippingPage = addressPage.proceedToCheckout();
        PaymentPage paymentPage = shippingPage.agreeAndProceedToCheckout();
        OrderConfirmationPage orderConfirmationPage = paymentPage.payByBankwire().confirmOrder();

        assertThat(orderConfirmationPage.getConfirmationMessage(), is("Your order on My Store is complete."));
    }
}
