package automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

public class ProductPage extends PageBase {

    @FindBy(tagName = "h1")
    private WebElement productTitle;
    @FindBy(id = "short_description_content")
    private WebElement productDescription;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        waitForElementToBeVisible(productTitle);
        return productTitle.getText();
    }

    public String getDescription() {
        waitForElementToBeVisible(productDescription);
        return productDescription.getText();
    }
}
