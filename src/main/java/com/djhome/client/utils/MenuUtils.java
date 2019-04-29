package com.djhome.client.utils;

public class MenuUtils {
    public static void showRequestProtocolMenu() {
        System.out.println(">> Client Configuration <<\n" +
                "Choose the protocol of request to the server:\n" +
                "1 - TCP\n" +
                "2 - UDP\n" +
                "Other - Shutdown the system.");
        System.out.print("Option: ");
    }

    public static void showRequestFrenquencyMenu() {
        System.out.println("\nChoose the request's frequency to the server:");
        System.out.print("Frequency in meters: ");
    }

    public static void showInitDistanceMenu() {
        System.out.println("\nChoose the initial distance from your home:");
        System.out.print("Distance in meters: ");
    }
}
