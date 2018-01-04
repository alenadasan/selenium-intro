package tests;

import org.junit.Test;
import pages.BlogDetailsPage;
import pages.HomePage;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Ale on 23/08/17.
 */
public class HomePageTest extends TestBase {

    @Test
    public void canReadBlogPost() throws Exception {
        driver.get("http://www.phptravels.net/");
        HomePage homePage = new HomePage(driver);

        String blogPostTitle = homePage.getPostTitleForBlogWithIndex(1);
        BlogDetailsPage blogDetailsPage = homePage.clickOnBlogArticleWithIndex(1);

        assertThat(blogDetailsPage.getPostTitle(), is(blogPostTitle));
    }
}
