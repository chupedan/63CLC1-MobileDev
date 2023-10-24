package com.diemminhtri.testcustomlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Country> dsQG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dsQG = new ArrayList<>();
        Country country1 = new Country("us", "USA", 100000);
        Country country2 = new Country("ru", "Russia", 100000);
        Country country3 = new Country("vi", "Viet Nam", 100000);

        dsQG.add(country1);
        dsQG.add(country2);
        dsQG.add(country3);

        ListView lvQG = findViewById(R.id.lvQG);

        CountryArrayAdapter adapter = new CountryArrayAdapter(dsQG, this);

        lvQG.setAdapter(adapter);
    }
}