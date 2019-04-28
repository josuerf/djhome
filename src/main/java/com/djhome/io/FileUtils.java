package main.java.com.djhome.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    private static final String USER_DIR = System.getProperty("user.dir");

    public static String readJsonFile(String fileName) {
        try {

            Path pathObj = Paths.get(USER_DIR + "\\src\\main\\resources\\" + fileName + ".json");
            byte[] bytes = Files.readAllBytes(pathObj);

            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeJsonFile(String fileName, String fileContent) {
        Path filePath = Path.of(USER_DIR + "\\src\\main\\resources\\" + fileName + ".json");
        try {
            Files.writeString(filePath, fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
