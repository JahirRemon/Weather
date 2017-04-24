package com.example.mdjahirulislam.weatherapptest;

/**
 * Created by mdjahirulislam on 21/04/17.
 */

public class CommuneClass {

    public static int Fahrenheit_Celsius(String  fahrenheit){

        int celsius = 0;
        double frn = Double.parseDouble(fahrenheit);
        celsius = (int) ((frn-32)*(0.5556));
        return celsius;
    }
}
