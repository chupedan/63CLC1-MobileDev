package com.diemminhtri.a63131545_thigiuaky;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Cau2Activity extends AppCompatActivity {
    View lastTouchedView;

    ArrayList<String> dsCT = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2);
        getWidget();

        dsCT.add("Saka");
        dsCT.add("Jesus");
        dsCT.add("Odegaard");
        dsCT.add("Saliba");
        dsCT.add("Martinneli");
        dsCT.add("Rice");
        dsCT.add("Partey");
        dsCT.add("Gabriel");
        dsCT.add("Zinchenko");
        dsCT.add("White");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                dsCT
        );


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

                String mucChon = dsCT.get(i).toString();

                String chuoiThongBao = "Bạn đã chọn: " + mucChon;
                Toast.makeText(Cau2Activity.this, chuoiThongBao, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getWidget() {
        lvCT = findViewById(R.id.lvCT);
    }
    ListView lvCT;
}
