package com.diemminhtri.autocompleteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> COUNTRIES = new ArrayList<>();

    // b0
    AutoCompleteTextView auTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidget();
        // b1 tiếp, đưa dữ liệu vào ds
        COUNTRIES.add("Viet Nam");
        COUNTRIES.add("Australia");
        COUNTRIES.add("England");
        COUNTRIES.add("USA");
        COUNTRIES.add("Thailand");

        // b2
        ArrayAdapter<String> adapterCountries = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line, // bố cục hiển thị
                COUNTRIES // nguồn dữ liệu để hiển thị
        );

        // b3
        auTV.setAdapter(adapterCountries);
    }

    public void getWidget() {
        auTV = findViewById(R.id.autoCompleteCountries);
    }
}