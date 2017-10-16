package ru.bstu.vt41.davydov.Entities;

import java.sql.Date;

public class Apartment {
    private Date buildDate;
    private String material;
    private double square;

    Apartment(){}


    public Apartment(Date buildDate, String material, double square) {
        this.buildDate = buildDate;
        this.material = material;
        this.square = square;
    }

}
