package com.Othmane_Youness.my_regime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class imcActivity extends AppCompatActivity {

    Button goToRegimeBut;
    TextView imc;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        imc=findViewById(R.id.imcText);
        result=findViewById(R.id.result);
        goToRegimeBut=findViewById(R.id.goToRegimeBut);

        Intent intent = getIntent();
        String poids=intent.getStringExtra("poids");
        String taille=intent.getStringExtra("taille");
        String age=intent.getStringExtra("age");

        System.out.println(poids);
        String resultValue;

        double imcValue=Double.parseDouble(poids)/(Double.parseDouble(taille)*Double.parseDouble(taille));

        DecimalFormat df2 = new DecimalFormat("#.##");
        imc.setText(String.valueOf(df2.format(imcValue)));
        if(imcValue<18.5)
            resultValue="Vous êtes en Insuffisance pondérale (maigreur)";
        else if(imcValue<25)
            resultValue="Vous êtes dans une Corpulence normale";
        else if(imcValue<30)
            resultValue="Vous êtes en surpoids";
        else if(imcValue<35)
            resultValue="Vous êtes dans une obésité modérée";
        else if(imcValue<40)
            resultValue="Vous êtes dans une obésité sévère";
        else
            resultValue="Vous êtes dans une obésité morbide ou massive";

        result.setText(resultValue);
        goToRegimeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("go to regime");
            }
        });
    }
}