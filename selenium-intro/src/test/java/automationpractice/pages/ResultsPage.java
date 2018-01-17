package automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

/**
 * Created by Ale on 16/01/18.
 */
public class ResultsPage extends PageBase {

    @FindBy(className = "heading-counter")
    private WebElement headingCounterLabel;

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfResults() {
        String numberOfResults = headingCounterLabel.getText().replaceAll("\\D+", "");
        return Integer.valueOf(numberOfResults);
    }
}
