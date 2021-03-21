package com.Othmane_Youness.my_regime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        if (!"".equals(imcCategory)) {
            switch (imcCategory) {
                case "1":
                    regimeTitle.setText("Régime hypercalorique pour prendre du poids");
                    listOfRegimes=new ArrayList<String>(Arrays.asList(
                            "-Consommer des aliments à densité énergétique élevée",
                            "-Stimuler l'appétit",
                            "-Faire des collations",
                            "-Eviter les produits à densité énergétique faible et allégés",
                            "-Pratiquer une activité physique d'intensité modérée"
                            )) ;
                    break;
                case "2":
                    regimeTitle.setText("Régime alimentaires pour garder la ligne et rester en bonne santé");
                    listOfRegimes=new ArrayList<String>(Arrays.asList(
                            "-Surveiller son poids et pratiquer une activité physique",
                            "-Consommer davantage de bonnes graisses",
                            "-Manger plus de céréales complètes",
                            "-Choisir de bonnes sources de protéine",
                            "-Manger des fruits et des légumes en quantité"
                    )) ;
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