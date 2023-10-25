package com.diemminhtri.a63131545_thigiuaky;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Cau1Activity extends AppCompatActivity {
    EditText soa, sob;
    TextView kq;
    Button btnSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1);
        widget();

    }
    public void widget() {
        soa = findViewById(R.id.etSoa);
        sob = findViewById(R.id.etSob);
        kq = findViewById(R.id.tvKQ);
        btnSum = findViewById(R.id.btnSum);
    }
    public void sum(View v) {
        int numA = Integer.parseInt(soa.getText().toString());
        int numB = Integer.parseInt(sob.getText().toString());

        kq.setText(String.valueOf(numA + numB));
    }
}
