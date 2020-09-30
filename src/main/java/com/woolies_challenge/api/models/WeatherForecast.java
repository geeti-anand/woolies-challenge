package com.woolies_challenge.api.models;

import com.woolies_challenge.util.ConfigFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Properties;

public class WeatherForecast {

    private static String apiKey;
    private static String baseUrl;
    private Properties properties;

    public WeatherForecast() {

        properties = ConfigFile.configProperties();
        apiKey = properties.getProperty("apikey");
        baseUrl = properties.getProperty("base.url");
    }


    public Response getForecastByCity(String city) {

        // URL looks like https://api.openweathermap.org/data/2.5/forecast?appid=9c2c6444f9123c00403f38fb5c0e70f0&q=Sydney
        String apiUrl = baseUrl + apiKey + "&q=" + city;
        Response fiveDaysForecast = RestAssured.get(apiUrl);
        return fiveDaysForecast;
    }


}
