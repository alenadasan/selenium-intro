package tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountPage;
import pages.LoginPage;
import pages.SignUpPage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static utils.LoginUtils.*;
import static utils.StringUtils.getRandomEmailAddress;

/**
 * Created by Ale on 18/07/17.
 */

public class LoginTest extends TestBase {

    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver.get(HOME_PAGE_URL + "login/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void canLoginUsingValidCredentials() throws Exception {
        AccountPage accountPage = loginPage.loginAs(TEST_USERNAME, TEST_PASSWORD);

        assertThat(accountPage.getGreetingMessage(), is("Hi, " + TEST_NAME));
    }

    @Test
    public void cannotLoginWithInvalidPassword() throws Exception {
        LoginPage pageWithErrors = loginPage.loginAndExpectErrors(TEST_USERNAME, "");

        assertThat(pageWithErrors.getErrorMessage(), is("Invalid Email or Password"));
    }

    @Test
    public void canLoginWithNewAccount() throws Exception {
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
        driver.findElement(By.name("username")).sendKeys(TEST_USERNAME);
        driver.findElement(By.name("password")).sendKeys(TEST_PASSWORD);
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        new WebDriverWait(driver, 10).until(visibilityOfElementLocated(By.className("RTL")));

        assertThat(driver.findElement(By.className("RTL")).getText(), is("Hi, " + TEST_NAME));
    }
}
