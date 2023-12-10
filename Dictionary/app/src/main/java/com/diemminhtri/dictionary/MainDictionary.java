package com.diemminhtri.dictionary;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

public class MainDictionary extends AppCompatActivity {
    SearchView search_view;
    TextView tv_word, ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dictionary);
    }
}