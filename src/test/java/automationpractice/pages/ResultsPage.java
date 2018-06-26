package automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

import java.util.List;

import static org.junit.Assert.fail;

/**
 * Created by Ale on 16/01/18.
 */
public class ResultsPage extends PageBase {

    @FindBy(className = "heading-counter")
    private WebElement headingCounterLabel;
    @FindBy(xpath = "//*[@itemprop='name']/a")
    private List<WebElement> resultsLinks;

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfResults() {
        String numberOfResults = headingCounterLabel.getText().replaceAll("\\D+", "");
        return Integer.valueOf(numberOfResults);
    }

    public ProductPage clickOnResultWithIndex(int i) {
        try {
            resultsLinks.get(i).click();
        } catch (IndexOutOfBoundsException e) {
            fail("Product with index " + i + " not available");
        }
        return new ProductPage(driver);
    }
}
