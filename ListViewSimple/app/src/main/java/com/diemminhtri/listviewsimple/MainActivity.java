package com.diemminhtri.listviewsimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //b1
    ArrayList<String> dsNNLT = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidget();
        //b2
        dsNNLT.add("C");
        dsNNLT.add("Java");
        dsNNLT.add("Python");
        dsNNLT.add("Android Java");
        dsNNLT.add("Android Kotlin");

        //b3
        ArrayAdapter<String> adapterNNLT = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_2,
                dsNNLT
        );

        //b3
        lvNNLT.setAdapter(adapterNNLT);
        //b4
        lvNNLT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // code xu ly o day
                // i la vi tri cua item duoc chon
                // lay ve gia tri

                // cach 1
//                String mucChon = adapterNNLT.getItem(i);
//                cach 2
                String mucChon = dsNNLT.get(i).toString();

                String chuoiThongBao = "You selected " + mucChon;
                Toast.makeText(MainActivity.this, chuoiThongBao, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getWidget() {
        lvNNLT = findViewById(R.id.lvNNTL);
    }
    ListView lvNNLT;
}