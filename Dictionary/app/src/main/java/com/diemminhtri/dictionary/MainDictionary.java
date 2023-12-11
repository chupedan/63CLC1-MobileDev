package com.diemminhtri.dictionary;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

public class MainDictionary extends AppCompatActivity {
    SearchView search_view;
    TextView tv_word;
    RecyclerView recycler_phonetics, recycler_meanings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dictionary);

        search_view = findViewById(R.id.search_view);
        tv_word = findViewById(R.id.tv_word);
        recycler_phonetics = findViewById(R.id.recycler_phonetics);
        recycler_meanings = findViewById(R.id.recycler_meanings);
    }
}