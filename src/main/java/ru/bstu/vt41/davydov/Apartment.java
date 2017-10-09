package ru.bstu.vt41.davydov;

import java.util.Date;

public class Apartment {
    private Date buildDate;
    private String material;
    private double square;
    private String modelVersion;

    Apartment(){}


    public Apartment(Date buildDate, String material, double square, String modelVersion) {
        this.buildDate = buildDate;
        this.material = material;
        this.square = square;
        this.modelVersion = modelVersion;
    }

    void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
    }

    void setMaterial(String material) {
        this.material = material;
    }

    void setSquare(double square) {
        this.square = square;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }
}
