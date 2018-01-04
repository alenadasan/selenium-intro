package demos.exceptions;

import org.junit.Test;
import pages.LoginPage;
import tests.TestBase;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Ale on 07/08/17.
 */
public class TimeoutExceptionTest extends TestBase {

    @Test
    public void canCheckErrorMessage() throws Exception {
        driver.get("http://www.phptravels.net/login/");
        LoginPage loginPage = new LoginPage(driver);

        assertThat(loginPage.getErrorMessage(), is("Doesn't matter, error message not displayed"));

    }
}
