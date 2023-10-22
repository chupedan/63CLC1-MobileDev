package com.diemminhtri.testcustomlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Player> dsCT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dsCT = new ArrayList<>();

        Player player1 = new Player("Henry", "henry", 100);
        Player player2 = new Player("Campbell", "campbell", 10);
        Player player3 = new Player("Odegaard", "odegaard", 50);

        dsCT.add(player1);
        dsCT.add(player2);
        dsCT.add(player3);

        // tao dieu khien
        ListView lvCT = findViewById(R.id.listViewPlayer);

        // Tao adapter
        PlayerArrayAdapter adapter;
        adapter = new PlayerArrayAdapter(dsCT, this);

        // Gan adapter
        lvCT.setAdapter(adapter);
    }


}