package main.java.com.djhome.client.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.java.com.djhome.io.FileUtils;

import java.util.Map;

public class Car {

    static int DISTANCE;
    private final int decay;
    private CarMovement carMovement;

    public Car() {
        Map<String, String> config = new Gson()
                .fromJson(FileUtils.readJsonFile("config"),
                        new TypeToken<Map<String, String>>(){}.getType());

        Car.DISTANCE = Integer.parseInt(config.get("initialDistance"));
        this.decay = Integer.parseInt(config.get("requestFrequency"));
    }

    public void bringMeToMyHome() {
        carMovement = new CarMovement();
        carMovement.run(decay);
    }

    public void makeStop() {
        if (carMovement != null)
            carMovement.stop();
    }

}
