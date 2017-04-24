package com.example.mdjahirulislam.weatherapptest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyItemClickListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener,
        CurrentWeatherFragment.SendWeatherCondition{


    private static final String TAG = MainActivity.class.getSimpleName();
    private ImageView imageCode;
    private String cityName="dhaka";
    private String currentCity = "Dhaka";
    private String searchCity ="";
    private String date;


    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private Geocoder geocoder;
    private List<Address> addressList;

    private TabsPagerAdapter tabsPagerAdapter;
    private ViewPager viewPager;
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu, menu);
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                searchCity = query;
//                currentCity = searchCity;
//                Log.d(TAG,"search country : "+currentCity);
//                viewPager.setAdapter(tabsPagerAdapter);
//                tabLayout.setupWithViewPager(viewPager);
//                return true;
//
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//        return super.onCreateOptionsMenu(menu);
//    }
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu, menu);
    MenuItem item = menu.findItem(R.id.action_search);
//    SearchView searchView = (SearchView) item.getActionView();
    android.widget.SearchView searchView = (android.widget.SearchView) item.getActionView();
    searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
                searchCity = query;
                currentCity = searchCity;
                Log.d(TAG,"search country : "+currentCity);
            Toast.makeText(MainActivity.this, ""+currentCity, Toast.LENGTH_SHORT).show();
                viewPager.setAdapter(tabsPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);
            return false;
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
        Log.d("currentCity ",currentCity);
        return currentCity;
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
        try {
            addressList = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);


            cityName = addressList.get(0).getLocality();
            Log.d(TAG,"image code"+cityName.toString());
            setTitle("\n"+cityName+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Void getWeatherCondition(String condition) {

        Log.d("condition",condition);


        this.toDayCondition = condition;

        if (toDayCondition.equals("Thunderstorms")) {
            linearLayout.setBackground(getResources().getDrawable(R.drawable.black_bg));


        }
        return null;
    }


}
