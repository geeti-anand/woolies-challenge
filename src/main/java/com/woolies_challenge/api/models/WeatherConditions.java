package com.woolies_challenge.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherConditions {

    @JsonProperty("main")
    private Temperature temperature;
    private String dt_txt; // e.g. "2020-08-22 06:00:00"

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
