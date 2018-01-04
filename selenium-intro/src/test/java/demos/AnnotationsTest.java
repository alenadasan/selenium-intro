package demos;

import org.junit.*;

/**
 * Created by Ale on 26/07/17.
 */
public class AnnotationsTest extends AnnotationsTestBase {
    @BeforeClass
    public static void classSetUp() {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void classTearDown() {
        System.out.println("After Class");
    }

    @Before
    public void setUp() {
        System.out.println("Before Test Method");
    }

    @Test
    public void testOne() {
        System.out.println("Test one");
    }

    @Test
    public void testTwo() {
        System.out.println("Test two");
    }

    @After
    public void tearDown() {
        System.out.println("After Test Method");
    }
}
