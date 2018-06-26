package demos;

import java.util.UUID;


/**
 * Created by Ale on 09/08/17.
 */
public class RandomGeneratorDemo {

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }

    public static String getRandomString() {
        return UUID.randomUUID().toString();
    }
}
