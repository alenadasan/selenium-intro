package phptravels.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import phptravels.pages.AccountPage;
import phptravels.pages.SignUpPage;
import resources.TestBase;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static phptravels.LoginUtils.*;
import static resources.StringUtils.getRandomEmailAddress;

/**
 * Created by Ale on 7/28/2017.
 */

@Ignore("website interface changes constantly and site is often down, tests no longer maintained")
public class SignUpTest extends TestBase {
    SignUpPage signUpPage;

    @Before
    public void setUp() {
        driver.get(HOME_PAGE_URL + "register");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void canSignUpWithValidCredentials() {
        String emailAddress = getRandomEmailAddress();
        AccountPage accountPage = signUpPage.signUpAs
                ("Chi", "Lee", "0799791974", emailAddress, "123456", "123456");

        assertThat(accountPage.getGreetingMessage(), containsString("Hi, Chi Lee"));
    }

    @Test
    public void cannotSignUpWithoutCredentials() {
        SignUpPage signUpWithoutCredentials = signUpPage.signUpWithWrongCredentials
                ("", "", "", "", "", "");

        assertThat(signUpWithoutCredentials.getErrorMessages(),
                both(hasItem("The Email field is required."))
                        .and(hasItem("The Password field is required."))
                        .and(hasItem("The Password field is required."))
                        .and(hasItem("The First name field is required."))
                        .and(hasItem("The Last Name field is required.")));
    }

    @Test
    public void cannotSignUpWithAnExistingEmail() {
        SignUpPage signUpWithAnExistingEmail = signUpPage.signUpWithWrongCredentials
                ("Chi", "Lee", "0754791974", TEST_EMAIL, TEST_PASSWORD, "demouser");

        assertThat(signUpWithAnExistingEmail.getErrorMessages(), contains("Email Already Exists."));
    }

    @Test
    public void cannotSignUpWithShortPassword() {
        SignUpPage signUpWithShortPassword = signUpPage.signUpWithWrongCredentials
                ("Chi", "Lee", "0754791974", "testuser@gmail.com", "1234", "1234");

        assertThat(signUpWithShortPassword.getErrorMessages(), contains("The Password field must be at least 6 characters in length."));
    }
}

