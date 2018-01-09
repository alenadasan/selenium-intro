package phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import resources.PageBase;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeThat;
import static resources.StringUtils.getStringsFromWebElements;

/**
 * Created by Ale on 09/08/17.
 */
public class HomePage extends PageBase {

    protected Header header;
    @FindBy(id = "citiesInput")
    private WebElement locationInput;
    @FindBy(className = "eac-item")
    private List<WebElement> suggestionsList;
    @FindBy(name = "checkin")
    private WebElement checkInInput;
    @FindBy(name = "checkout")
    private WebElement checkOutInput;
    @FindBy(id = "child")
    private WebElement childrenSelection;
    @FindBy(xpath = "//div[@id='ages' and contains(@style, 'display: block;')]//select[contains(@class, 'room-child-age')]")
    private List<WebElement> childrenAgeSelectorList;
    @FindBy(xpath = "//div[@id='ages' and contains(@style, 'display: block;')]//button[text()='Done']")
    private WebElement childrenModalDoneButton;
    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchButton;
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

    public HotelListPage searchFor(String location, String checkInDate, String checkoutDate, int numberOfChilren,
                                   List<Integer> ages) {
        enterLocation(location);
        fillInField(checkInInput, checkInDate);
        fillInField(checkOutInput, checkoutDate);
        selectChildren(numberOfChilren, ages);

        waitForElementToBeVisible(searchButton);
        searchButton.click();

        return new HotelListPage(driver);
    }

    private void selectChildren(int numberOfChildren, List<Integer> ages) {
        assumeThat("Number of ages entered (" + ages.size() + ") did not match number of children (" + numberOfChildren + ").",
                ages.size(), is(numberOfChildren));

        new Select(childrenSelection).selectByVisibleText(valueOf(numberOfChildren));
        if (numberOfChildren > 0) {
            waitForElementsToBeVisible(childrenAgeSelectorList);
            for (WebElement selector : childrenAgeSelectorList)
                new Select(selector).selectByVisibleText(valueOf(ages.get(childrenAgeSelectorList.indexOf(selector))));
            childrenModalDoneButton.click();
        }
    }

    public void enterLocation(String location) {
        fillInField(locationInput, location);
        List<String> suggestions = getSuggestions();
        if (suggestions.size() > 0)
            suggestionsList.get(0).click();
    }

    public List<String> getSuggestions() {
        if (isElementsListDisplayed(suggestionsList))
            return getStringsFromWebElements(suggestionsList);
        return new ArrayList<String>();
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
