package com.Othmane_Youness.my_regime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class RegimeActivity extends AppCompatActivity {

    Button btnRetour;
    Button btnQuitter;
    LinearLayout regimeItems ;
    TextView regimeTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regime);



        btnRetour=findViewById(R.id.btnRetour);
        btnQuitter = findViewById(R.id.btnQuitter);
        regimeItems=(LinearLayout) findViewById(R.id.regimeItems);
        regimeTitle=findViewById(R.id.regimeTitle);

        Intent intent = getIntent();
        String name=intent.getStringExtra("name");
        String imcCategory=intent.getStringExtra("imcCategory");

        addDietList(imcCategory);


        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchRetourActivity();
            }
        });
        btnQuitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchQuitActivity();
            }
        });

    }

    private void changeTextViewRegime(String[] category){
        regimeTitle.setText(category[0]);
        for(int i=1;i<category.length;i++){
            TextView textView = new TextView(this);
            textView.setTextSize(20);
            textView.setPadding(0,10,0,10);
            textView.setText(category[i]);
            regimeItems.addView(textView);
        }

    }

    private void addDietList(String imcCategory){

        String[] wichCategory;
        Resources res = getResources();
        String[] category1,category2,category3,category4, category5,category6;

        if (!"".equals(imcCategory)) {
            switch (imcCategory) {
                case "1":
                    category1 = res.getStringArray(R.array.Regime1);
                    wichCategory=category1;
                    break;
                case "2":
                    category2 = res.getStringArray(R.array.Regime2);
                    wichCategory=category2;
                    break;
                case "3":
                    category3 = res.getStringArray(R.array.Regime3);
                    wichCategory=category3;
                    break;
                case "4":
                    category4 = res.getStringArray(R.array.Regime4);
                    wichCategory=category4;
                    break;
                case "5":
                    category5 = res.getStringArray(R.array.Regime5);
                    wichCategory=category5;
                    break;
                case "6":
                    category6 = res.getStringArray(R.array.Regime6);
                    wichCategory=category6;
                    break;
                default:
                    wichCategory=new String[0];
                    break;
            }

            changeTextViewRegime(wichCategory);
        }

    }

    private void switchRetourActivity() {
        Intent switchRetourActivityIntent = new Intent(getApplicationContext(), ImcActivity.class);
        startActivity(switchRetourActivityIntent);
    }
    private void switchQuitActivity() {
        Intent switchQuitActivityIntent = new Intent(getApplicationContext(), AcceuilActivity.class);
        startActivity(switchQuitActivityIntent);
    }
}