package com.interaccion.coquimgo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InformacionLugarActivity extends AppCompatActivity {
//declaramos los objetos
    private ImageView imgLugar;
    private TextView txtNombreLugar, txtDescripcion, txtUbicacion, txtHorarios, txtCostos;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_lugar);

        // concectamos los componentes al xml
        imgLugar = findViewById(R.id.imgLugar);
        txtNombreLugar = findViewById(R.id.txtNombreLugar);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtUbicacion = findViewById(R.id.txtUbicacion);
        txtHorarios = findViewById(R.id.txtHorarios);
        txtCostos = findViewById(R.id.txtCostos);
        btnVolver = findViewById(R.id.btnVolver);

        // boton para volver a lugares turisticos
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverIntent = new Intent(InformacionLugarActivity.this, LugaresTuristicosActivity.class);
                startActivity(volverIntent);
                finish();
            }
        });

        // obtenemos el nombre del lugar desde el intent
        String nombreLugar = getIntent().getStringExtra("nombreLugar");

        // informacion del lugar seleccionado
        switch (nombreLugar) {
            case "La Serena":
                txtNombreLugar.setText("La Serena");
                imgLugar.setImageResource(R.drawable.laserena);
                txtDescripcion.setText("La Serena es conocida por sus playas, su faro icónico y su arquitectura colonial. Es uno de los principales destinos turísticos del norte de Chile.");
                txtUbicacion.setText("Ubicación: Región de Coquimbo, Chile");
                txtHorarios.setText("Horarios: Abierto todo el dia");
                txtCostos.setText("Costos: Entrada gratuita");
                break;

            case "Coquimbo":
                txtNombreLugar.setText("Coquimbo");
                imgLugar.setImageResource(R.drawable.coquimbo);
                txtDescripcion.setText("Coquimbo destaca por su puerto, la Cruz del Tercer Milenio y su vida nocturna. Es el corazón cultural y pesquero de la región.");
                txtUbicacion.setText("Ubicación: Región de Coquimbo, Chile");
                txtHorarios.setText("Horarios: Abierto todo el dia");
                txtCostos.setText("Costos: Entrada gratuita");
                break;

        }
    }


}

