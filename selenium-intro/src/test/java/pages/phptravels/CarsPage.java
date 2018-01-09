package pages.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import java.util.List;

/**
 * Created by Ale on 08/01/18.
 */
public class CarsPage extends PageBase {

    @FindBy(xpath = "//h4[contains(@class, 'list_title')]//b")
    private List<WebElement> carTitles;
    @FindBy(id = "11")
    private WebElement addToWishlistButton;

    public CarsPage(WebDriver driver) {
        super(driver);
    }

    public void clickWishlistButton() {
        addToWishlistButton.click();
    }

    public String getCarTitle() {
        return carTitles.get(0).getText();
    }


}
