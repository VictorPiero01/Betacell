package com.example.betacell;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Glucosa extends AppCompatActivity {
    private Spinner sppiner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glucosa);

        sppiner = (Spinner)findViewById(R.id.sppiner);

        String[] opciones = {"Al menos 90 minutos después de la comida", "Ayuno", "Antes de las comidas"};
        ArrayAdapter<String> sppinerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        sppiner.setAdapter(sppinerAdapter);

    }
}