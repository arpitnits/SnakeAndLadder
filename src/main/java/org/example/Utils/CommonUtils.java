package org.example.Utils;

import java.util.Random;

public abstract class CommonUtils {

    public static String getId() {
        return java.util.UUID.randomUUID().toString();
    }

    public static int getDiceValue() {
        Random rand = new Random();

        return rand.nextInt((6 - 1) + 1) + 1;
    }
}
