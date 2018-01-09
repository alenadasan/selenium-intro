package phptravels.tests;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by Ale on 12/07/17.
 */
public class GoogleTest {

    @Test
    public void canAccessGoogle() {
        FirefoxDriver driver = new FirefoxDriver();

        driver.get("http://www.google.com");

        assertThat(driver.getCurrentUrl(), containsString("google"));

        driver.quit();
    }
}
