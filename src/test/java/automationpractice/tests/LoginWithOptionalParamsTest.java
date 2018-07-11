package automationpractice.tests;

import automationpractice.pages.AccountPage;
import automationpractice.pages.AuthenticationPage;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import resources.TestBase;

import static automationpractice.LoginUtils.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class LoginWithOptionalParamsTest extends TestBase {

    private AuthenticationPage authPage;

    @Before
    public void setUp() {
        driver.get("http://automationpractice.com/index.php?controller=authentication");
        authPage = new AuthenticationPage(driver);
    }

    @Test
    public void canLoginWithValidCredentials() {
        AccountPage accountPage = authPage.loginAs(TEST_EMAIL, TEST_PASSWORD);

        assertThat(accountPage.getHeader().getLoggedInUserName(), is(TEST_USERNAME));
    }

    @Test
    @Parameters({"invalid@mailnesia.com, cucu, There is 1 error\nInvalid password.",
            "ale.nadasan@gmail.com, 1234, There is 1 error\nInvalid password.",
            "noaccount@mailnesia.com, , There is 1 error\nPassword is required.",
            " , , There is 1 error\nAn email address required."})
    public void cannotLoginWithInvalidData(String email, String password, String expectedError) {
        AuthenticationPage authPageWithErrors = authPage.loginAndExpectErrors(email, password);

        assertThat(authPageWithErrors.getStatusMessage(), is(expectedError));
    }
}
