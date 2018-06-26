package demos.exceptions;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static phptravels.LoginUtils.HOME_PAGE_URL;

/**
 * Created by Ale on 07/08/17.
 */
public class NullPointerExceptionTest {

    private WebDriver driver;
    private String str;

    @Test
    public void canNavigateToLoginPage() throws Exception {
        driver.get(HOME_PAGE_URL + "login/");
    }

    @Test
    public void canCallSubstringOnAString() throws Exception {
        System.out.println(str.substring(0, 1));
    }
}
