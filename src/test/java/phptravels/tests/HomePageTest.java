package phptravels.tests;

import org.junit.Ignore;
import org.junit.Test;
import phptravels.pages.BlogDetailsPage;
import phptravels.pages.HomePage;
import resources.TestBase;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static phptravels.LoginUtils.HOME_PAGE_URL;

/**
 * Created by Ale on 23/08/17.
 */

@Ignore("website interface changes constantly and site is often down, tests no longer maintained")
public class HomePageTest extends TestBase {

    @Test
    public void canReadBlogPost() throws Exception {
        driver.get(HOME_PAGE_URL);
        HomePage homePage = new HomePage(driver);

        String blogPostTitle = homePage.getPostTitleForBlogWithIndex(0);
        BlogDetailsPage blogDetailsPage = homePage.clickOnBlogArticleWithIndex(0);

        assertThat(blogDetailsPage.getPostTitle(), containsString(blogPostTitle));
    }
}
