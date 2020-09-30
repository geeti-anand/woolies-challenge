package com.woolies_challenge.stepdef;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woolies_challenge.api.models.ForecastModel;
import com.woolies_challenge.api.models.Temperature;
import com.woolies_challenge.api.models.WeatherConditions;
import com.woolies_challenge.api.models.WeatherForecast;
import com.woolies_challenge.util.DayOfWeekUtil;
import com.woolies_challenge.util.TempUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class HolidayPlanner {

    private static ForecastModel forecastModel;
    private static List<WeatherConditions> thursdayWeatherConditions;

    @Given("^I like to holiday in \"([^\"]*)\"$")
    public void cityForHoliday(String city) {
        WeatherForecast weatherForecastApi = new WeatherForecast();
        Response response = weatherForecastApi.getForecastByCity(city);
        String responseString = response.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            forecastModel = objectMapper.readValue(responseString, ForecastModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @And("^I only like to holiday on Thursdays$")
    public void dayForHoliday() {
        //from the forecastModel get all the thursdays
        //40 elements - 8 for each days
        List<WeatherConditions> weatherConditionsList = forecastModel.getWeatherConditionsList();
        thursdayWeatherConditions = new ArrayList<>();
        for (WeatherConditions weatherCondition : weatherConditionsList) {
            String dateAsString = weatherCondition.getDt_txt(); // e.g. format "2020-08-22 06:00:00"
            boolean dayOfWeek_thursday = DayOfWeekUtil.dayOfWeek(dateAsString);
            if (dayOfWeek_thursday) {
                thursdayWeatherConditions.add(weatherCondition);
            }
        }
    }



    @And("^the temperature is warmer than \"([^\"]*)\" degrees$")
    public void tempForHoliday(int tempDegrees) {
        boolean isTempFavourable = true;
        for (WeatherConditions weatherConditions : thursdayWeatherConditions) {
            Temperature temperature = weatherConditions.getTemperature();
            float tempMinInKelvin = temperature.getTemp_min();
            float tempInCelsius = TempUtil.convertToCelsius(tempMinInKelvin);
            if (tempInCelsius < tempDegrees) {
                isTempFavourable = false;
                break;
            }
        }
        if (!isTempFavourable) {
            System.out.println("No upcoming Thursday is suitable for holiday");
        }
        Assert.assertTrue(isTempFavourable, "Temperature is warmer than " + tempDegrees);
    }
}
