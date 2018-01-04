package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.fail;

/**
 * Created by Ale on 09/08/17.
 */
public class HomePage extends PageBase {

    protected Header header;
    @FindBy(xpath = "//h2[text()=' Featured Tours        ']/../following-sibling::div//a")
    private List<WebElement> featuredToursList;
    @FindBy(xpath = "//h2[contains(text(), 'Blog News')]/../following-sibling::div//h4")
    private List<WebElement> blogArticles;
    @FindBy(xpath = "//a[contains(text(), 'Read More')]")
    private List<WebElement> readMoreButtons;


    public HomePage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
    }

    public TourDetailsPage clickOnTourWithIndex(int index) {
        try {
            featuredToursList.get(index).click();
        } catch (IndexOutOfBoundsException e) {
            fail("Could not find featured hotel with index " + index);
        }
        return new TourDetailsPage(driver);
    }

    public BlogDetailsPage clickOnBlogArticleWithIndex(int index) {
        try {
            moveNearElement(blogArticles.get(index));
            waitForElementsToBeVisible(blogArticles);
            waitForElementToBeVisible(readMoreButtons.get(index));
            readMoreButtons.get(index).click();

        } catch (IndexOutOfBoundsException e) {
            fail("Could not find blog article with index " + index);
        }
        return new BlogDetailsPage(driver);
    }

    public String getPostTitleForBlogWithIndex(int index) {
        try {
            moveNearElement(blogArticles.get(index));
            waitForElementsToBeVisible(blogArticles);
            return blogArticles.get(index).getText();
        } catch (IndexOutOfBoundsException e) {
            fail("Could not find blog article with index " + index);
        }
        return "";
    }

    public void moveNearElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public Header getHeader() {
        return header;
    }
}
