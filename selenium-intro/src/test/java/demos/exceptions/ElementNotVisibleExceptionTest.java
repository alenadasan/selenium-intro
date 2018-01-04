package demos.exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import tests.TestBase;

/**
 * Created by Ale on 07/08/17.
 */
public class ElementNotVisibleExceptionTest extends TestBase {

    @Test
    public void name() throws Exception {
        driver.get("http://www.phptravels.net/register");
        driver.findElement(By.tagName("div")).click();
    }
}
