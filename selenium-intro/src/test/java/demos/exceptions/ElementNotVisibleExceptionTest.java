package demos.exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import tests.TestBase;

import static utils.phptravels.LoginUtils.HOME_PAGE_URL;

/**
 * Created by Ale on 07/08/17.
 */
public class ElementNotVisibleExceptionTest extends TestBase {

    @Test
    public void test() throws Exception {
        driver.get(HOME_PAGE_URL + "register");
        driver.findElement(By.tagName("div")).click();
    }
}
