package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assume.assumeThat;

/**
 * Created by Ale on 04/01/18.
 */
public class TourDetailsPage extends PageBase {

    @FindBy(xpath = "//div[contains(@class, 'mob-trip-info-head')]//strong/span")
    private WebElement tourTitle;
    @FindBy(className = "wishtext")
    private WebElement addToWishlistButton;

    private Header header;

    public TourDetailsPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
    }

    public String getTourTitle() {
        waitForElementToBeVisible(tourTitle);
        return tourTitle.getText();
    }

    public TourDetailsPage addToWishList() {
        waitForElementToBeVisible(addToWishlistButton);
        assumeThat("Tour is already added to wishlist",
                addToWishlistButton.getText(), containsString("Add to wishlist"));
        addToWishlistButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        return new TourDetailsPage(driver);
    }

    public Header getHeader() {
        return header;
    }
}
