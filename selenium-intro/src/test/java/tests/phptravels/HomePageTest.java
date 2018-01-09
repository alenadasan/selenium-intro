package tests.phptravels;

import org.junit.Test;
import pages.phptravels.BlogDetailsPage;
import pages.phptravels.HomePage;
import tests.TestBase;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static utils.phptravels.LoginUtils.HOME_PAGE_URL;

/**
 * Created by Ale on 23/08/17.
 */
public class HomePageTest extends TestBase {

    @Test
    public void canReadBlogPost() throws Exception {
        driver.get(HOME_PAGE_URL);
        HomePage homePage = new HomePage(driver);

        String blogPostTitle = homePage.getPostTitleForBlogWithIndex(1);
        BlogDetailsPage blogDetailsPage = homePage.clickOnBlogArticleWithIndex(1);

        assertThat(blogDetailsPage.getPostTitle(), is(blogPostTitle));
    }
}
