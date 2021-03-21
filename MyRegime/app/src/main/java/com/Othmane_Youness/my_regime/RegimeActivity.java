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
                    regimeTitle.setText("Régime spécial embonpoint");
                    listOfRegimes=new ArrayList<String>(Arrays.asList(
                            "-Evaluer votre faim",
                            "-Manger lentement",
                            "-S'entraîner à déguster un bon repas et à en extraire toutes les saveurs",
                            "-Boire de l'eau pendant le repas",
                            "-Utiliser de nouvelles épices en cuisine pour réveiller le sens du goût"
                    )) ;
                    break;
                case "4":
                    regimeTitle.setText("Régime pour une Obésité modérée");
                    listOfRegimes=new ArrayList<String>(Arrays.asList(
                            "-consommer des aliments à densité énergétique élevée",
                            "-Stimuler l'appétit",
                            "-Faire des colltions",
                            "-Eviter les produits à densité énergétique faible et allégés",
                            "-Pratiquer une activité physique d'intensité modérée"
                    )) ;
                    break;
                case "5":
                    regimeTitle.setText("Prise en charge nutritionnelle d'obésité sévère");
                    listOfRegimes=new ArrayList<String>(Arrays.asList(
                            "-La réduction des apports énergétiques",
                            "-se consacrer au repas, être attentif à son assiette",
                            "-cuisiner si possible soi-même ou indiquer clairement les consignes à la personne qui cuisine",
                            "-avorise la perte de poids et préserve la masse maigre",
                            "-limiter l’utilisation de matière grasse pour la cuisson"
                    )) ;
                    break;
                case "6":
                    regimeTitle.setText("Prise en charge nutritionnelle d'obésité morbide");
                    listOfRegimes=new ArrayList<String>(Arrays.asList(
                            "-Bien dormir ",
                            "-Le thé vert",
                            "-La douche froide",
                            "-Manger froid",
                            "-Boire avant de manger"
                    )) ;
                    break;
                default:
                    listOfRegimes=new ArrayList<String>();
                    break;
            }

            addViewToRegime(listOfRegimes);
        }



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


    private void addViewToRegime(ArrayList<String> listOfRegimes){

        for(int i=0;i<listOfRegimes.size();i++){
            TextView textView = new TextView(this);
            textView.setTextSize(20);
            textView.setPadding(0,10,0,10);
            textView.setText(listOfRegimes.get(i));
            regimeItems.addView(textView);
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