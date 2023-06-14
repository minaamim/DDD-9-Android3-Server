package com.nexters.buyornot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String healthCheck() throws Exception{
        return "health check OK";
    }

}