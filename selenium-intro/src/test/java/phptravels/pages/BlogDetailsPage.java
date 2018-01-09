package phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.PageBase;

import java.util.List;

/**
 * Created by Ale on 23/08/17.
 */
public class BlogDetailsPage extends PageBase {

    @FindBy(xpath = "//h2[contains(@class, 'title')]")
    private WebElement title;
    @FindBy(xpath = "//div[contains(@class, 'RTL')]/h2/following-sibling::p")
    private List<WebElement> descriptionParagraphs;


    public BlogDetailsPage(WebDriver driver) {
        super(driver);
        waitForURLToContain("blog/");
    }

    public String getPostTitle() {
        waitForElementToBeVisible(title);
        return title.getText().split("\n")[0];
    }

    public String getDescription() {
        String descriptionText = "";
        for (WebElement p : descriptionParagraphs)
            descriptionText += p.getText();
        return descriptionText;
    }
}
