package com.djhome.client;

import com.djhome.client.model.Car;
import com.djhome.client.utils.MenuUtils;
import com.djhome.io.FileUtils;
import com.djhome.utils.KeyboardUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public class Client {

    public static void main(String[] argv) {
        showConfigurationsMenu();
        simulateArriveHome();
    }

    private static void showConfigurationsMenu() {
        //Request protocol
        MenuUtils.showRequestProtocolMenu();
        String protocol = KeyboardUtils.getSelectedProtocol().name();
        //Initial distance from home
        MenuUtils.showInitDistanceMenu();
        String initDistance = KeyboardUtils.getSelectedMeters();
        //Decay of car movement in meters
        MenuUtils.showRequestFrenquencyMenu();
        String requestFrequency = KeyboardUtils.getSelectedMeters();
        //Write new json config file
        setSelectedConfig(protocol, initDistance, requestFrequency);
    }

    private static void simulateArriveHome() {
        Car car = new Car();
        car.bringMeToMyHome();
    }

    private static void setSelectedConfig(String protocol, String initDistance, String requestFrequency) {
        Map<String, String> configMap = new Gson()
                .fromJson(FileUtils.readJsonFile("config"),
                        new TypeToken<Map>(){}.getType());

        assert configMap != null;

        configMap.put("protocol", protocol);
        configMap.put("initialDistance", initDistance);
        configMap.put("requestFrequency", requestFrequency);

        FileUtils.writeJsonFile("config", configMap);
    }

}
