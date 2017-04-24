package com.example.mdjahirulislam.weatherapptest;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToDayDetailsFragment extends Fragment {

    private final String BASE_URL = "https://query.yahooapis.com/";
    private final String IMAGE_CODE_URL = "http://fullnightfun.com/weather_icon/";

    private WeatherApi weatherApi;

    private TextView detailsHumidityTV;
    private TextView detailsSunSetTV;
    private TextView detailsSunRiseTV;
    private TextView detailsVisibilityTV;

    private TextView detailsDescriptionTV;

    private TextView detailsWindTV;
    private TextView detailsPressureTV;

    private ImageView detailsIV;
    private ImageView windIV;


    private String cityName = "Dhaka";
    private String date;
//    CurrentWeatherFragment.SendWeatherCondition send;


    public ToDayDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_to_day_details, container, false);

        detailsHumidityTV = (TextView) view.findViewById(R.id.detailsHumidityTV);
        detailsSunRiseTV = (TextView) view.findViewById(R.id.detailsMaxTempTV);
        detailsSunSetTV = (TextView) view.findViewById(R.id.detailsMinTempTV);
        detailsVisibilityTV = (TextView) view.findViewById(R.id.detailsVisibilityTV);
//        detailsDescriptionTV = (TextView) view.findViewById(R.id.detailsDescriptionTV);
        detailsWindTV = (TextView) view.findViewById(R.id.detailsWindTV);
        detailsPressureTV = (TextView) view.findViewById(R.id.detailsPressureTV);

        detailsIV = (ImageView) view.findViewById(R.id.detailsIV);
        windIV = (ImageView) view.findViewById(R.id.windIV);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getResponse(cityName);

//        Log.d("current rj",getArguments().getString("cityName","null"));


    }

    public void getResponse(String cityName){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        weatherApi = retrofit.create(WeatherApi.class);
        String url = "v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22"+cityName+"%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

        Call<WeatherModelResponse> weatherModelResponseCall = weatherApi.getWeatherResponse(url);

        weatherModelResponseCall.enqueue(new Callback<WeatherModelResponse>() {
            @Override
            public void onResponse(Call<WeatherModelResponse> call, Response<WeatherModelResponse> response) {
                if (response.code() == 200){
                    WeatherModelResponse weatherModelResponse = response.body();
                    String humidity = weatherModelResponse.getQuery().getResults().getChannel().getAtmosphere().getHumidity();
                    String sunRise = weatherModelResponse.getQuery().getResults().getChannel().getAstronomy().getSunrise();
                    String sunSet = weatherModelResponse.getQuery().getResults().getChannel().getAstronomy().getSunset();
                    String visibility = weatherModelResponse.getQuery().getResults().getChannel().getAtmosphere().getVisibility();

                    String description = weatherModelResponse.getQuery().getResults().getChannel().getItem().getDescription();

                    String wind = weatherModelResponse.getQuery().getResults().getChannel().getWind().getSpeed();
                    String pressure = weatherModelResponse.getQuery().getResults().getChannel().getAtmosphere().getPressure();

                    date = weatherModelResponse.getQuery().getResults().getChannel().getItem().getForecast().get(0).getDate();
                    String imgCode = "34";
                    String windImageCode = "icon-green-wind";

//                    Log.d("image code",imgCode.toString());
//                    Log.d("image code",date.toString());

                    Context detailsIVContext= detailsIV.getContext();
                    Uri fileUri= Uri.parse(IMAGE_CODE_URL+imgCode+".gif");
                    Picasso.with(detailsIVContext).load(fileUri).into(detailsIV);

                    Context windIVContext= windIV.getContext();
                    Uri fileUri2= Uri.parse(IMAGE_CODE_URL+windImageCode+".png");
                    Picasso.with(windIVContext).load(fileUri2).into(windIV);

                    detailsHumidityTV.setText(humidity+" %");
                    detailsSunRiseTV.setText(sunRise);
                    detailsSunSetTV.setText(sunSet);
                    detailsVisibilityTV.setText(visibility+" mi");

//                    detailsDescriptionTV.setText(description);

                    detailsWindTV.setText(wind+" mph N");
                    detailsPressureTV.setText(pressure);

//                    currentLocation.setText("Current Location in "+city);

                }
            }

            @Override
            public void onFailure(Call<WeatherModelResponse> call, Throwable t) {

            }
        });
    }

}
