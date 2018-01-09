package demos.exceptions;

import org.junit.Test;
import phptravels.pages.LoginPage;
import resources.TestBase;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static phptravels.LoginUtils.HOME_PAGE_URL;

/**
 * Created by Ale on 07/08/17.
 */
public class TimeoutExceptionTest extends TestBase {

    @Test
    public void canCheckErrorMessage() throws Exception {
        driver.get(HOME_PAGE_URL + "login/");
        LoginPage loginPage = new LoginPage(driver);

        assertThat(loginPage.getErrorMessage(), is("Doesn't matter, error message not displayed"));

    }
}
