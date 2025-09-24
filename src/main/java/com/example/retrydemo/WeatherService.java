package com.example.retrydemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    @Value("${openweather.api.key}")
    private String apiKey;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Retryable(
        value = RuntimeException.class,
        maxAttemptsExpression = "${retry.maxattempts:3}",
        backoff = @Backoff(delayExpression = "${retry.backoff:2000}")
    )

    @SuppressWarnings("UseSpecificCatch")
    public String getWeather(String city) {
        String url = String.format(
            "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric",
            city, apiKey);

        try {
            String response = restTemplate.getForObject(url, String.class);
            System.out.println("Weather API success for: " + city);
            return response;
        } catch (Exception e) {
            System.out.println("Weather API failed for: " + city + " Retrying...");
            throw new RuntimeException("Weather API failure", e);
        }
    }

    @Recover
    public String fallbackWeather(RuntimeException e, String city) {
        System.out.println("All retries failed. Returning fallback.");
        return "{ \"city\": \"" + city + "\", \"message\": \"Weather service unavailable. Please try later.\" }";
    }
}
