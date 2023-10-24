package com.diemminhtri.viduintent2;

import android.content.Intent;
import android.os.Bundle;
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
        // lay bundle ra khoi intent
//        Bundle bundle = myIntent.getBundleExtra("myPackage");

        // lay du lieu khoi bundle
        String ten = myIntent.getStringExtra("ten");
        String namSinh = myIntent.getStringExtra("namSinh");

        tvTen.setText(ten);
        tvNamSinh.setText(namSinh);
    }
    public void widget() {
        tvTen = findViewById(R.id.tvTen);
        tvNamSinh = findViewById(R.id.tvNamSinh);
        btnBack = findViewById(R.id.btnBack);
    }


}
