package com.diemminhtri.customlistview;

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
        //
        dsQG = new ArrayList<>();
        Country qg1 = new Country("VietNam", "vi", 900000);
        Country qg2 = new Country("US", "us", 1000000);
        Country qg3 = new Country("Russia", "ru", 800000);
        dsQG.add(qg1);
        dsQG.add(qg2);
        dsQG.add(qg3);

        // tim dieu khien
        ListView lvQG = findViewById(R.id.lsViewNation);

        // Tao adapter
        CountryArrayAdapter adapter;
        adapter = new CountryArrayAdapter(dsQG, this);

        // Gan adapter
        lvQG.setAdapter(adapter);

        // Xu ly su kien, nhu bai cu

    }
}