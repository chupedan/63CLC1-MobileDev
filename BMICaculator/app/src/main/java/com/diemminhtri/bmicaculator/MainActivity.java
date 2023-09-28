package com.diemminhtri.bmicaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText eTextHeight;
    private EditText eTextWeight;
    private Button btnCal;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eTextHeight = findViewById(R.id.eTextHeight);
        eTextWeight = findViewById(R.id.eTextWeight);
        btnCal = findViewById(R.id.btnCal);
        tvResult = findViewById(R.id.tvResult);

        btnCal.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        double height = Double.parseDouble(eTextHeight.getText().toString());
        double weight = Double.parseDouble(eTextWeight.getText().toString());
        double bmi = calculateBMI(height, weight);
        if (bmi < 18.5) {
            tvResult.setText(String.valueOf(bmi) + "\nUnder Weight");
        } else if (bmi < 25) {
            tvResult.setText(String.valueOf(bmi) + "\nHealthy");
        } else {
            tvResult.setText(String.valueOf(bmi) + "\nOver Weight");
        }
    }

    public double calculateBMI(Double height, Double weight) {
        return weight/(height*0.02);
    }
}