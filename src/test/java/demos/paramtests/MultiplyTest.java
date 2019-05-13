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
public class MultiplyTest {

    private int a;
    private int b;
    private int p;

    public MultiplyTest(int a, int b, int p) {
        this.a = a;
        this.b = b;
        this.p = p;
    }

    @Parameterized.Parameters(name = "{index}: testMultiply ({0} * {1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2, 2},
                {2, 3, 6},
                {3, 4, 12},
                {4, 5, 20}
        });
    }

    @Test
    public void canMultiplyTwoNumbers() {
        assertThat(a * b, is(p));
    }
}
