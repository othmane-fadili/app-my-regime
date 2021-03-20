package com.Othmane_Youness.my_regime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AcceuilActivity extends AppCompatActivity {

    Button btn1;

    EditText editPoids= (EditText) findViewById(R.id.editPoids);
    EditText editTaille = (EditText) findViewById(R.id.editTaille);
    EditText editAge= (EditText) findViewById(R.id.editAge);
    String poids = editPoids.getText().toString();
    String taille = editTaille.getText().toString();
    String age = editAge.getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToIMC();
            }
        });

    }

    private void switchToIMC() {
        Intent switchActivityIntent = new Intent(getApplicationContext(), ImcActivity.class);
        switchActivityIntent.putExtra("poids", poids);
        switchActivityIntent.putExtra("taille", taille);
        switchActivityIntent.putExtra("age", age);
        startActivity(switchActivityIntent);
    }
}