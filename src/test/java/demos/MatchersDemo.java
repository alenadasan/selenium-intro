package demos;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class MatchersDemo {

    @Test
    public void matchersTest() {
        String firstString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi";
        String secondString = "consectetur adipiscing elit";

        assertThat(firstString, startsWith("Lorem ipsum"));
        assertThat(firstString, endsWith("nisi"));
        assertThat(secondString, not(containsString("cucu")));

        assertThat(secondString, equalToIgnoringCase("Consectetur adipiscing ELIT"));
        assertThat(99.9999, closeTo(100, 0.1));

        assertThat(firstString, allOf(containsString("Lorem"), containsString("ipsum"), containsString("sit")));
        assertThat(secondString, any(String.class));
        assertThat(secondString, anyOf(is("consectetur adipiscing elit"), containsString("false")));
        assertThat(secondString, anything());

        assertThat(new Integer[]{1, 2, 3}, is(array(equalTo(1), equalTo(2), equalTo(3))));

        assertThat(secondString, both(containsString("elit")).and(not(containsString("gigi"))));
        assertThat(secondString, either(containsString("elit")).or(isEmptyString()));



        List<String> anArraylist = Arrays.asList("First", "Second", "Third");

        assertThat(anArraylist, contains("First", "Second", "Third"));
        assertThat(anArraylist, containsInAnyOrder("Second", "Third", "First"));
        assertThat(anArraylist, hasItem("Second"));
        assertThat(anArraylist, hasItems("Second", "First"));
        assertThat(anArraylist, everyItem(not(endsWith("x"))));
    }
}
