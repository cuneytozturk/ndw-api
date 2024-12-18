package com.example.demo;

public class Geometry {
    private double[] coordinates; // [longitude, latitude]

    public double getLongitude() {
        return coordinates[0];
    }

    public double getLatitude() {
        return coordinates[1];
    }

    // Getters en setters
}
