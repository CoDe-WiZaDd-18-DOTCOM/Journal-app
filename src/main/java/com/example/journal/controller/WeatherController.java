package com.example.journal.controller;

import com.example.journal.ApiResponse.WeatherApi;
import com.example.journal.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public String getweather(@PathVariable String city){
        WeatherApi weatherApi = weatherService.getweather(city);
        return "the current temperature of the "+city+" is "+weatherApi.getCurrent().getTemperature();
    }
}
