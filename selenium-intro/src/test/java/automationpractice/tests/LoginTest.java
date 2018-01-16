package automationpractice.tests;

import automationpractice.pages.AccountPage;
import automationpractice.pages.AuthenticationPage;
import org.junit.Before;
import org.junit.Test;
import resources.TestBase;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Ale on 16/01/18.
 */
public class LoginTest extends TestBase {

    AuthenticationPage authPage;

    @Before
    public void setUp() throws Exception {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        authPage = new AuthenticationPage(driver);
    }

    @Test
    public void canLoginWithValidCredentials() throws Exception {
        AccountPage accountPage = authPage.loginAs("ale.nadasan@gmail.com", "12345");

        assertThat(accountPage.getLoggedInUserName(), is("Ale Nadasan"));
    }
}
