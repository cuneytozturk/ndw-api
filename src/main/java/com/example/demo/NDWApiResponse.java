package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class NDWApiResponse {

    private List<TrafficSign> features;

    public NDWApiResponse() {
        features = new ArrayList<>();
    }

    public List<TrafficSign> getTrafficSigns() {
        return features;
    }
}
