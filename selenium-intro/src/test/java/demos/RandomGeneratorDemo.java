package demos;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

/**
 * Created by Ale on 09/08/17.
 */
public class RandomGeneratorDemo {

    public static void main(String[] args) {
        System.out.println(RandomStringUtils.randomNumeric(30));
        System.out.println(RandomStringUtils.randomAlphanumeric(30));
        System.out.println(UUID.randomUUID().toString());
    }
}
