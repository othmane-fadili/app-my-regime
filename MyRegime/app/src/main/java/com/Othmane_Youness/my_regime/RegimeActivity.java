package com.Othmane_Youness.my_regime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RegimeActivity extends AppCompatActivity {

    Button btnRetour;
    Button btnQuitter;
    LinearLayout regimeItems ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regime);


        btnRetour=findViewById(R.id.btnRetour);
        btnQuitter = findViewById(R.id.btnQuitter);
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



        if (!"".equals(imcCategory)) {
            switch (imcCategory) {
                case "1":
                    addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                case "2":
                    addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                case "3":
                    addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                case "4":
                    addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                case "5":
                    addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                case "6":
                    addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                default:
                    break;
            }
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


    private void addViewToRegime(String regimeItem){
        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(0,10,0,10);
        textView.setText(regimeItem);
        regimeItems.addView(textView);
    }

    private void viewSwitcher(String imcCategory){

        if (!"".equals(imcCategory)) {
            switch (imcCategory) {
                case "1":
                    addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                case "2":
                    addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                case "3":
                    addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                case "4":
                    addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                case "5":
                    addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                case "6":
                    addViewToRegime("Pratiquer une activité physique d'intensité modérée");
                    break;
                default:
                    break;
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