package com.oopsbanner;

public class HelloApp {

    public static void main(String[] args) {

        // If no arguments → default
        if (args.length == 0) {
            System.out.println("Hello, World!");
        } else {

            // Use StringBuilder for efficient string building
            StringBuilder names = new StringBuilder();

            // Enhanced for loop
            for (String name : args) {
                if (names.length() > 0) {
                    names.append(", "); // add comma only after first name
                }
                names.append(name);
            }

            System.out.println("Hello, " + names + "!");
        }
    }
}