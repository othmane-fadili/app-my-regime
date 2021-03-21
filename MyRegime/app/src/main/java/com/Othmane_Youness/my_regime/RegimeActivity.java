package com.Othmane_Youness.my_regime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class RegimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regime);


        Intent intent = getIntent();
        String name=intent.getStringExtra("name");
        String poids=intent.getStringExtra("imcCategory");
        System.out.println(name+" "+poids);
    }
}