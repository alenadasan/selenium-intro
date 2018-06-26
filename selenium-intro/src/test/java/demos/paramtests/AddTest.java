package demos.paramtests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Ale on 16/01/18.
 */
@RunWith(value = Parameterized.class)
public class AddTest {

    private int a;
    private int b;
    private int s;

    public AddTest(int a, int b, int s) {
        this.a = a;
        this.b = b;
        this.s = s;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1, 2},
                {2, 2, 4},
                {4, 5, 9}
        });
    }

    @Test
    public void canAddTwoNumbers() throws Exception {
        assertThat(MathUtils.add(a, b), is(s));
    }
}
