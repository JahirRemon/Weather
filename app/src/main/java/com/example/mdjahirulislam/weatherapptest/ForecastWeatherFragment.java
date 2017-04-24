package com.example.mdjahirulislam.weatherapptest;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastWeatherFragment extends Fragment {


    private final String BASE_URL = "https://query.yahooapis.com/";

    private WeatherApi weatherApi;
    private ListView forecastList;
    private ForecastCustomAdapter myAdapter;

    private ArrayList<ForecastModelClass> forecastModelClassArrayList;

    private ForecastModelClass forecastModelClass;


    public ForecastWeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        forecastModelClass = new ForecastModelClass();
        forecastModelClassArrayList = new ArrayList<>();

        View view = inflater.inflate(R.layout.fragment_forcast_weather, container, false);
        forecastList = (ListView) view.findViewById(R.id.forecastList);
        return view;

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        weatherApi = retrofit.create(WeatherApi.class);
        String url = "v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22Dhaka%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

        Call<WeatherModelResponse> weatherModelResponseCall = weatherApi.getWeatherResponse(url);

        weatherModelResponseCall.enqueue(new Callback<WeatherModelResponse>() {
            @Override
            public void onResponse(Call<WeatherModelResponse> call, Response<WeatherModelResponse> response) {
                if (response.code() == 200){
                    WeatherModelResponse weatherModelResponse = response.body();
                    String city = weatherModelResponse.getQuery().getResults().getChannel().getLocation().getCity().toString();


                    ArrayList<WeatherModelResponse.Query.Results.Channel.Item.Forecast> forecastArrayList =
                            (ArrayList<WeatherModelResponse.Query.Results.Channel.Item.Forecast>) weatherModelResponse.getQuery().getResults().getChannel().getItem().getForecast();


                    Log.d("forecast",String.valueOf(forecastArrayList.size()));

                    for (int i = 0; i < forecastArrayList.size(); i++){


                        String code = forecastArrayList.get(i).getCode().toString();
                        String date = forecastArrayList.get(i).getDate().toString();
                        String day = forecastArrayList.get(i).getDay().toString();
                        String high = forecastArrayList.get(i).getHigh().toString();
                        String low = forecastArrayList.get(i).getLow().toString();
                        String text = forecastArrayList.get(i).getText().toString();

                        forecastModelClass =new ForecastModelClass(code,date,day,high,low,text);

//                        Toast.makeText( getActivity(), ""+forecast, Toast.LENGTH_SHORT).show();
                        forecastModelClassArrayList.add(forecastModelClass);
//                        customAdapter.notifyDataSetChanged();


                        Log.d("forecast",String.valueOf(forecastModelClassArrayList.get(i).getDate()));

                    }
                    myAdapter = new ForecastCustomAdapter(getActivity().getApplicationContext(),forecastModelClassArrayList);
                    forecastList.setAdapter(myAdapter);

                }
            }

            @Override
            public void onFailure(Call<WeatherModelResponse> call, Throwable t) {

            }
        });

    }
}
