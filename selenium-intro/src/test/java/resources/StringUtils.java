package resources;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ale on 21/08/17.
 */
public class StringUtils {

    public static List<String> getStringsFromWebElements(List<WebElement> webElements) {
        List<String> strings = new ArrayList<String>();
        for (WebElement webElement : webElements) {
            strings.add(webElement.getText());
        }
        return strings;
    }

    public static String getRandomEmailAddress() {
        return UUID.randomUUID().toString().substring(0, 15) + "@mailnesia.com";
    }
}
