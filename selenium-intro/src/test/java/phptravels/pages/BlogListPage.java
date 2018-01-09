package phptravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

import java.util.ArrayList;
import java.util.List;

public class BlogListPage extends PageBase {

    @FindBy(name = "s")
    private WebElement searchInput;
    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='panel-body']//h3")
    private List<WebElement> results;
    @FindBy(xpath = "//div[text()='Categories and Posts']/following-sibling::a")
    private List<WebElement> categoryLinks;

    public BlogListPage(WebDriver driver) {
        super(driver);
        waitForURLToContain("/blog");
    }

    public BlogListPage searchFor(String query) {
        waitForElementToBeVisible(searchInput);
        searchInput.clear();
        searchInput.sendKeys(query);
        searchButton.click();

        return new BlogListPage(driver);
    }

    public List<String> getCategories() {
        List<String> categoryList = new ArrayList<String>();
        for (WebElement link : categoryLinks)
            categoryList.add(link.getText());

        return categoryList;
    }

    public List<String> getResults() {
        List<String> articleTitles = new ArrayList<String>();
        waitForElementsToBeVisible(results);

        for (WebElement result : results)
            articleTitles.add(result.getText());

        return articleTitles;
    }

    public boolean articleContainsQuery(String articleTitle, String query) {
        boolean currentArticleContainsQuery = false;

        if (!articleTitle.contains(query)) {
            WebElement result = driver.findElement(By.xpath("//h3[text()='" + articleTitle + "']"));
            result.click();
            BlogDetailsPage detailsPage = new BlogDetailsPage(driver);
            currentArticleContainsQuery = detailsPage.getDescription().contains(query);
            if (currentArticleContainsQuery) {
                driver.navigate().back();
                BlogListPage updatedPage = new BlogListPage(driver);
            }
        } else currentArticleContainsQuery = true;

        return currentArticleContainsQuery;
    }
}
