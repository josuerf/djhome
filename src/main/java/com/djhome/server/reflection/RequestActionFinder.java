package main.java.com.djhome.server.reflection;

import main.java.com.djhome.server.utils.NumberUtils;

public class RequestActionFinder {
    public static String doRequestAction(String request){
        String response = new ClassReflector()
                .getMirroredClass("main.java.com.djhome.server.controller.HomeController")
                .newInstance()
                .getMethod(getRequestMethod(), getRequestParam(request))
                .build();
        return response;
    }

    private static Integer getRequestParam(String request) {
        return Integer.parseInt(NumberUtils.clearString(request));
    }

    private static String getRequestMethod() {
        return "distanceAction";
    }

}
