package com.diemminhtri.a63131545_thigiuaky;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Cau3Activity extends AppCompatActivity {
    View lastTouchedView;
    ArrayList<Player> dsCT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau3);

        dsCT = new ArrayList<>();

        Player player1 = new Player("Henry", "henry", 100);
        Player player2 = new Player("Campbell", "campbell", 10);
        Player player3 = new Player("Odegaard", "odegaard", 50);

        dsCT.add(player1);
        dsCT.add(player2);
        dsCT.add(player3);

        // tao dieu khien
        ListView lvCT = findViewById(R.id.lvPlayer);

        // Tao adapter
        PlayerArrayAdapter adapter;
        adapter = new PlayerArrayAdapter(dsCT, this);

        // Gan adapter
        lvCT.setAdapter(adapter);

        lvCT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // Kiểm tra xem lastTouchedView có tồn tại hay không
                if (lastTouchedView != null) {
                    lastTouchedView.setBackgroundColor(Color.WHITE);
                }

                // Đặt màu nền của mục mới được chọn
                view.setBackgroundColor(Color.CYAN);
                lastTouchedView = view;

                String mucChon = dsCT.get(i).getPlayerName().toString();

                String chuoiThongBao = "Bạn đã chọn: " + mucChon;
                Toast.makeText(Cau3Activity.this, chuoiThongBao, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
