package main.java.com.djhome.server;


import main.java.com.djhome.server.model.ServerType;
import main.java.com.djhome.server.protocols.TCPServer;
import main.java.com.djhome.server.protocols.UDPServer;

import java.io.IOException;
import java.util.Scanner;

public class Server {

    private static void initServer(ServerType serverType) throws IOException {
        switch (serverType) {
            case TCP:
                new TCPServer();
            case UDP:
                new UDPServer();
        }
    }

    public static void main(String[] args) throws IOException {
        showConfigurationMenu();
        ServerType serverType = getSelectedOption();
        initServer(serverType);
    }

    private static void showConfigurationMenu() {
        System.out.println(">> Server Configuration <<\n" +
                "Choose the server type:\n" +
                "1 - TCP\n" +
                "2 - UDP\n" +
                "Other - Shutdown the system.");
        System.out.print("Option: ");
    }

    private static ServerType getSelectedOption() {
        Scanner keyboardScanner = new Scanner(System.in);
        switch (keyboardScanner.next()) {
            case "1":
                return ServerType.TCP;
            case "2":
                return ServerType.UDP;
            default:
                System.exit(0);
                return null;
        }
    }

}
