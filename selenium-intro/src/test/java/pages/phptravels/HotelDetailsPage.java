package pages.phptravels;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import static org.hamcrest.core.Is.is;
import static org.junit.Assume.assumeThat;

/**
 * Created by Ale on 09/08/17.
 */
public class HotelDetailsPage extends PageBase {

    @FindBy(xpath = "//span[contains(text(), 'Avg/Night')]/preceding-sibling::strong")
    private WebElement hotelName;
    @FindBy(xpath = "//span[contains(@class, 'addwishlist')]")
    private WebElement addToFavouriteButton;

    private Header header;

    public HotelDetailsPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
    }

    public HotelDetailsPage addToFavourite() {
        waitForElementToBeVisible(addToFavouriteButton);
        assumeThat(addToFavouriteButton.getText(), is("Add to wishlist"));
        addToFavouriteButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        return new HotelDetailsPage(driver);
    }

    public String getHotelName() {
        waitForElementToBeVisible(hotelName);
        return hotelName.getText();
    }

    public Header getHeader() {
        return header;
    }

}
