package automationpractice.tests;

import automationpractice.pages.HomePage;
import org.junit.Before;
import org.junit.Test;
import resources.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static automationpractice.LoginUtils.HOME_PAGE_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Ale on 18/01/18.
 */
public class HomePageTest extends TestBase {

    HomePage homePage;

    @Before
    public void setUp() {
        driver.get(HOME_PAGE_URL);
        homePage = new HomePage(driver);
    }

    @Test
    public void facebookLinkWorks() {
        homePage.clickFacebookLink();
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));

        assertThat(driver.getCurrentUrl(), is("https://www.facebook.com/groups/525066904174158/"));
    }


    @Test
    public void socialLinksWork() throws Exception {
        List<String> expectedUrls = Arrays.asList("https://www.facebook.com/groups/525066904174158/",
                "https://twitter.com/seleniumfrmwrk",
                "https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA",
                "https://plus.google.com/111979135243110831526");

        for (int i = 0; i < homePage.getSocialLinks().size(); i++) {
            homePage.clickSocialLinkWithIndex(i);

            List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(windowHandles.get(1));

            assertThat(driver.getCurrentUrl(), is(expectedUrls.get(i)));

            driver.close();
            driver.switchTo().window(windowHandles.get(0));
        }
    }
}
