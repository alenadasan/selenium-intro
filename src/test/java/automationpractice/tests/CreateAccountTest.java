package automationpractice.tests;

import automationpractice.pages.AuthenticationPage;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import resources.TestBase;

import static org.junit.Assert.assertThat;

public class CreateAccountTest extends TestBase {

    private AuthenticationPage authPage;

    @Before
    public void setUp() {
        driver.get("http://automationpractice.com/index.php?controller=authentication");
        authPage = new AuthenticationPage(driver);
    }

    @Test
    public void cannotCreateNewAccountWithoutEnteringEmailAddress() {
        authPage.clickCreateAccount();

        assertThat(authPage.getError(), Matchers.is("Invalid email address."));
    }
}
