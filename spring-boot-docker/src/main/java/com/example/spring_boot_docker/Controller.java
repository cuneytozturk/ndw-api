package com.example.spring_boot_docker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    public class Controller {

        @RequestMapping("/health")
        public String health() {
            return "Hello Docker World!";
        }
    }

