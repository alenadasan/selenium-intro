package pages.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.PageBase;

/**
 * Created by Ale on 02/08/17.
 */
public class MyProfilePage extends PageBase {

    @FindBy(name = "country")
    private WebElement countrySelection;

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public MyProfilePage selectCountry(String country) {
        waitForElementToBeVisible(countrySelection);
        new Select(countrySelection).selectByVisibleText(country);

        return new MyProfilePage(driver);
    }

    public MyProfilePage selectCountry(int index) {
        waitForElementToBeVisible(countrySelection);
        new Select(countrySelection).selectByIndex(index);

        return new MyProfilePage(driver);
    }
}
