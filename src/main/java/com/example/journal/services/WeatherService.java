package com.example.journal.services;

import com.example.journal.ApiResponse.WeatherApi;
import com.example.journal.controller.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    @Autowired
    private AppCache appCache;

//    @Value("${weather.api.key}")
//    private String weatherApi;
//
//    private static final String API = "https://api.weatherstack.com/current?access_key=ACCESS_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;


    public WeatherApi getweather(String city){
        String finalApi = appCache.appCache.get("weather_api_string").replace("ACCESS_KEY",appCache.appCache.get("weather_api_key")).replace("CITY",city);

        ResponseEntity<WeatherApi> weatherResponse = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherApi.class);

        WeatherApi weatherData = weatherResponse.getBody();
        return weatherData;
    }
}
