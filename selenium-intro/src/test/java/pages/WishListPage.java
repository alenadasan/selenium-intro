package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

/**
 * Created by Ale on 09/08/17.
 */
public class WishListPage extends PageBase {

    @FindBy(xpath = "//div[contains(@id, 'wish') and not(@style='display: none;')]/div/a/b")
    private List<WebElement> hotelsList;

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getSavedHotels() {
        List<String> hotelNames = new ArrayList<String>();
        if (hotelsList.size() == 0)
            return hotelNames;

        waitForElementsToBeVisible(hotelsList);

        for (WebElement hotel : hotelsList) {
            hotelNames.add(hotel.getText());
        }

        return hotelNames;

    }

    public WishListPage removeHotelFromWishlist(String hotelName) {
        String removeButtonIdentifier = "//b[text()='" + hotelName + "']/../../following-sibling::div/span";
        waitForElementToBeVisible(driver.findElement(By.xpath(removeButtonIdentifier)));
        driver.findElement(By.xpath(removeButtonIdentifier)).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        wait.until(invisibilityOfElementLocated(By.xpath(removeButtonIdentifier)));

        return new WishListPage(driver);
    }
}
