package com.example.demo;

import com.example.demo.NDWApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NDWApiController {

    @Autowired
    private NDWApiService ndwApiService;

    @GetMapping("/traffic-signs")
    public String getTrafficSigns() {
        return ndwApiService.getTrafficSignsData();
    }

    @GetMapping("/health")
    public String getHealth() {
        return "Healthy";
    }
}
