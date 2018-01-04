package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Ale on 31/07/17.
 */

public class TestBase {

    protected FirefoxDriver driver;

    @Before
    public void baseSetUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @After
    public void baseTearDown() {
        driver.quit();
    }
}
