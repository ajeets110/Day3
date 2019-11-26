package com.example.menuandspinnerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PickerExampleActivity extends AppCompatActivity {

    Spinner spCountries;
    ArrayList<String>countryList;
    String[] countries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_example);


        spCountries = findViewById(R.id.spCountryList);
        countryList = new ArrayList<>();

        //Reading from String.xml file

        //countryList = (ArrayList<String>) Arrays.asList(getResources().getStringArray(R.array.array_country));

        countries = getResources().getStringArray(R.array.array_country);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        spCountries.setAdapter(mAdapter);

        spCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(PickerExampleActivity.this, countries[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
