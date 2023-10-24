package com.diemminhtri.viduintent2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity  extends AppCompatActivity {
    TextView tvTen, tvNamSinh;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);
        widget();
        // nhan intent

        Intent myIntent = getIntent();
        if (myIntent != null) {
            String ten = myIntent.getStringExtra("ten");
            tvTen.setText(ten);
            String namSinh  = myIntent.getStringExtra("ns");
            tvNamSinh.setText(namSinh);
        }
        // lay bundle ra khoi intent
//        Bundle bundle = myIntent.getBundleExtra("myPackage");

        // lay du lieu khoi bundle
    }
    public void widget() {
        tvTen = findViewById(R.id.tvTen);
        tvNamSinh = findViewById(R.id.tvNamSinh);
        btnBack = findViewById(R.id.btnBack);
    }


}
