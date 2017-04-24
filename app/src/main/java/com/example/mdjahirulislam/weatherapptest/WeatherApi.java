package com.example.mdjahirulislam.weatherapptest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by mdjahirulislam on 20/04/17.
 */

public interface WeatherApi {
    @GET()
    Call<WeatherModelResponse> getWeatherResponse(@Url String urlString);
}
