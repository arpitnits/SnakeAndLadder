package org.example.Utils;

public class Logger {

    public static void log(String ...args) {

        for(String val: args) {
            System.out.print(val + " ");
        }
        System.out.println();

    }
}
