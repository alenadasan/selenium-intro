package demos;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class FirstTest {

    @Test
    public void canNavigateToAWebsite() {
        System.setProperty("webdriver.gecko.driver", "/Users/Ale/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.ro");

        assertThat(driver.getCurrentUrl(), containsString("google.ro"));

        driver.quit();
    }
}
