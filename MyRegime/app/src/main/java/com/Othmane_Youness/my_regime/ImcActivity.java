package com.Othmane_Youness.my_regime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ImcActivity extends AppCompatActivity {

    Button goToRegimeBut;
    Button btnQuitter;

    TextView textBonjour;
    TextView imc;
    TextView result;
    String Nom;
    String imcCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        imc=findViewById(R.id.imcText);
        result=findViewById(R.id.result);
        goToRegimeBut=findViewById(R.id.goToRegimeBut);
        btnQuitter = findViewById(R.id.btnQuitter);
        textBonjour=findViewById(R.id.textBonjour);

        Intent intent = getIntent();
        String name=intent.getStringExtra("name");
        String poids=intent.getStringExtra("poids");
        String taille=intent.getStringExtra("taille");
        Nom=name;


        String resultValue;
        double imcValue=Double.parseDouble(poids)/(Double.parseDouble(taille)*Double.parseDouble(taille));
        if(imcValue<18.5){
            resultValue="Vous êtes en Insuffisance pondérale (maigreur)";
            imcCategory="1";
        }
        else if(imcValue<25){
            resultValue="Vous êtes dans une Corpulence normale";
            imcCategory="2";
        }
        else if(imcValue<30){
            resultValue="Vous êtes en surpoids";
            imcCategory="3";
        }
        else if(imcValue<35){
            resultValue="Vous êtes dans une obésité modérée";
            imcCategory="4";
        }
        else if(imcValue<40) {
            resultValue = "Vous êtes dans une obésité sévère";
            imcCategory="5";
        }
        else{
            resultValue="Vous êtes dans une obésité morbide ou massive";
            imcCategory="6";
        }


        DecimalFormat df2 = new DecimalFormat("#.##");
        textBonjour.setText("Bonjour "+name);
        imc.setText(String.valueOf(df2.format(imcValue)));
        result.setText(resultValue);



        goToRegimeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchRegimeActivity();
            }
        });


        btnQuitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchBackActivity();
            }
        });
    }

    private void switchRegimeActivity() {
        Intent switchRegimeActivityIntent = new Intent(getApplicationContext(), RegimeActivity.class);
        switchRegimeActivityIntent.putExtra("name", Nom);
        switchRegimeActivityIntent.putExtra("imcCategory", imcCategory);
        startActivity(switchRegimeActivityIntent);
    }

    private void switchBackActivity() {
        Intent switchBackActivityIntent = new Intent(getApplicationContext(), AcceuilActivity.class);
        startActivity(switchBackActivityIntent);
    }

}