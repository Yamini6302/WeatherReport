package com.ust.WeatherReportApplication.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ust.WeatherReportApplication.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final String URL = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}";

    public WeatherResponse getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();

        // Fetching weather data from OpenWeatherMap API
        WeatherResponse weatherData = restTemplate.getForObject(URL, WeatherResponse.class, city, apiKey);

        return weatherData; // Return the fetched data
    }
}