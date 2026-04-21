package com.oopsbanner;

public class HelloApp {

    public static void main(String[] args) {

        // Default case
        if (args.length == 0) {
            System.out.println("Hello, World!");
        } else {

            // Use String.join
            String names = String.join(", ", args);

            System.out.println("Hello, " + names + "!");
        }
    }
}