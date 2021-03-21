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
    EditText editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        editPoids=(EditText)findViewById(R.id.editPoids);
        editTaille=(EditText)findViewById(R.id.editTaille);
        editName=(EditText)findViewById(R.id.editName);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToIMC();
            }
        });

    }

    private void switchToIMC() {

        String poids=editPoids.getText().toString().trim();
        String taille=editTaille.getText().toString().trim();
        String name = editName.getText().toString().trim();

        //Checks the inputs.
        if (name.length() == 0)
            editName.setError("Please Enter a valid name!");
        else if (poids.length() == 0 || !(Double.parseDouble(poids) >= 1) || !(Double.parseDouble(poids)<= 200 ))
            editPoids.setError("Please Enter a valid poids!");
        else if (taille.length() == 0 || !(Double.parseDouble(taille) > 0) || !(Double.parseDouble(taille)<= 3 ))
            editTaille.setError("Please Enter a valid taille!");
        else{
            Intent switchActivityIntent = new Intent(getApplicationContext(), ImcActivity.class);
            switchActivityIntent.putExtra("name", name);
            switchActivityIntent.putExtra("poids", poids);
            switchActivityIntent.putExtra("taille", taille);
            startActivity(switchActivityIntent);
        }


    }
}