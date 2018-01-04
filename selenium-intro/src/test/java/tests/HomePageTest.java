package tests;

import org.junit.Test;
import pages.BlogDetailsPage;
import pages.HomePage;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static utils.LoginUtils.HOME_PAGE_URL;

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
