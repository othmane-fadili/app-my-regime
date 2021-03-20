package com.Othmane_Youness.my_regime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AcceuilActivity extends AppCompatActivity {

    Button btn1;

    EditText editPoids;
    EditText editTaille;
    EditText editAge;
    String poids;
    String taille;
    String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        editPoids=findViewById(R.id.editPoids);
        editTaille=findViewById(R.id.editTaille);
        editAge=findViewById(R.id.editAge);
        poids=editPoids.getText().toString();
        taille=editTaille.getText().toString();
        age = editAge.getText().toString();

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToIMC();
            }
        });

    }

    private void switchToIMC() {
        Intent switchActivityIntent = new Intent(getApplicationContext(), imcActivity.class);
        switchActivityIntent.putExtra("poids", poids);
        switchActivityIntent.putExtra("taille", taille);
        switchActivityIntent.putExtra("age", age);
        startActivity(switchActivityIntent);
    }
}