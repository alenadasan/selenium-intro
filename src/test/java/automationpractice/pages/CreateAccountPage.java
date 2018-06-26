package automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {

    @FindBy(id = "days")
    private WebElement daysDropdown;

    public void selectDayOfBirth(String day) {
        Select daySelector = new Select(daysDropdown);

        daySelector.selectByVisibleText(day);
    }
}
