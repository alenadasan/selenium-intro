package automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeThat;

/**
 * Created by Ale on 15/01/18.
 */
public class HomePage extends PageBase{


    @FindBy(partialLinkText = "Contact us")
    private WebElement contactUsButton;
    @FindBy(id = "search_query_top")
    private WebElement searchField;
    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='shopping_cart']/a")
    private WebElement cartButton;
    @FindBy(className = "cart_block_product_name")
    private List<WebElement> cartItems;

    @FindBy(xpath = "//ul[@id='homefeatured']//a[@class='product_img_link']")
    private List<WebElement> popularProducts;
    @FindBy(xpath = "//ul[@id='homefeatured']//span[text()='Add to cart']")
    private List<WebElement> addToCartButtonsForPopularProducts;
    @FindBy(xpath = "//span[@title = 'Continue shopping']")
    private WebElement continueShoppingModalButton;

    @FindBy(xpath = "//section[@id='social_block']//a")
    private List<WebElement> socialLinks;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ContactPage clickContactUs() {
        waitForElementToBeVisible(contactUsButton);
        contactUsButton.click();

        return new ContactPage(driver);
    }

    public ResultsPage searchFor(String query) {
        waitForElementToBeVisible(searchField);
        searchField.clear();
        searchField.sendKeys(query);
        searchButton.click();

        return new ResultsPage(driver);
    }

    public List<String> getCartItems() {
        waitForElementToBeVisible(cartButton);
        new Actions(driver).moveToElement(cartButton).perform();
        waitForElementsToBeVisible(cartItems);

        List<String> itemNames = new ArrayList<String>();
        for (WebElement cartItem : cartItems)
            itemNames.add(cartItem.getAttribute("title"));

        return itemNames;
    }

    public HomePage addAllPopularProductsToCart() {
        waitForElementsToBeVisible(popularProducts);
        assumeThat(popularProducts.size(), equalTo(addToCartButtonsForPopularProducts.size()));

        Actions actions = new Actions(driver);
        for (WebElement product : popularProducts) {
            actions.moveToElement(product).perform();
            waitForElementToBeVisible(addToCartButtonsForPopularProducts.get(popularProducts.indexOf(product)));
            addToCartButtonsForPopularProducts.get(popularProducts.indexOf(product)).click();

            waitForElementToBeVisible(continueShoppingModalButton);
            continueShoppingModalButton.click();
        }

        return new HomePage(driver);
    }

    public List<String> getPopularItemsNames() {
        List<String> itemNames = new ArrayList<String>();

        for (WebElement product : popularProducts)
            itemNames.add(product.getAttribute("title"));

        return itemNames;
    }

    public List<String> getSocialLinks() {
        List<String> links = new ArrayList<String>();

        for (WebElement link : socialLinks)
            links.add(link.getAttribute("href"));

        return links;
    }

    public void clickSocialLinkWithIndex(int i) {
        try {
            socialLinks.get(i).click();
        } catch (IndexOutOfBoundsException e) {
            fail("Social link with index " + i + " not available");
        }
    }
}
