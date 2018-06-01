package phptravels.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import phptravels.pages.HomePage;
import phptravels.pages.HotelListPage;
import resources.TestBase;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static phptravels.LoginUtils.HOME_PAGE_URL;

/**
 * Created by Ale on 04/01/18.
 */
@Ignore("interface changes too often to maintain tests")
public class HotelSearchTest extends TestBase {

    private HomePage homePage;

    @Before
    public void setUp() {
        driver.get(HOME_PAGE_URL);
        homePage = new HomePage(driver);
    }

    @Test
    public void canSearchByLocation_noChildren() throws Exception {
        HotelListPage listPage = homePage.searchFor("Paris", "05/20/2018", "05/25/2018",
                0, new ArrayList<Integer>());

        assertThat(listPage.getResultsLocation(), everyItem(is("Paris")));
    }

    @Test
    public void canSearchByLocation_oneChild() throws Exception {
        HotelListPage listPage = homePage.searchFor("Dubai", "05/20/2018", "05/25/2018",
                1, asList(4));

        assertThat(listPage.getResultsLocation(), everyItem(is("Dubai")));
    }

    @Test
    public void canSearchByLocation_multipleChildren() throws Exception {
        HotelListPage listPage = homePage.searchFor("Hurghada", "05/20/2018", "05/25/2018",
                3, asList(1, 2, 3));

        assertThat(listPage.getResultsLocation(), everyItem(is("Hurghada")));
    }

    @Test
    public void canSearchByHotelName_multipleChildren() throws Exception {
        HotelListPage listPage = homePage.searchFor("Jumeirah", "05/20/2018", "05/25/2018",
                3, asList(1, 2, 3));

        assertThat(listPage.getResultsLocation(), everyItem(containsString("Jumeirah")));
    }

    @Test
    public void suggestionsDropdownWorks() throws Exception {
        homePage.enterLocation("Jumeirah");

        assertThat(homePage.getSuggestions(), hasItem("Jumeirah Beach Hotel"));
    }
}
