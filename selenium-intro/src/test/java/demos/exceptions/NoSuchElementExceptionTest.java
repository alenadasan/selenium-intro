package demos.exceptions;

import org.junit.Test;
import pages.phptravels.LoginPage;
import tests.TestBase;

import static utils.phptravels.LoginUtils.HOME_PAGE_URL;

/**
 * Created by Ale on 07/08/17.
 */
public class NoSuchElementExceptionTest extends TestBase {

    @Test
    public void canFillInPasswordField() throws Exception {
        driver.get(HOME_PAGE_URL + "register/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();
    }
}
