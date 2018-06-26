package phptravels.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import phptravels.pages.BlogListPage;
import resources.TestBase;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static phptravels.LoginUtils.HOME_PAGE_URL;

/**
 * Created by Ale on 02/08/17.
 */
public class BlogSearchTest extends TestBase {

    private BlogListPage blogPage;

    @Before
    public void setUp() {
        driver.get(HOME_PAGE_URL + "blog/");
        blogPage = new BlogListPage(driver);
    }

    @Test
    public void canSearchForArticles() throws Exception {
        String searchQuery = "paradise";

        BlogListPage resultsPage = blogPage.searchFor(searchQuery);
        List<String> results = resultsPage.getResults();

        for (String result : results)
            assertThat(result.toLowerCase(), containsString(searchQuery));
    }

    @Test
    public void searchResultsContainQueryInTitleOrArticle() throws Exception {
        String searchQuery = "and";

        BlogListPage resultsPage = blogPage.searchFor(searchQuery);
        List<String> results = resultsPage.getResults();

        for (String articleTitle : results)
            assertThat("Article with title: " + articleTitle + " did not contain search query: " + searchQuery,
                    resultsPage.articleContainsQuery(articleTitle, searchQuery), is(true));
    }

    @Ignore
    @Test //TODO
    public void whenSearchingByDate_noResultsAreDisplayed() throws Exception {

    }

    @Ignore
    @Test //TODO
    public void cannotSearchWithEmptySearchField() throws Exception {

    }

    @Ignore
    @Test
    public void whenEnteringBlog_articlesAreDisplayed() throws Exception {
        assertThat(blogPage.getResults().size(), greaterThan(0));

//        TODO
//        assertThat("a", is("a"));
//        assertThat(blogPage.getResults(), is(Arrays.asList("aaa")));
//        assertThat(blogPage.getResults(), contains(Arrays.asList("aaa")));
//        assertThat(blogPage.getResults(), equalTo(Arrays.asList("aaa")));
//        assertThat(blogPage.getResults(), contains("a"));
//        assertThat(blogPage.getResults(), equalTo("a"));
//        assertThat();
//
//        String x = "a";


    }


}
