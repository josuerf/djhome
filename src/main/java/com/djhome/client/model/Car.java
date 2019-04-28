package main.java.com.djhome.client.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.java.com.djhome.io.FileUtils;

import java.util.Map;

public class Car {

    static int DISTANCE;
    private int requestFrequency;
    private CarMovement carMovement;

    public Car() {
        loadConfigs();
    }

    public void bringMeToMyHome() {
        carMovement = new CarMovement();
        carMovement.run(requestFrequency);
    }

    public void makeStop() {
        if (carMovement != null)
            carMovement.stop();
    }

    private void loadConfigs() {
        Map<String, String> config = new Gson()
                .fromJson(FileUtils.readJsonFile("config"),
                        new TypeToken<Map<String, String>>(){}.getType());

        Car.DISTANCE = Integer.parseInt(config.get("initialDistance"));
        this.requestFrequency = Integer.parseInt(config.get("requestFrequency"));
    }
}
