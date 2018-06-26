package automationpractice.tests;

import automationpractice.pages.HomePage;
import automationpractice.pages.ProductPage;
import automationpractice.pages.ResultsPage;
import org.junit.Before;
import org.junit.Test;
import resources.TestBase;

import static automationpractice.LoginUtils.HOME_PAGE_URL;
import static org.junit.Assert.assertTrue;

public class SearchTest extends TestBase {

    private HomePage homePage;

    @Before
    public void setUp() {
        driver.get(HOME_PAGE_URL);
        homePage = new HomePage(driver);
    }

    @Test
    public void canSearchForExistingItems() {
        ResultsPage resultsPage = homePage.searchFor("dress");
        ProductPage productPage = resultsPage.clickOnResultWithIndex(0);

        assertTrue(productPage.getTitle().contains("dress") || productPage.getDescription().contains("dress"));
    }


}
