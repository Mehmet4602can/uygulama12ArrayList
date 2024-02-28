package com.example.listeuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText eTAd;
    Button ekle;
    ListView lVAd;
    ArrayList<String> liste = new ArrayList<>();
    ArrayAdapter<String>listeAdaptoru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeAdaptoru = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,liste);
        eTAd = findViewById(R.id.eTAd);
        ekle = findViewById(R.id.buttonEkle);
        lVAd = findViewById(R.id.lVAd);

        lVAd.setAdapter(listeAdaptoru);
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ad = eTAd.getText().toString();
                liste.add(ad);
                listeAdaptoru.notifyDataSetChanged();
                eTAd.getText().clear();
            }
        });
        lVAd.setOnItemClickListener((adapterView, view ,i,l)->{
            liste.remove(i);
            listeAdaptoru.notifyDataSetChanged();
        });
    }
}