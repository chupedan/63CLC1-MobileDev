package com.diemminhtri.dictionary;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diemminhtri.dictionary.Adapters.MeaningAdapter;
import com.diemminhtri.dictionary.Adapters.PhoneticAdapter;
import com.diemminhtri.dictionary.Modules.APIResponse;
import com.google.firebase.auth.FirebaseAuth;

public class MainDictionary extends AppCompatActivity {
    SearchView search_view;
    TextView tv_word;
    RecyclerView recycler_phonetics, recycler_meanings;
    ProgressDialog progressDialog;
    PhoneticAdapter phoneticAdapter;
    MeaningAdapter meaningAdapter;
    Button btnLogout;
    private MediaPlayer mediaPlayer; // Thêm biến MediaPlayer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dictionary);

        search_view = findViewById(R.id.search_view);
        tv_word = findViewById(R.id.tv_word);
        btnLogout = findViewById(R.id.btn_logout);
        recycler_phonetics = findViewById(R.id.recycler_phonetics);
        recycler_meanings = findViewById(R.id.recycler_meanings);
        progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Loading...");
        progressDialog.show();
        RequestManager manager = new RequestManager(MainDictionary.this);
        manager.getWordMeaning(listener, "hello");

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                playSound(); // Phát âm thanh khi người dùng ấn nút tìm kiếm

                progressDialog.setTitle("Fetching response for " + query);
                // Khi bấm tìm kiếm sẽ hiện Feetching response for + từ muốn tìm
                progressDialog.show();

                // Gửi yêu cầu lấy nghĩa của từ đến API thông qua RequestManager
                RequestManager manager = new RequestManager(MainDictionary.this);
                manager.getWordMeaning(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playByeSound();
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void playByeSound() {
        MediaPlayer bye = MediaPlayer.create(MainDictionary.this, R.raw.bye);
        if (bye != null) {
            bye.start();
            bye.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    // Giải phóng tài nguyên khi âm thanh hoàn thành
                    mp.release();
                }
            });
        }
    }
    private void playSound() {
        MediaPlayer ok = MediaPlayer.create(MainDictionary.this, R.raw.ok);
        if (ok != null) {
            ok.start();
            ok.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    // Giải phóng tài nguyên khi âm thanh hoàn thành
                    mp.release();
                }
            });
        }
    }

    private final  OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void onFetchData(APIResponse apiResponse, String message) {
            progressDialog.dismiss();
            if (apiResponse == null) {
                Toast.makeText(MainDictionary.this, "No data", Toast.LENGTH_SHORT).show();
                return;
            }
            showData(apiResponse);
        }

        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainDictionary.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showData(APIResponse apiResponse) {
        tv_word.setText("Word: " + apiResponse.getWord());
        recycler_phonetics.setHasFixedSize(true);
        recycler_phonetics.setLayoutManager(new GridLayoutManager(this, 1));
        phoneticAdapter = new PhoneticAdapter(this, apiResponse.getPhonetics());
        recycler_phonetics.setAdapter(phoneticAdapter);

        recycler_meanings.setHasFixedSize(true);
        recycler_meanings.setLayoutManager(new GridLayoutManager(this, 1));
        meaningAdapter = new MeaningAdapter(this, apiResponse.getMeanings());
        recycler_meanings.setAdapter(meaningAdapter);

    }

}