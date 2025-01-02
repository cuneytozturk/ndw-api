package com.example.demo;

import java.util.List;

public class CoordinateDTO {
    private List<Double> coordinates;
    private String rvvCode;

    // Constructor
    public CoordinateDTO(List<Double> coordinates, String rvvCode) {
        this.coordinates = coordinates;
        this.rvvCode = rvvCode;
    }

    // Getters and setters
    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public String getRvvCode() {
        return rvvCode;
    }

    public void setRvvCode(String rvvCode) {
        this.rvvCode = rvvCode;
    }
}

