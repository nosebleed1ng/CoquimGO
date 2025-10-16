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
            case "Fuerte Lambert":
                txtNombreLugar.setText("Fuerte Lambert");
                imgLugar.setImageResource(R.drawable.fuertelambert);
                txtDescripcion.setText("destino turístico popular que ofrece vistas panorámicas de la bahía y la ciudad. La estructura original fue restaurada y ampliada por la municipalidad, que le añadió miradores, senderos y zonas de descanso, convirtiéndolo en un espacio recreacional accesible para los visitantes. ");
                txtUbicacion.setText("Ubicación: cerro Castillo del Carmen, en el sector Punta Pelícanos de la ciudad de Coquimbo, Chile");
                txtHorarios.setText("Horarios: Martes a Domingo: 9:45 am - 5:00 pm ");
                txtCostos.setText("Costos: Entrada gratuita");
                break;

            case "Cruz del tercer milenio":
                txtNombreLugar.setText("Cruz Del Tercer Milenio");
                imgLugar.setImageResource(R.drawable.cruztercermilenio);
                txtDescripcion.setText("monumento conmemorativo religioso ubicado en el cerro El Vigía de Coquimbo, Chile. Fue construido con el motivo del jubileo del año 2000 de la Iglesia católica. Su construcción fue iniciada en 1999 y terminada en 2000.");
                txtUbicacion.setText("Ubicación: el cerro El Vigía de Coquimbo, Chile");
                txtHorarios.setText("Horarios: Lunes a Domingo: 9 am - 5 pm");
                txtCostos.setText("Costos: Adultos: $2.500\n" +
                        "Adultos mayores: $1.500\n" +
                        "Niños (6 a 13 años): $1.000\n" +
                        "Niños (hasta 5 años y 11 meses): Gratis\n" +
                        "Personas con discapacidad: Acceso liberado (portando carnet)");
                break;

            case "Pueblito Peñuelas":
                txtNombreLugar.setText("Pueblito Peñuelas");
                imgLugar.setImageResource(R.drawable.pueblitopenuelas);
                txtDescripcion.setText("complejo recreativo en La Serena y Coquimbo que ofrece una gran variedad de actividades para la familia, incluyendo un sector de artesanía, gastronomía (food trucks, restaurantes y bares), zona de juegos infantiles, actividades deportivas y escenarios para eventos. ");
                txtUbicacion.setText("Ubicación: comuna de Coquimbo, en la Región de Coquimbo, Chile.");
                txtHorarios.setText("Horarios: Miercoles a Domingo: 12 pm - 11 pm ");
                txtCostos.setText("Costos: Entrada gratuita");
                break;

            case "Avenida del mar":
                txtNombreLugar.setText("Avenida Del Mar");
                imgLugar.setImageResource(R.drawable.avenidadelmar);
                txtDescripcion.setText("paseo costero que une La Serena y Coquimbo, Chile, ideal para caminar, disfrutar de la playa y la gastronomía ");
                txtUbicacion.setText("Ubicación: conurbación de La Serena y Coquimbo, en Chile");
                txtHorarios.setText("Horarios: siempre abierto");
                txtCostos.setText("Costos: entrada gratuita");
                break;

            case "La mezquita":
                txtNombreLugar.setText("La Mezquita");
                imgLugar.setImageResource(R.drawable.lamezquita);
                txtDescripcion.setText("es un centro cultural que incluye una mezquita y un minarete de 40 metros de altura ");
                txtUbicacion.setText("Ubicación: Los Granados 500, Villa Dominante, Coquimbo");
                txtHorarios.setText("Horarios: Lunes a Domingo: 9 am - 5:45 pm");
                txtCostos.setText("Costos: entrada gratuita");
                break;

            case "El faro":
                txtNombreLugar.setText("El Faro");
                imgLugar.setImageResource(R.drawable.elfaro);
                txtDescripcion.setText(" torre elevada que tiene una luz potente en su parte superior para servir de señal a los navegantes y guiar a los barcos de forma segura durante la noche o en condiciones de baja visibilidad");
                txtUbicacion.setText("Ubicación: Avenida del Mar esquina con Francisco de Aguirre, en la ciudad de La Serena, Chile.");
                txtHorarios.setText("Horarios: Martes a Domingo: 9 am - 2 pm, 2:30 pm - 6 pm");
                txtCostos.setText("Costos: entrada gratuita");
                break;

            case "Parque japones":
                txtNombreLugar.setText("Parque Japones");
                imgLugar.setImageResource(R.drawable.parquejapones);
                txtDescripcion.setText(" es un parque ubicado en la ciudad chilena de La Serena que fue inaugurado en 1994. Su temática está ambientada en Japón y posee diversas especies vegetales y animales de dicho país");
                txtUbicacion.setText("Ubicación: Eduardo de La Barra s/n, La Serena, Coquimbo");
                txtHorarios.setText("Horarios: Martes a Domingo: 10 am - 5:40 pm");
                txtCostos.setText("Costos: Entrada general: $3.000\n" +
                        "Adultos mayores y personas con discapacidad: $2.000\n" +
                        "Niños (hasta 10 años): Gratuito ");
                break;

        }
    }
}