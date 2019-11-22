package demos.refactoring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class GmailLoginTest {

    WebDriver driver;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/Users/Ale/workspace/geckodriver");
        driver = new FirefoxDriver();
        String appUrl = "https://accounts.google.com";

        driver.get(appUrl);

        driver.manage().window().maximize();
    }

    @Test
    public void canLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("selenium9090@gmail.com", "sele9090");

        assertThat(driver.getCurrentUrl(), containsString("google"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}

