package automationpractice.tests;

import automationpractice.pages.AccountPage;
import automationpractice.pages.AuthenticationPage;
import org.junit.Before;
import org.junit.Test;
import resources.TestBase;

import static automationpractice.LoginUtils.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Ale on 16/01/18.
 */
public class LoginTest extends TestBase {

    private AuthenticationPage authPage;

    @Before
    public void setUp() {
        driver.get("http://automationpractice.com/index.php?controller=authentication");
        authPage = new AuthenticationPage(driver);
    }

    @Test
    public void canLoginWithValidCredentials() {
        AccountPage accountPage = authPage.loginAs(TEST_EMAIL, TEST_PASSWORD);

        assertThat(accountPage.getLoggedInUserName(), is(TEST_USERNAME));
    }

    @Test
    public void cannotLoginWithInvalidPassword() {
        AuthenticationPage authPageWithErrors = authPage.loginAndExpectErrors(TEST_EMAIL, "1234");

        assertThat(authPageWithErrors.getStatusMessage(), is("There is 1 error\nInvalid password."));
    }
}
