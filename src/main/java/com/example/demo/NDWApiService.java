package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NDWApiService {

    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();
    private String url = "https://data.ndw.nu/api/rest/static-road-data/traffic-signs/v4/current-state?countyCode=";

    public String getTrafficSignsData(int roadSectionId){
        WebClient client = WebClient.create("https://data.ndw.nu/api/rest/static-road-data/traffic-signs/v4/current-state?roadSectionId="+roadSectionId);
        Mono<String> result = client.get().retrieve().bodyToMono(String.class);
        return result.block();
    }

//    public List<CoordinateDTO> getTrafficSignsByCounty(String countyCode){
//      return restTemplate.getForObject("https://data.ndw.nu/api/rest/static-road-data/traffic-signs/v4/current-state?countyCode="+countyCode, FeatureCollection.class);
//    }

    public List<CoordinateDTO> getCoordinatesAndRvvCodes(String countyCode) throws JsonProcessingException {
        String response = restTemplate.getForObject(url+countyCode, String.class);
        Map<String, Object> geoJSON = objectMapper.readValue(response, new TypeReference<Map<String, Object>>() {});

        // Extract "features" array
        List<Map<String, Object>> features = (List<Map<String, Object>>) geoJSON.get("features");

        // Map features naar CoordinateDTO
        List<CoordinateDTO> coordinates = new ArrayList<>();
        for (Map<String, Object> feature : features) {
            Map<String, Object> geometry = (Map<String, Object>) feature.get("geometry");
            Map<String, Object> properties = (Map<String, Object>) feature.get("properties");

            List<Double> coords = (List<Double>) geometry.get("coordinates");
            String rvvCode = (String) properties.get("rvvCode");

            coordinates.add(new CoordinateDTO(coords, rvvCode));
        }

        return coordinates;
    }
}
