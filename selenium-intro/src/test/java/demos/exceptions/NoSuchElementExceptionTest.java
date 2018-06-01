package demos.exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import resources.TestBase;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static phptravels.LoginUtils.HOME_PAGE_URL;

/**
 * Created by Ale on 07/08/17.
 */
public class NoSuchElementExceptionTest extends TestBase {

    @Test(expected = org.openqa.selenium.NoSuchElementException.class)
    public void canFillInPasswordField() throws Exception {
        driver.get(HOME_PAGE_URL);

        assertThat(driver.findElement(By.id("fakeID")).isDisplayed(), is(true));
    }
}
