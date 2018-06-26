package phptravels.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import phptravels.pages.AccountPage;
import phptravels.pages.LoginPage;
import phptravels.pages.SignUpPage;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static phptravels.LoginUtils.*;
import static resources.StringUtils.getRandomEmailAddress;

/**
 * Created by Ale on 18/07/17.
 */

public class LoginTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/Users/Ale/workspace/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://www.phptravels.net/login/");
    }

    @Test
    public void canLoginUsingValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = loginPage.loginAs(TEST_EMAIL, TEST_PASSWORD);

        assertThat(accountPage.getGreetingMessage(), containsString("Hi"));
    }

    @Test
    public void cannotLoginWithNoPassword() {
        LoginPage loginPage = new LoginPage(driver);
        LoginPage pageWithErrors = loginPage.loginAndExpectErrors(TEST_EMAIL, "");

        assertThat(pageWithErrors.getErrorMessage(), is("Invalid Email or Password"));
    }

    @Test
    public void cannotLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        LoginPage pageWithErrors = loginPage.loginAndExpectErrors("testuser@mailnesia.com", "a");

        assertThat(pageWithErrors.getErrorMessage(), is("Invalid Email or Password"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void canLoginWithNewAccount() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        String randomEmail = getRandomEmailAddress();
        SignUpPage signUpPage = loginPage.goToSignUpPage();

        AccountPage accountPage = signUpPage.signUpAs("John", "Doe", "9999887766",
                randomEmail, "123456", "123456");
        LoginPage updatedLoginPage = accountPage.getHeader().logOut();
        AccountPage updatedAccountPage = updatedLoginPage.loginAs(randomEmail, "123456");

        assertThat(updatedAccountPage.getGreetingMessage(), is("Hi, John Doe"));
    }

    @Ignore("created just for demo purposes")
    @Test
    public void canLoginUsingValidCredentials_demo() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys(TEST_EMAIL);
        driver.findElement(By.name("password")).sendKeys(TEST_PASSWORD);
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        new WebDriverWait(driver, 10).until(visibilityOfElementLocated(By.className("RTL")));

        assertThat(driver.findElement(By.className("RTL")).getText(), is("Hi, " + TEST_USERNAME));
    }
}
