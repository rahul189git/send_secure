package com.pb.riskanalysisforsmb.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherVO {
    private Date date;
    private String weatherDescription;
    private float humidity;
    private float temp;
    private float minTemp;
    private float maxTemp;
    private String city;
    private String country;

    public WeatherVO(Date date, String weatherDescription, float humidity, float temp, float minTemp, float maxTemp, String city, String country) {
        this.date = date;
        this.weatherDescription = weatherDescription;
        this.humidity = humidity;
        this.temp = temp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.city = city;
        this.country = country;
    }

    public WeatherVO(Date date, String weatherDescription, float humidity, float temp, float minTemp, float maxTemp) {
        this.date = date;
        this.weatherDescription = weatherDescription;
        this.humidity = humidity;
        this.temp = temp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public static long getFahrenheit(float temp) {
        double f = (((temp - 273) * 9 / 5) + 32);
        return Math.round(f);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(float minTemp) {
        this.minTemp = minTemp;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public Date getDate() {
        return date;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    @Override
    public String toString() {
        String tempDesc = "temperature ranging between " + minTemp + "F to " + maxTemp + "F";

        if (minTemp == maxTemp) {
            tempDesc = temp + "F temperature";
        }

        return weatherDescription + " in " + city + ',' + country + " on " + new SimpleDateFormat("EEE, MMM d, yyyy").format(date) + " (Estimated Delivery Date) with " + humidity + "% humidity & " + tempDesc;
    }
}
