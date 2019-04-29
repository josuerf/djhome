package com.djhome.server.model;

public class Instruction {
    private int distance;
    private String control;
    private String action;

    public Instruction() {
    }

    public Instruction(int distance, String control, String action) {
        this.distance = distance;
        this.control = control;
        this.action = action;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
