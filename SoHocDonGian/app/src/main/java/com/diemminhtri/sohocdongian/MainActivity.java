package com.diemminhtri.sohocdongian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidget();
    }

    void getWidget() {
        // 1.1. Tìm điều khiển cần lấy dữ liệu
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        tvResult = findViewById(R.id.tvResult);
    }

    public void XuLyCong(View v) {
        int numA = Integer.parseInt(edtA.getText().toString());
        int numB = Integer.parseInt(edtB.getText().toString());

        tvResult.setText(String.valueOf(numA + numB));
    }

    public void XuLyTru(View v) {
        int numA = Integer.parseInt(edtA.getText().toString());
        int numB = Integer.parseInt(edtB.getText().toString());

        tvResult.setText(String.valueOf(numA - numB));
    }

    public void XuLyNhan(View v) {
        int numA = Integer.parseInt(edtA.getText().toString());
        int numB = Integer.parseInt(edtB.getText().toString());

        tvResult.setText(String.valueOf(numA * numB));
    }

    public void XuLyChia(View v) {
        double numA = Double.parseDouble(edtA.getText().toString());
        int numB = Integer.parseInt(edtB.getText().toString());

        if (numB != 0) {
            tvResult.setText(String.valueOf(numA / numB));
        } else {
            tvResult.setText("Số bị chia phải khác 0 mới chia được!");
        }
    }
}