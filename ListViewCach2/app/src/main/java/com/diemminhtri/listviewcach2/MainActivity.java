package com.diemminhtri.listviewcach2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] presidents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //================
        ListView lstView = findViewById(R.id.androidList);
        lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstView.setTextFilterEnabled(true);
        presidents = getResources().getStringArray(R.array.presidents_array);
        lstView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked, presidents));
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getBaseContext(),
                        "You have selected " +presidents[position] , Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void buttonOnClick(View view) {
        ListView lstView = findViewById(R.id.androidList);
        String itemsSelected = "Selected items: \n";
        for (int i=0; i<lstView.getCount(); i++) {
            if (lstView.isItemChecked(i)) {
                itemsSelected += lstView.getItemAtPosition(i) + "\n";
            }
        }
        Toast.makeText(this, itemsSelected, Toast.LENGTH_LONG).show();
    }
}