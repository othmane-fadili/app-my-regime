package com.Othmane_Youness.my_regime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;

public class imcActivity extends AppCompatActivity {

    Button goToRegimeBut;
    TextView imc,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        imc.findViewById(R.id.imc);
        result.findViewById(R.id.result);
        goToRegimeBut.findViewById(R.id.goToRegimeBut);

        float poids=125;
        float taille=156;
        float age=156;
        String resultValue;

        float imcValue=poids/(taille*taille);



        imc.setText(String.valueOf(imcValue));
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
        goToRegimeBut.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("go to regime");
            }
        });
    }
}