package main.java.com.djhome.utils;

import java.util.Scanner;

public class KeyboardUtils {

    public static Protocols getSelectedProtocol() {
        Scanner keyboardScanner = new Scanner(System.in);
        switch (keyboardScanner.next()) {
            case "1":
                return Protocols.TCP;
            case "2":
                return Protocols.UDP;
            default:
                System.exit(0);
                return null;
        }
    }

    public static String getSelectedMeters() {
        return new Scanner(System.in).next();
    }
}
