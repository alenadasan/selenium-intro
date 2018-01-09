package pages.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * Created by Ale on 11/09/17.
 */
public class HotelListPage extends PageBase {

    @FindBy(xpath = "//i[contains(@class, 'icon-location-6')]/..")
    private List<WebElement> resultsLocationList;
    @FindBy(xpath = "//div[@class='rating']//ins")
    private List<WebElement> hotelRatingSelectionItems;

    public HotelListPage(WebDriver driver) {
        super(driver);
        waitForURLToContain("properties");
    }

    public HotelListPage selectRating(int rating) {
        switch (rating) {
            case 1:
                hotelRatingSelectionItems.get(0).click();
                break;
            case 2:
                hotelRatingSelectionItems.get(1).click();
                break;
            case 3:
                hotelRatingSelectionItems.get(2).click();
                break;
            case 4:
                hotelRatingSelectionItems.get(3).click();
                break;
            case 5:
                hotelRatingSelectionItems.get(4).click();
                break;
            default:
                fail("Rating " + rating + " not available");
        }

        return new HotelListPage(driver);
    }

    public List<String> getResultsLocation() {
        List<String> locations = new ArrayList<String>();
        if (isElementsListDisplayed(resultsLocationList))
            for (WebElement location : resultsLocationList)
                locations.add(location.getAttribute("title"));

        return locations;
    }
}
