package com.example.demo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traffic-signs")
public class NDWApiController {

    @Autowired
    private NDWApiService ndwApiService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/TS/{roadSectionId}")
    public String getTrafficSigns(@PathVariable("roadSectionId") int roadSectionId) {
        return ndwApiService.getTrafficSignsData(roadSectionId);
    }

//    @GetMapping
//    public List<TrafficSign> getFilteredTrafficSigns(
//            @RequestParam double swLat,
//            @RequestParam double swLng,
//            @RequestParam double neLat,
//            @RequestParam double neLng,
//            @RequestParam String countyCode
//        ) {
//            // Haal data van de NDW API
//            List<TrafficSign> allSigns = ndwApiService.getTrafficSignsByCounty(countyCode);
//
//            // Filter borden binnen de bounding box
//            return allSigns.stream()
//                    .filter(sign -> sign.getLatitude() >= swLat && sign.getLatitude() <= neLat)
//                    .filter(sign -> sign.getLongitude() >= swLng && sign.getLongitude() <= neLng)
//                    .collect(Collectors.toList());
//        }

    @GetMapping("/{countyCode}")
    public List<CoordinateDTO> getTSM(@PathVariable ("countyCode") String countyCode) throws JsonProcessingException {
        //return ndwApiService.getTrafficSignsByCounty(countyCode);
        return ndwApiService.getCoordinatesAndRvvCodes(countyCode);
    }



}
