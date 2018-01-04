package demos.exceptions;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Ale on 07/08/17.
 */
public class NullPointerExceptionTest {

    private WebDriver driver = new FirefoxDriver();
    private String str;

    @Test
    public void canNavigateToLoginPage() throws Exception {
        driver.get("http://www.phptravels.net/login/");
    }

    @Test
    public void canCallSubstringOnAString() throws Exception {
        System.out.println(str.substring(0, 1));
    }
}
