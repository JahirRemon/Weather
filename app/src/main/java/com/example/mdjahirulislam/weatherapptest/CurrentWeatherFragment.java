package com.example.mdjahirulislam.weatherapptest;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CurrentWeatherFragment extends Fragment {


    private static final String TAG = CurrentWeatherFragment.class.getSimpleName();
    private final String BASE_URL = "https://query.yahooapis.com/";
    private final String IMAGE_CODE_URL = "http://fullnightfun.com/weather_icon/";

    private WeatherApi weatherApi;
    private TextView toDaysWeatherConditionTV;
    private TextView maxTempTV;
    private TextView minTempTV;
    private TextView tempTV;
    private TextView currentLocation;

    private ImageView imageCode;
    private String cityName;
    private String date;
    private SendWeatherCondition send;

    private MyItemClickListener myItemClickListener;

    public CurrentWeatherFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current_weather, container, false);


        toDaysWeatherConditionTV = (TextView) view.findViewById(R.id.toDaysConditionTV);
        imageCode = (ImageView) view.findViewById(R.id.imageCode);
        maxTempTV = (TextView) view.findViewById(R.id.maxTempTV);
        minTempTV = (TextView) view.findViewById(R.id.minTempTV);
        tempTV = (TextView) view.findViewById(R.id.tempTV);
        currentLocation = (TextView) view.findViewById(R.id.currentLocation);


        myItemClickListener = new MainActivity();
        cityName = myItemClickListener.getCountry();


        Log.d(TAG,"current rj"+cityName.toString());


        return view;



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getResponse(cityName);

//        Log.d("current rj",getArguments().getString("cityName","null"));


    }

    @Override
    public void onStart() {
        super.onStart();
//        cityName = getArguments().getString("cName");
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
                    String toDayText = weatherModelResponse.getQuery().getResults().getChannel().getItem().getCondition().getText();
                    String temp = weatherModelResponse.getQuery().getResults().getChannel().getItem().getCondition().getTemp();
                    String max = weatherModelResponse.getQuery().getResults().getChannel().getItem().getForecast().get(0).getHigh();
                    String min = weatherModelResponse.getQuery().getResults().getChannel().getItem().getForecast().get(0).getLow();
                    String imgCode = weatherModelResponse.getQuery().getResults().getChannel().getItem().getCondition().getCode();
                    String city = weatherModelResponse.getQuery().getResults().getChannel().getLocation().getCity();
                    date = weatherModelResponse.getQuery().getResults().getChannel().getItem().getForecast().get(0).getDate();

                    send.getWeatherCondition(toDayText);

//                    Log.d("image code",imgCode.toString());
//                    Log.d("image code",date.toString());

                    Context context= imageCode.getContext();
                    Uri fileUri= Uri.parse(IMAGE_CODE_URL+imgCode+".gif");
                    Picasso.with(context).load(fileUri).into(imageCode);

                    toDaysWeatherConditionTV.setText(toDayText);
                    maxTempTV.setText("↑ "+ CommuneClass.Fahrenheit_Celsius(max) +"°");
                    minTempTV.setText("↓ "+ CommuneClass.Fahrenheit_Celsius(min) +"°");
                    tempTV.setText(CommuneClass.Fahrenheit_Celsius(temp)+"°");

                    currentLocation.setText("Current Location in "+city);

                }
            }

            @Override
            public void onFailure(Call<WeatherModelResponse> call, Throwable t) {

                Toast.makeText(getActivity().getApplicationContext(), "Connection Faild", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public interface SendWeatherCondition{
        Void getWeatherCondition(String condition);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            send = (SendWeatherCondition) activity;
        } catch(ClassCastException e) {
            throw  new ClassCastException("Musisz zaimplementowac metode sendData");
        }
    }

}
