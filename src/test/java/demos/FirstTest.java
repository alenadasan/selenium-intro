package demos;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class FirstTest {


    @Test
    public void canAddTwoNumbers() {
        int sum = 2 + 2;

        assertThat(sum, equalTo(4));
    }

    @Test
    public void canNavigateToAWebsite() {
        System.setProperty("webdriver.gecko.driver", "/Users/Ale/workspace/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.ro");

        assertThat(driver.getCurrentUrl(), containsString("google.ro"));

        driver.quit();
    }

    @Test //TODO
    public void canDivTwoNumberTest(){
        BigDecimal div=BigDecimal.valueOf(3/3);
//        String sdiv=Integer.toString(div);
//        System.out.println(sdiv);
//        assertEquals("aaa",sdiv,equalTo(1));
        assertEquals(div,equalTo(1));
        //assertThat("aaa",sdiv, is() );
    }
}
