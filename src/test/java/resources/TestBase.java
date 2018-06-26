package resources;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Ale on 31/07/17.
 */

public class TestBase {

    protected WebDriver driver;

    @Before
    public void baseSetUp() {
        System.setProperty("webdriver.gecko.driver", "/Users/Ale/workspace/geckodriver"); // Replace path with your own

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @After
    public void baseTearDown() {
        driver.quit();
    }
}
