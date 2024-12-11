package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/traffic-signs")
public class NDWApiController {

    @Autowired
    private NDWApiService ndwApiService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{roadSectionId}")
    public String getTrafficSigns(@PathVariable("roadSectionId") int roadSectionId) {
        return ndwApiService.getTrafficSignsData(roadSectionId);
    }
}
