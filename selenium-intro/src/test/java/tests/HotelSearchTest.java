package tests;

import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.HotelListPage;

import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static utils.LoginUtils.HOME_PAGE_URL;

/**
 * Created by Ale on 04/01/18.
 */
public class HotelSearchTest extends TestBase {

    private HomePage homePage;

    @Before
    public void setUp() {
        driver.get(HOME_PAGE_URL);
        homePage = new HomePage(driver);
    }

    @Test
    public void canSearchForAHotel() throws Exception {
        HotelListPage listPage = homePage.searchFor("Paris", "05/20/2018", "05/25/2018", 0);

        assertThat(listPage.getResultsLocation(), everyItem(is("Paris")));
    }
}
