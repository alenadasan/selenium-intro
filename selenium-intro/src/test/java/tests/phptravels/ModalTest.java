package tests.phptravels;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestBase;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static utils.phptravels.LoginUtils.HOME_PAGE_URL;

/**
 * Created by Ale on 25/08/17.
 */
public class ModalTest extends TestBase { //TODO
    @Test
    public void canSeeDiscountContactNumber() throws Exception {
        driver.get(HOME_PAGE_URL + "offers/Lunch-Discount");

        WebElement callButton = driver.findElement(By.linkText("Call Now"));
        WebElement phoneNumberLabel = driver.findElement(By.xpath("//i[contains(@class, 'fa-phone')]/.."));
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(visibilityOf(callButton));
        callButton.click();

        wait.until(visibilityOf(phoneNumberLabel));

        System.out.println(phoneNumberLabel.getText());
    }

    @Test
    public void canInteractWithSaveSearchModal() throws Exception {
        driver.get("https://www.imobiliare.ro/vanzare-apartamente/timisoara");

        WebElement save = driver.findElement(By.className("icon-salveaza"));
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(visibilityOf(save));
        save.click();

        driver.switchTo().activeElement();

        WebElement cancel = driver.findElement(By.linkText("Renunţă"));
        wait.until(visibilityOf(cancel));

        cancel.click();

        System.out.println(driver.findElement(By.id("titlu_anunturi_js")).getText());
    }

    @Test
    public void canAcceptCookies() throws Exception {
        driver.get("https://www.imobiliare.ro/vanzare-apartamente/timisoara");

        WebElement acceptCookiesButton = driver.findElement(By.xpath("//a[@class='close']"));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(visibilityOf(acceptCookiesButton));
        acceptCookiesButton.click();
        wait.until(invisibilityOfElementLocated(By.xpath("//a[@class='close']")));

        assertThat(acceptCookiesButton.isDisplayed(), is(false));
    }
}
