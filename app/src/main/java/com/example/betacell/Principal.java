package com.example.betacell;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity implements View.OnClickListener{


        public CardView cardPresion, cardGlucosa, cardGps, cardAlarma, cardBitacora, cardConsejos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cardPresion = (CardView)findViewById(R.id.presion);
        cardGlucosa = (CardView)findViewById(R.id.glucosa);
        cardGps = (CardView)findViewById(R.id.gps);
        cardAlarma = (CardView)findViewById(R.id.alarma);
        cardBitacora = (CardView)findViewById(R.id.bitacora);
        cardConsejos = (CardView)findViewById(R.id.cosejos);


        cardPresion.setOnClickListener( this);
        cardGlucosa.setOnClickListener( this);
        cardGps.setOnClickListener( this);
        cardAlarma.setOnClickListener( this);
        cardBitacora.setOnClickListener( this);
        cardConsejos.setOnClickListener( this);

    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.presion:
                i = new Intent(this, Presion.class);
                startActivity(i);
                break;
            case R.id.glucosa:
                i = new Intent(this, Glucosa.class);
                startActivity(i);
                break;
            case R.id.gps:
                i = new Intent(this, Maps.class);
                startActivity(i);
                break;
            case R.id.bitacora:
                i = new Intent(this, Bitacora.class);
                startActivity(i);
                break;
            case R.id.alarma:
                i = new Intent(this, Alarma.class);
                startActivity(i);
                break;
            case R.id.cosejos:
                i = new Intent(this, Consejos.class);
                startActivity(i);
                break;
        }
    }
}