package demos;

import automationpractice.pages.AuthenticationPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import resources.TestBase;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static phptravels.LoginUtils.TEST_USERNAME;

/**
 * Created by Ale on 15/01/18.
 */
@RunWith(Parameterized.class)
public class ParamTest extends TestBase {
    private String email;
    private String password;

    private AuthenticationPage loginPage;

    public ParamTest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][] {{"a@mmm.com", "cucu"}, {"a@mmmmm.com", "cucu"}});
    }

    @Before
    public void setUp() {
//        ParamTest paramTest = new ParamTest();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

    }

    @Test
    public void cannotLoginWithInvalidPassword() throws Exception {
        loginPage.loginAs(TEST_USERNAME, "");

        AuthenticationPage pageWithErrors = new AuthenticationPage(driver);

        assertThat(pageWithErrors.getStatusMesage(), containsString("Invalid email address"));
    }

}
