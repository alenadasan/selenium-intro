package automationpractice.tests;

import automationpractice.pages.HomePage;
import automationpractice.pages.ResultsPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import resources.TestBase;

import java.util.Arrays;
import java.util.Collection;

import static automationpractice.LoginUtils.HOME_PAGE_URL;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

/**
 * Created by Ale on 16/01/18.
 */
@RunWith(value = Parameterized.class)
public class SearchTest extends TestBase {

    private String query;
    private HomePage homePage;

    public SearchTest(String query) {
        this.query = query;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(
                "dress",
                "top",
                "shirt");
    }

    @Before
    public void setUp() throws Exception {
        driver.get(HOME_PAGE_URL);
        homePage = new HomePage(driver);
    }

    @Test
    public void canSearchForExistingItems() throws Exception {
        ResultsPage resultsPage = homePage.searchFor(query);

        assertThat(resultsPage.getNumberOfResults(), greaterThan(0));
    }
}
