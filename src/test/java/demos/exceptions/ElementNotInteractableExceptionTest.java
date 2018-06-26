package demos.exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import resources.TestBase;

import static phptravels.LoginUtils.HOME_PAGE_URL;

/**
 * Created by Ale on 07/08/17.
 */
public class ElementNotInteractableExceptionTest extends TestBase {

    @Test
    public void cannotInteractWithAnElementThatsNotVisible() throws Exception {
        driver.get(HOME_PAGE_URL + "register");
        driver.findElement(By.linkText("EUR")).click();
    }
}
