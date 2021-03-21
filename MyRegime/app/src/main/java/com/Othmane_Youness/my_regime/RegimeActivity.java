package com.Othmane_Youness.my_regime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RegimeActivity extends AppCompatActivity {

    LinearLayout regimeItems ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regime);

        regimeItems=(LinearLayout) findViewById(R.id.regimeItems);

        addViewToRegime("Consommer des aliments à densité énergétique élevée");
        addViewToRegime("Stimuler l'appétit");
        addViewToRegime("Faire des collations");
        addViewToRegime("Eviter les produits à densité énergétique faible et allégés");
        addViewToRegime("Pratiquer une activité physique d'intensité modérée");
        addViewToRegime("Consommer des aliments à densité énergétique élevée");
        addViewToRegime("Stimuler l'appétit");
        addViewToRegime("Faire des collations");
        addViewToRegime("Eviter les produits à densité énergétique faible et allégés");
        addViewToRegime("Pratiquer une activité physique d'intensité modérée");


        Intent intent = getIntent();
        String name=intent.getStringExtra("name");
        String imcCategory=intent.getStringExtra("imcCategory");
        System.out.println(name+" "+imcCategory);
    }


    private void addViewToRegime(String regimeItem){
        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(0,10,0,10);
        textView.setText(regimeItem);
        regimeItems.addView(textView);
    }
}