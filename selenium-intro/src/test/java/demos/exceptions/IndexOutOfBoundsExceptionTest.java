package demos.exceptions;

import org.junit.Test;
import pages.SignUpPage;
import tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static utils.LoginUtils.HOME_PAGE_URL;

/**
 * Created by Ale on 07/08/17.
 */
public class IndexOutOfBoundsExceptionTest extends TestBase {

    @Test
    public void canAccessThirdArrayElement() throws Exception {
        List<String> errorMessages = Arrays.asList("First error", "Second error");

        System.out.println(errorMessages.get(2));
    }

    @Test
    public void canCheckFifthErrorMessage() throws Exception {
        driver.get(HOME_PAGE_URL + "register");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.fillInFirstName("John");
        signUpPage.clickSignUp();

        assertThat(signUpPage.getErrorMessages().get(4), is("The Last Name field is required."));
    }
}
