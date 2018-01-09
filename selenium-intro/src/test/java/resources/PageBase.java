package resources;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

/**
 * Created by Ale on 18/07/17.
 */

public class PageBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(visibilityOf(element));
    }

    public void waitForElementsToBeVisible(List<WebElement> elements) {
        wait.until(visibilityOfAllElements(elements));
    }

    public void waitForURLToContain(String partialURL) {
        wait.until(ExpectedConditions.urlContains(partialURL));
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            waitForElementToBeVisible(element);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isElementsListDisplayed(List<WebElement> elements) {
        try {
            waitForElementsToBeVisible(elements);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void fillInField(WebElement field, String value) {
        waitForElementToBeVisible(field);
        field.clear();
        field.sendKeys(value);
    }
}
