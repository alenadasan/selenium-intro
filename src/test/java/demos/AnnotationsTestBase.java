package demos;

import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Created by Ale on 03/01/18.
 */
public class AnnotationsTestBase {
    @Before
    public void setUp() {
        System.out.println("test base @before");
    }

    @BeforeClass
    public static void baseClassSetUp() {
        System.out.println("Before Base class");
    }

}
