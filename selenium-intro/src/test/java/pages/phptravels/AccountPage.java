package pages.phptravels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

/**
 * Created by Ale on 18/07/17.
 */


public class AccountPage extends PageBase {

    @FindBy(className = "RTL")
    private WebElement pageTitle;
    @FindBy(partialLinkText = "Wishlist")
    private WebElement wishlistLink;

    private Header header;

    public AccountPage(WebDriver driver) {
        super(driver);
        waitForURLToContain("account/");
        header = new Header(driver);
    }

    public String getGreetingMessage() {
        waitForElementToBeVisible(pageTitle);
        return pageTitle.getText();
    }

    public WishListPage goToWishlist() {

        waitForElementToBeVisible(wishlistLink);
        wishlistLink.click();

        return new WishListPage(driver);

    }

    public Header getHeader() {
        return header;
    }
}
