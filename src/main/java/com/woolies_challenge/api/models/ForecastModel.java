package com.woolies_challenge.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Model for response from weather forcast endpoint: api.openweathermap.org/data/2.5/forecast?q=Sydney&appid=d463c94d040c7904f9655f42f7f349dc
 */
public class ForecastModel {

    private String cod;
    private int message;
    private int cnt;
    @JsonProperty("list")
    private List<WeatherConditions> weatherConditionsList;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;

    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<WeatherConditions> getWeatherConditionsList() {
        return weatherConditionsList;
    }

    public void setWeatherConditionsList(List<WeatherConditions> weatherConditionsList) {
        this.weatherConditionsList = weatherConditionsList;
    }
}
