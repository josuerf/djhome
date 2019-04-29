package com.djhome.io;

import com.google.gson.Gson;

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

    public static void writeJsonFile(String fileName, Object source) {
        Path filePath = Paths.get(USER_DIR + "\\src\\main\\resources\\" + fileName + ".json");
        try {
            Files.write(filePath, new Gson().toJson(source).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
