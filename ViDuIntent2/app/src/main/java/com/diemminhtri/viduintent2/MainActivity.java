package com.diemminhtri.viduintent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etTen, etNamSinh;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        widget();
    }
    public void widget() {
        etTen = findViewById(R.id.etTen);
        etNamSinh = findViewById(R.id.etNamSinh);
        btnOk = findViewById(R.id.btnOk);
    }
    public void ShowResult(View v) {
        Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
        String iTen = etTen.getText().toString();
        String iNamSinh = etNamSinh.getText().toString();

        myIntent.putExtra("ten", iTen);
        myIntent.putExtra("ns", iNamSinh);


//        Bundle bundle = new Bundle();
//        bundle.putString("ten", iTen);
//        bundle.putString("namSinh", iNamSinh);

//        iNhap.putExtra("myPackage", bundle);

        startActivity(myIntent);
    }
}