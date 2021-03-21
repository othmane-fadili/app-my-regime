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


    private void addViewsToRegime(ArrayList<String> listOfRegimes){

        for(int i=0;i<listOfRegimes.size();i++){
            TextView textView = new TextView(this);
            textView.setTextSize(20);
            textView.setPadding(0,10,0,10);
            textView.setText(listOfRegimes.get(i));
            regimeItems.addView(textView);
        }

    }

    private void addDietList(String imcCategory){

        ArrayList<String> listOfRegimes;
        Resources res = getResources();
        String[] category1 = res.getStringArray(R.array.Regime1);
        String[] category2 = res.getStringArray(R.array.Regime2);
        String[] category3 = res.getStringArray(R.array.Regime3);
        String[] category4 = res.getStringArray(R.array.Regime4);
        String[] category5 = res.getStringArray(R.array.Regime5);
        String[] category6 = res.getStringArray(R.array.Regime6);



        if (!"".equals(imcCategory)) {
            switch (imcCategory) {
                case "1":
                    regimeTitle.setText(category1[0]);
                    listOfRegimes=new ArrayList<String>(Arrays.asList(category1[1],category1[2],category1[3],category1[4] )) ;
                    break;
                case "2":
                    regimeTitle.setText(category2[0]);
                    listOfRegimes=new ArrayList<String>(Arrays.asList(category2[1],category2[2],category2[3],category2[4] )) ;
                    break;
                case "3":
                    regimeTitle.setText(category3[0]);
                    listOfRegimes=new ArrayList<String>(Arrays.asList(category3[1],category3[2],category3[3],category3[4] )) ;
                    break;
                case "4":
                    regimeTitle.setText(category4[0]);
                    listOfRegimes=new ArrayList<String>(Arrays.asList(category4[1],category4[2],category4[3],category4[4] )) ;
                    break;
                case "5":
                    regimeTitle.setText(category5[0]);
                    listOfRegimes=new ArrayList<String>(Arrays.asList(category5[1],category5[2],category5[3],category5[4] )) ;
                    break;
                case "6":
                    regimeTitle.setText(category6[0]);
                    listOfRegimes=new ArrayList<String>(Arrays.asList(category6[1],category6[2],category6[3],category6[4] )) ;
                    break;
                default:
                    listOfRegimes=new ArrayList<String>();
                    break;
            }

            addViewsToRegime(listOfRegimes);
        }

    }

    private void viewSwitcher(String imcCategory){

        if (!"".equals(imcCategory)) {
            switch (imcCategory) {
                case "1":
                    //addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                case "2":
                    //addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                case "3":
                    //addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                case "4":
                    //addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                case "5":
                    //addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                case "6":
                    //addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                default:       break;
            }
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