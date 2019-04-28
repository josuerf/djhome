package main.java.com.djhome.server.reflection;

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
        return Integer.parseInt(request);
    }

    private static String getRequestMethod() {
        return "distanceAction";
    }
}
