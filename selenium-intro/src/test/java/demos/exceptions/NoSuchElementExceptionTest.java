package demos.exceptions;

import org.junit.Test;
import pages.LoginPage;
import tests.TestBase;

/**
 * Created by Ale on 07/08/17.
 */
public class NoSuchElementExceptionTest extends TestBase {

    @Test
    public void canFillInPasswordField() throws Exception {
        driver.get("http://www.phptravels.net/register/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();
    }
}
