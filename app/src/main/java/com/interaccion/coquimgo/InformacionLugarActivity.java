package com.interaccion.coquimgo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class InformacionLugarActivity extends AppCompatActivity {

    private ImageView imgLugar;
    private TextView txtNombreLugar, txtDescripcion, txtUbicacion, txtHorarios, txtCostos;
    private Button btnVolver, btnMarcarVisitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_lugar);

        // Referencias al XML
        imgLugar = findViewById(R.id.imglugar);
        txtNombreLugar = findViewById(R.id.txtombreLugar);
        txtDescripcion = findViewById(R.id.txtdescripcion);
        txtUbicacion = findViewById(R.id.txtubicacion);
        txtHorarios = findViewById(R.id.txthorarios);
        txtCostos = findViewById(R.id.txtcostos);
        btnVolver = findViewById(R.id.btnvolver);
        btnMarcarVisitado = findViewById(R.id.btnmarcarvisitado);

        // Botón volver
        Button btnVolver = findViewById(R.id.btnvolver);

        String origen = getIntent().getStringExtra("origen");

        btnVolver.setOnClickListener(v -> {
            if ("lugares_visitados".equals(origen)) {
                Intent intent = new Intent(this, LugaresVisitadosActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, LugaresTuristicosActivity.class);
                startActivity(intent);
            }
            finish();
        });


        // Obtenemos el nombre del lugar
        String nombreLugar = getIntent().getStringExtra("nombreLugar");

        // Cargamos la información del lugar
        switch (nombreLugar) {
            case "Fuerte Lambert":
                txtNombreLugar.setText("Fuerte Lambert");
                imgLugar.setImageResource(R.drawable.fuertelambert);
                txtDescripcion.setText("Destino turístico popular con vistas panorámicas de la bahía y la ciudad.");
                txtUbicacion.setText("Ubicación: Cerro Castillo del Carmen, Coquimbo, Chile");
                txtHorarios.setText("Horarios: Martes a Domingo: 9:45 am - 5:00 pm");
                txtCostos.setText("Costo Entrada: Entrada gratuita");
                break;

            case "Cruz del tercer milenio":
                txtNombreLugar.setText("Cruz del Tercer Milenio");
                imgLugar.setImageResource(R.drawable.cruztercermilenio);
                txtDescripcion.setText("Monumento religioso con vistas a la ciudad de Coquimbo.");
                txtUbicacion.setText("Ubicación: Cerro El Vigía, Coquimbo, Chile");
                txtHorarios.setText("Horarios: Lunes a Domingo: 9 am - 5 pm");
                txtCostos.setText("Costo Entrada: " +
                        "Adultos: $2.500, Niños: $1.000, Gratis menores de 6 años");
                break;

            case "Pueblito Peñuelas":
                txtNombreLugar.setText("Pueblito Peñuelas");
                imgLugar.setImageResource(R.drawable.pueblitopenuelas);
                txtDescripcion.setText("Centro de artesanías, gastronomía y actividades familiares.");
                txtUbicacion.setText("Ubicación: Coquimbo, Chile");
                txtHorarios.setText("Horarios: Miércoles a Domingo: 12 pm - 11 pm");
                txtCostos.setText("Costo Entrada:" +
                        "Entrada gratuita");
                break;

            case "Avenida del mar":
                txtNombreLugar.setText("Avenida del Mar");
                imgLugar.setImageResource(R.drawable.avenidadelmar);
                txtDescripcion.setText("Paseo costero con playas, restaurantes y actividades al aire libre.");
                txtUbicacion.setText("Ubicación: La Serena y Coquimbo, Chile");
                txtHorarios.setText("Horarios: Siempre abierto");
                txtCostos.setText("Entrada gratuita");
                break;

            case "La mezquita":
                txtNombreLugar.setText("La Mezquita");
                imgLugar.setImageResource(R.drawable.lamezquita);
                txtDescripcion.setText("Centro cultural islámico con mirador y arquitectura única.");
                txtUbicacion.setText("Ubicación: Los Granados 500, Coquimbo");
                txtHorarios.setText("Horarios: Lunes a Domingo: 9 am - 5:45 pm");
                txtCostos.setText("Costo Entrada:" +
                        "Entrada gratuita");
                break;

            case "El faro":
                txtNombreLugar.setText("El Faro");
                imgLugar.setImageResource(R.drawable.elfaro);
                txtDescripcion.setText("Símbolo icónico de La Serena con gran vista al mar.");
                txtUbicacion.setText("Ubicación: Avenida del Mar, La Serena, Chile");
                txtHorarios.setText("Horarios: Martes a Domingo: 9 am - 6 pm");
                txtCostos.setText("Costo Entrada:" +
                        "Entrada gratuita");
                break;

            case "Parque japones":
                txtNombreLugar.setText("Parque Japonés");
                imgLugar.setImageResource(R.drawable.parquejapones);
                txtDescripcion.setText("Parque inspirado en la cultura japonesa con jardines y estanques.");
                txtUbicacion.setText("Ubicación: Eduardo de La Barra s/n, La Serena");
                txtHorarios.setText("Horarios: Martes a Domingo: 10 am - 5:40 pm");
                txtCostos.setText("Costo Entrada:" +
                        "Entrada: $3.000 (general)");
                break;
        }

        // Actualizamos el texto del botón según estado visitado
        actualizarTextoBoton(nombreLugar);

        // Configuramos click para marcar o desmarcar como visitado
        btnMarcarVisitado.setOnClickListener(v -> toggleVisitado(nombreLugar));
    }

    // ===== Métodos para manejar visitados =====

    private boolean estaVisitado(String nombreLugar) {
        SharedPreferences prefs = getSharedPreferences("LugaresPrefs", Context.MODE_PRIVATE);
        Set<String> visitados = prefs.getStringSet("lugaresVisitados", new HashSet<>());
        return visitados.contains(nombreLugar);
    }

    private void toggleVisitado(String nombreLugar) {
        SharedPreferences prefs = getSharedPreferences("LugaresPrefs", Context.MODE_PRIVATE);
        Set<String> visitados = prefs.getStringSet("lugaresVisitados", new HashSet<>());
        Set<String> nuevosVisitados = new HashSet<>(visitados);

        if (nuevosVisitados.contains(nombreLugar)) {
            nuevosVisitados.remove(nombreLugar);
            Toast.makeText(this, nombreLugar + " eliminado de visitados", Toast.LENGTH_SHORT).show();
        } else {
            nuevosVisitados.add(nombreLugar);
            Toast.makeText(this, nombreLugar + " marcado como visitado", Toast.LENGTH_SHORT).show();
        }

        prefs.edit().putStringSet("lugaresVisitados", nuevosVisitados).apply();

        actualizarTextoBoton(nombreLugar);
    }

    private void actualizarTextoBoton(String nombreLugar) {
        if (estaVisitado(nombreLugar)) {
            btnMarcarVisitado.setText("Eliminar como visitado");
        } else {
            btnMarcarVisitado.setText("Marcar como visitado");
        }
    }
}

