package automationpractice.tests;

import automationpractice.builders.ContactMessage.ContactMessageBuilder;
import automationpractice.pages.ContactPage;
import automationpractice.pages.HomePage;
import org.junit.Before;
import org.junit.Test;
import resources.TestBase;

import static automationpractice.enums.SubjectHeading.CUSTOMER_SERVICE;
import static automationpractice.enums.SubjectHeading.WEBMASTER;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static resources.StringUtils.getRandomEmailAddress;

/**
 * Created by Ale on 09/01/18.
 */
public class ContactTest extends TestBase {

    private ContactPage contactPage;

    @Before
    public void setUp() {
        driver.get("http://automationpractice.com");
        HomePage homePage = new HomePage(driver);
        contactPage = homePage.getHeader().clickContactUs();
    }

    @Test
    public void canSendAContactMessage() throws Exception {
        ContactPage confirmationPage = contactPage.sendMessage("Webmaster", getRandomEmailAddress(),
                "1109", "This is a test");

        assertThat("Could not send contact message", confirmationPage.getStatusMesage(), is("Your message has been successfully sent to our team."));
    }

    @Test
    public void canSendAContactMessage_enum() throws Exception {
        ContactPage confirmationPage = contactPage.sendMessage(CUSTOMER_SERVICE, getRandomEmailAddress(),
                "", "This is a test");

        assertThat(confirmationPage.getStatusMesage(), is("Your message has been successfully sent to our team."));
    }

    @Test
    public void canSendAContactMessage_builder() throws Exception {
        ContactPage confirmationPage = contactPage.sendMessage(new ContactMessageBuilder()
                .subject(WEBMASTER)
                .email(getRandomEmailAddress())
                .message("This is another test")
                .build());

        assertThat(confirmationPage.getStatusMesage(), is("Your message has been successfully sent to our team."));
    }

    @Test
    public void cannotSendAContactMessage_withNoData() throws Exception {
        ContactPage updatedPage = contactPage.sendMessage(new ContactMessageBuilder().build());

        assertThat(updatedPage.getStatusMesage(), containsString("Invalid email address."));
    }
}
