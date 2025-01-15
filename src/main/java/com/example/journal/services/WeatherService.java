package com.example.journal.services;

import com.example.journal.ApiResponse.WeatherApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    private static final String weatherApi = "dde24d6524dd879bfd4b6b7d91d7ab13";

    private static final String API = "https://api.weatherstack.com/current?access_key=ACCESS_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;


    public WeatherApi getweather(String city){
        String finalApi = API.replace("ACCESS_KEY",weatherApi).replace("CITY",city);

        ResponseEntity<WeatherApi> weatherResponse = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherApi.class);

        WeatherApi weatherData = weatherResponse.getBody();
        return weatherData;
    }
}
