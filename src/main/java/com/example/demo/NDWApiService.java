package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class NDWApiService {

    public String getTrafficSignsData(){
        WebClient client = WebClient.create("https://data.ndw.nu/api/rest/static-road-data/traffic-signs/v4/current-state?roadSectionId=329419005");
        Mono<String> result = client.get().retrieve().bodyToMono(String.class);
        return result.block();
    }
}
