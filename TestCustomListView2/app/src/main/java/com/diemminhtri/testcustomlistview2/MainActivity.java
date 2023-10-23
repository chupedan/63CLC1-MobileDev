package com.diemminhtri.testcustomlistview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Winner> dsJackpot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dsJackpot = new ArrayList<>();

        Winner winner1 = new Winner("Henry", "henry", 1000000);
        Winner winner2 = new Winner("Zidan", "zidan", 9900000);
        Winner winner3 = new Winner("Vieira", "vieira", 9999999);
        Winner winner4 = new Winner("Petit", "petit", 1000);

        dsJackpot.add(winner1);
        dsJackpot.add(winner2);
        dsJackpot.add(winner3);
        dsJackpot.add(winner4);

        ListView lvJackpot = findViewById(R.id.lvJackpot);

        WinnerArrayAdapter adapter;
        adapter = new WinnerArrayAdapter(dsJackpot, this);

        lvJackpot.setAdapter(adapter);
    }
}