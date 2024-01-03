package com.diemminhtri.dictionary;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class AboutMe extends AppCompatActivity {
    ImageButton btnGit;
    Button btnBack;
    String url = "https://github.com/chupedan/63CLC1-MobileDev/tree/master/Dictionary";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        btnGit = findViewById(R.id.btnGit);
        btnBack = findViewById(R.id.btnBack);

        btnGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                finish();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutMe.this, MainDictionary.class);
                startActivity(intent);
                finish();
            }
        });
    }
}