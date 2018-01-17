package phptravels.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import phptravels.pages.*;
import resources.TestBase;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;
import static phptravels.LoginUtils.*;

/**
 * Created by Ale on 09/08/17.
 */
public class WishListTest extends TestBase {

    AccountPage accountPage;

    @Before
    public void setUp() {
        driver.get(HOME_PAGE_URL + "login");
        LoginPage loginPage = new LoginPage(driver);
        accountPage = loginPage.loginAs(TEST_EMAIL, TEST_PASSWORD);
    }

    @Test
    public void canAddTourToWishList() {
        HomePage homePage = accountPage.getHeader().goToHomePage();

        TourDetailsPage tourDetailsPage = homePage.clickOnTourWithIndex(3);
        String tourName = tourDetailsPage.getTourTitle();
        TourDetailsPage updatedTourPage = tourDetailsPage.addToWishList();
        AccountPage updatedAccountPage = updatedTourPage.getHeader().goToMyAccount();
        WishListPage wishListPage = updatedAccountPage.goToWishlist();

        assertThat(wishListPage.getSavedHotels(), hasItem(equalToIgnoringCase(tourName)));
    }

    @Test
    public void canRemoveHotelFromWishList() throws Exception {
        WishListPage wishListPage = accountPage.goToWishlist();
        List<String> savedHotels = wishListPage.getSavedHotels();
        assumeThat(savedHotels.size(), greaterThan(0));
        String firstHotel = savedHotels.get(0);

        WishListPage updatedPage = wishListPage.removeHotelFromWishlist(firstHotel);

        assertThat(updatedPage.getSavedHotels(), not(hasItem(firstHotel)));
    }

    @Ignore("//TODO")
    @Test
    public void canAddCarToWishlist() {
        driver.get(HOME_PAGE_URL + "cars");
        CarsPage carsPage = new CarsPage(driver);
        carsPage.clickWishlistButton();

        String carTitle = carsPage.getCarTitle();

        driver.get( HOME_PAGE_URL + "account/#wishlist");
        WishListPage wishListPage = new WishListPage(driver);

        assertThat(wishListPage.getSavedHotels(), hasItem(carTitle));




    }
}
