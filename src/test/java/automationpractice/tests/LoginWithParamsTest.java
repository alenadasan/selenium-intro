package automationpractice.tests;

import automationpractice.pages.AuthenticationPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import resources.TestBase;

import java.util.Arrays;
import java.util.Collection;

import static automationpractice.LoginUtils.HOME_PAGE_URL;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by Ale on 15/01/18.
 */
@RunWith(value = Parameterized.class)
public class LoginWithParamsTest extends TestBase {

    private String email;
    private String password;

    private AuthenticationPage authPage;

    public LoginWithParamsTest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters(name = "{index}: Logging in with {0} and {1}")
    public static Collection input() {
        return Arrays.asList(new Object[][]{
                {"invalid@mailnesia.com", "cucu"},
                {"ale.nadasan@gmail.com", "1234"},
                {"deletedaccount@mailnesia.com", "1234"}
        });
    }

    @Before
    public void setUp() {
        driver.get(HOME_PAGE_URL + "index.php?controller=authentication&back=my-account");
        authPage = new AuthenticationPage(driver);
    }

    @Test
    public void cannotLoginWithInvalidPassword() throws Exception {
        AuthenticationPage authPageWithErrors = authPage.loginAndExpectErrors(email, password);

        assertThat(authPageWithErrors.getStatusMessage(), containsString("Invalid password"));
    }
}
