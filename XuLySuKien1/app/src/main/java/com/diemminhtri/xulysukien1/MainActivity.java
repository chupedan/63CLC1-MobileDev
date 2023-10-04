package com.diemminhtri.xulysukien1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // B1: Lấy dữ liệu từ 2 editText
    EditText edtUserName, edtUserPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidget();

    }

    void getWidget() {
        // 1.1. Tìm điều khiển cần lấy dữ liệu
        edtUserName = findViewById(R.id.edtUserName);
        edtUserPass = findViewById(R.id.edtUserPass);
    }

    //Code xu ly nhan ok
    public void XuLyLogIn(View v) {

        // B2
        String tenDN = edtUserName.getText().toString();
        String mk = edtUserPass.getText().toString();

        String ketQua;
        if (tenDN.equals("clc1") && mk.equals("1")) {
            ketQua = "ok";
        } else {
            ketQua = "not ok";
        }

        // B3:
        Toast.makeText(this, ketQua, Toast.LENGTH_SHORT).show();
    }
}