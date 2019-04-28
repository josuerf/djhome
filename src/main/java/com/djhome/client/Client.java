package main.java.com.djhome.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.java.com.djhome.client.api.RequestType;
import main.java.com.djhome.client.model.Car;
import main.java.com.djhome.io.FileUtils;

import java.util.Map;
import java.util.Scanner;

public class Client {

    public static void main(String[] argv) {
        setConfigurations();
        simulateArriveHome();
    }

    private static void setConfigurations() {
        //Request protocol
        showRequestProtocolMenu();
        String protocol = getSelectedProtocolOption();
        //Initial distance from home
        showInitDistanceMenu();
        String initDistance = getSelectedMetersOption();
        //Decay of car movement in meters
        showCarMoveSpeed();
        String requestFrequency = getSelectedMetersOption();
        //Write new json config file
        setSelectedConfig(protocol, initDistance, requestFrequency);

    }

    private static void simulateArriveHome() {
        Car car = new Car();
        car.bringMeToMyHome();
    }

    private static String getSelectedMetersOption() {
        Scanner keyboardScanner = new Scanner(System.in);
        return keyboardScanner.next();
    }

    private static String getSelectedProtocolOption() {
        Scanner keyboardScanner = new Scanner(System.in);
        switch (keyboardScanner.next()) {
            case "1":
                return "TCP";
            case "2":
                return "UDP";
            default:
                System.exit(0);
                return null;
        }
    }

    private static void setSelectedConfig(String protocol, String initDistance, String requestFrequency) {
        Gson gson = new Gson();
        Map<String, String> config = gson
                .fromJson(FileUtils.readJsonFile("config"),
                        new TypeToken<Map<String, RequestType>>() {
                        }.getType());

        assert config != null;

        config.put("protocol", protocol);
        config.put("initialDistance", initDistance);
        config.put("requestFrequency", requestFrequency);

        FileUtils.writeJsonFile("config", gson.toJson(config));
    }

    private static void showRequestProtocolMenu() {
        System.out.println(">> Client Configuration <<\n" +
                "Choose the protocol of request to the server:\n" +
                "1 - TCP\n" +
                "2 - UDP\n" +
                "Other - Shutdown the system.");
        System.out.print("Option: ");
    }

    private static void showCarMoveSpeed() {
        System.out.println("\nChoose the request's frequency to the server:");
        System.out.print("Frequency in meters: ");
    }

    private static void showInitDistanceMenu() {
        System.out.println("\nChoose the initial distance from your home:");
        System.out.print("Distance in meters: ");
    }

}
