package com.example.mdjahirulislam.weatherapptest;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener,
        CurrentWeatherFragment.SendWeatherCondition,MyItemClickListener{


    private static final String TAG = MainActivity.class.getSimpleName();
    private ImageView imageCode;
    private String cityName="dhaka";
    private String searchCountry="Dhaka";
    private String searchCity="Dhaka";
    private String date;


    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private Geocoder geocoder;
    private List<Address> addressList;

    private TabsPagerAdapter tabsPagerAdapter;
    private ViewPager viewPager;
    private android.support.v7.app.ActionBar actionBar;
    private Bundle bundle;
    private CurrentWeatherFragment countryDetails;
    private LinearLayout linearLayout;
    private String toDayCondition;
    private TabLayout tabLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        linearLayout = (LinearLayout) findViewById(R.id.mainLayout);
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);


        tabLayout.addTab(tabLayout.newTab().setText("To Day"));
        tabLayout.addTab(tabLayout.newTab().setText("Details"));
        tabLayout.addTab(tabLayout.newTab().setText("Forecast"));
        tabLayout.setTabTextColors(Color.parseColor("#000000"),Color.parseColor("#ffffff"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        tabsPagerAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(tabsPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        geocoder = new Geocoder(this);

        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

//        googleApiClient.connect();
//        getResponse(cityName);

//        myItemClickListener = (MyItemClickListener) context;

        Log.d(TAG,"cityName "+cityName.toString());



    }

    @Override
    protected void onStart() {
        googleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onPause() {
        googleApiClient.disconnect();
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchCountry=query;
                searchCity=searchCountry;
                Log.d(TAG,"search country : "+searchCity.toString());
                viewPager.setAdapter(tabsPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);
                return true;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public String getCountry() {
        Log.d("Enu",searchCity);
        return searchCity;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = LocationRequest.create()
                .setInterval(1000)
                .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {

//        latitudeTV.setText("Latitude : "+String.valueOf(location.getLatitude()));
//        longitudeTV.setText("Longitude : "+String.valueOf(location.getLongitude()));

        try {
            addressList = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);


            cityName = addressList.get(0).getLocality();
            Log.d(TAG,"image code"+cityName.toString());
            setTitle("\n"+cityName+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    @Override
//    public void getCountry(String item) {
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        CurrentWeatherFragment countryDetails = new CurrentWeatherFragment();
//
//        Bundle bundle = new Bundle();
//        bundle.putString("cName",searchCountry);
//        countryDetails.setArguments(bundle);
//
//        ft.replace(R.id.pager,countryDetails);
//        ft.addToBackStack(null);
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//        ft.commit();
//    }

    @Override
    public Void getWeatherCondition(String condition) {

        Log.d("condition",condition);


        this.toDayCondition = condition;

        if (toDayCondition.equals("Thunderstorms")) {
            linearLayout.setBackground(getResources().getDrawable(R.drawable.thunderstorm));


        }
        return null;
    }


}
