package main.java.com.djhome.client.model;

import main.java.com.djhome.client.api.RequestBuilder;

import java.util.Timer;
import java.util.TimerTask;

class CarMovement {

    private Timer timer = new Timer();
    private TimerTask task = null;
    private RequestBuilder requestBuilder = new RequestBuilder()
            .withDistance(Car.DISTANCE)
            .onResponse(System.out::println)
            .onError(Throwable::printStackTrace);

    void run(int speed){
        task = new TimerTask() {
            public void run()
            {
                if(Car.DISTANCE <= 0){
                    System.out.println("\nYou Arrived!");
                    stop();
                } else {
                    printDistance();
                }
                requestBuilder.call();
                requestBuilder.withDistance(Car.DISTANCE -= speed);
            }
        };
        timer.schedule( task,0L, Car.DISTANCE );
    }
    void stop(){
        task.cancel();
    }
    private void printDistance() {
        System.out.println("Car Distance: " + Car.DISTANCE + "m");
    }

}
