package automationpractice.tests;

import automationpractice.pages.HomePage;
import org.junit.Before;
import org.junit.Test;
import resources.TestBase;

import static automationpractice.LoginUtils.HOME_PAGE_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Ale on 18/01/18.
 */
public class CartTest extends TestBase {

    private HomePage homePage;

    @Before
    public void setUp() throws Exception {
        driver.get(HOME_PAGE_URL);
        homePage = new HomePage(driver);
    }

    @Test
    public void canAddProductsToCart() throws Exception {
        HomePage updatedHomePage = homePage.addAllPopularProductsToCart();

        assertThat(updatedHomePage.getCartItems(), is(updatedHomePage.getPopularItemsNames()));
    }
}
