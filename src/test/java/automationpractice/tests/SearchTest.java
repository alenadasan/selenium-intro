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
        ResultsPage resultsPage = homePage.getHeader().searchFor("dress");
        ProductPage productPage = resultsPage.clickOnResultWithIndex(0);

        assertTrue(productPage.getTitle().contains("dress") || productPage.getDescription().contains("dress"));
    }

    @Test
    public void allResultsContainSearchQuery() {
        ResultsPage resultsPage = homePage.getHeader().searchFor("printed summer");

        for (int i = 0; i < resultsPage.getNumberOfResults(); i++) {
            ProductPage productPage = resultsPage.clickOnResultWithIndex(i);

            assertTrue(productPage.getTitle().toLowerCase().contains("printed") ||
                    productPage.getDescription().toLowerCase().contains("printed"));

            driver.navigate().back();
        }
    }

}
