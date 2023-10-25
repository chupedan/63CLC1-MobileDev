package com.diemminhtri.a63131545_thigiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Cau4Activity extends AppCompatActivity {
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau4);
        btnBack = findViewById(R.id.btnBack);
    }
    public void back(View v) {
        Intent myIntent = new Intent(Cau4Activity.this, MainActivity.class);
        startActivity(myIntent);
    }
}
