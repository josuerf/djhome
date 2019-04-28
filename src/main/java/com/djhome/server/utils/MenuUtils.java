package main.java.com.djhome.server.utils;

public class MenuUtils {
    public static void showConfigurationMenu() {
        System.out.println(">> Server Configuration <<\n" +
                "Choose the server type:\n" +
                "1 - TCP\n" +
                "2 - UDP\n" +
                "Other - Shutdown the system.");
        System.out.print("Option: ");
    }
}
