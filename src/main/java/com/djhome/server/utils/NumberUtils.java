package main.java.com.djhome.server.utils;

public class NumberUtils {
    public static String clearString(String request) {
        StringBuilder cleaned = new StringBuilder();
        for(char c : request.toCharArray()){
            if(isNumeric(c+"")){
                cleaned.append(c);
            }
        }
        return cleaned.toString();
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
