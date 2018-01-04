package demos;

import org.junit.Before;

/**
 * Created by Ale on 03/01/18.
 */
public class AnnotationsTestBase {
    @Before
    public void baseSetUp() {
        System.out.println("test base @before");
    }
}
