package com.example.assweatherapi.network;
import com.example.assweatherapi.model.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface APIManager {
    String SERVER_URL = "https://dataservice.accuweather.com/";
    @GET("/forecasts/v1/daily/5day/353412?apikey=YvLXLyI3SiE8xuQKF3p4A1B1I1RksiXR&language=vi-vn&metric=true")
    Call<List<Weather>> getHour();
    @GET("/forecasts/v1/hourly/12hour/353412?apikey=93Qg780lHwYM4SO58n7DFPLqHg4oKADn&language=vi-vn&metric=true" )
    Call<List<Weather>> getDays();

}
