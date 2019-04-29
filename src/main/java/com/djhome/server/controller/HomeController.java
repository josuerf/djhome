package com.djhome.server.controller;

import com.djhome.io.FileUtils;
import com.djhome.server.model.Instruction;
import com.djhome.server.reflection.ClassReflector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;


public class HomeController {

    private static final String BASE_PACKAGE = "com.djhome.server.control.";

    public String distanceBasedAction(int distance) {
        List<Instruction> instructions = new Gson()
                .fromJson(FileUtils.readJsonFile("instructions"),
                        new TypeToken<List<Instruction>>() {
                        }.getType());

        Instruction instructionReached = instructions.stream()
                .filter(instruction -> instruction.getDistance() == distance)
                .findFirst().orElse(null);

        return executeHomeInstruction(instructionReached);
    }

    private String executeHomeInstruction(Instruction instructionReached) {
        String actionResponse = "";
        if (instructionReached != null) {
            actionResponse = new ClassReflector()
                    .getMirroredClass(BASE_PACKAGE + instructionReached.getControl() + "Control")
                    .newInstance()
                    .getMethod(instructionReached.getAction())
                    .build();
        }
        return actionResponse;
    }

}
