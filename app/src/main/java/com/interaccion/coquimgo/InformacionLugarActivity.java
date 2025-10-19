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
import java.util.Locale;
import java.util.Set;

public class InformacionLugarActivity extends AppCompatActivity {

    private ImageView imgLugar;
    private TextView txtNombreLugar, txtDescripcion, txtUbicacion, txtHorarios, txtCostos;
    private Button btnVolver, btnMarcarVisitado, btnMarcarFavorito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Aplicar idioma guardado antes del layout
        SharedPreferences prefsConfig = getSharedPreferences("config", MODE_PRIVATE);
        String idioma = prefsConfig.getString("idioma", "es");
        LocaleHelper.setLocale(this, idioma);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_lugar);

        // Referencias al layout
        imgLugar = findViewById(R.id.imglugar);
        txtNombreLugar = findViewById(R.id.txtnombreLugar);
        txtDescripcion = findViewById(R.id.txtdescripcion);
        txtUbicacion = findViewById(R.id.txtubicacion);
        txtHorarios = findViewById(R.id.txthorarios);
        txtCostos = findViewById(R.id.txtcostos);
        btnVolver = findViewById(R.id.btnvolver);
        btnMarcarVisitado = findViewById(R.id.btnmarcarvisitado);
        btnMarcarFavorito = findViewById(R.id.btnmarcarfavorito);

        // Textos traducibles
        btnVolver.setText(getString(R.string.volver));
        btnMarcarVisitado.setText(getString(R.string.visitado));
        btnMarcarFavorito.setText(getString(R.string.favorito));

        // Detectar origen
        String origen = getIntent().getStringExtra("origen");

        btnVolver.setOnClickListener(v -> {
            if ("lugares_visitados".equals(origen)) {
                startActivity(new Intent(this, LugaresVisitadosActivity.class));
            } else if ("lugares_favoritos".equals(origen)) {
                startActivity(new Intent(this, LugaresFavoritosActivity.class));
            } else {
                startActivity(new Intent(this, LugaresTuristicosActivity.class));
            }
            finish();
        });

        // Nombre del lugar
        String nombreLugar = getIntent().getStringExtra("nombreLugar");
        if (nombreLugar != null) {
            cargarInformacionLugar(nombreLugar.trim().toLowerCase(Locale.ROOT));
            actualizarTextoBotonVisitado(nombreLugar);
            actualizarTextoBotonFavorito(nombreLugar);
        }

        btnMarcarVisitado.setOnClickListener(v -> toggleVisitado(nombreLugar));
        btnMarcarFavorito.setOnClickListener(v -> toggleFavorito(nombreLugar));
    }

    private void cargarInformacionLugar(String nombreLugar) {
        switch (nombreLugar) {
            case "fuerte lambert":
                imgLugar.setImageResource(R.drawable.fuertelambert);
                txtNombreLugar.setText(getString(R.string.txtfuertelambert));
                txtDescripcion.setText(getString(R.string.desc_fuertelambert));
                txtUbicacion.setText(getString(R.string.ubi_fuertelambert));
                txtHorarios.setText(getString(R.string.hor_fuertelambert));
                txtCostos.setText(getString(R.string.cost_fuertelambert));
                break;

            case "cruz del tercer milenio":
                imgLugar.setImageResource(R.drawable.cruztercermilenio);
                txtNombreLugar.setText(getString(R.string.txtcruzdeltercermilenio));
                txtDescripcion.setText(getString(R.string.desc_cruz));
                txtUbicacion.setText(getString(R.string.ubi_cruz));
                txtHorarios.setText(getString(R.string.hor_cruz));
                txtCostos.setText(getString(R.string.cost_cruz));
                break;

            case "pueblito peñuelas":
                imgLugar.setImageResource(R.drawable.pueblitopenuelas);
                txtNombreLugar.setText(getString(R.string.txtpueblitopeñuelas));
                txtDescripcion.setText(getString(R.string.desc_pueblito));
                txtUbicacion.setText(getString(R.string.ubi_pueblito));
                txtHorarios.setText(getString(R.string.hor_pueblito));
                txtCostos.setText(getString(R.string.cost_pueblito));
                break;

            case "avenida del mar":
                imgLugar.setImageResource(R.drawable.avenidadelmar);
                txtNombreLugar.setText(getString(R.string.txtavenidadelmar));
                txtDescripcion.setText(getString(R.string.desc_mar));
                txtUbicacion.setText(getString(R.string.ubi_mar));
                txtHorarios.setText(getString(R.string.hor_mar));
                txtCostos.setText(getString(R.string.cost_mar));
                break;

            case "la mezquita":
                imgLugar.setImageResource(R.drawable.lamezquita);
                txtNombreLugar.setText(getString(R.string.txtlamezquita));
                txtDescripcion.setText(getString(R.string.desc_mezquita));
                txtUbicacion.setText(getString(R.string.ubi_mezquita));
                txtHorarios.setText(getString(R.string.hor_mezquita));
                txtCostos.setText(getString(R.string.cost_mezquita));
                break;

            case "el faro":
                imgLugar.setImageResource(R.drawable.elfaro);
                txtNombreLugar.setText(getString(R.string.txtelfaro));
                txtDescripcion.setText(getString(R.string.desc_faro));
                txtUbicacion.setText(getString(R.string.ubi_faro));
                txtHorarios.setText(getString(R.string.hor_faro));
                txtCostos.setText(getString(R.string.cost_faro));
                break;

            case "parque japonés":
            case "parque japones":
                imgLugar.setImageResource(R.drawable.parquejapones);
                txtNombreLugar.setText(getString(R.string.txtparquejapones));
                txtDescripcion.setText(getString(R.string.desc_parque));
                txtUbicacion.setText(getString(R.string.ubi_parque));
                txtHorarios.setText(getString(R.string.hor_parque));
                txtCostos.setText(getString(R.string.cost_parque));
                break;

            default:
                imgLugar.setImageResource(android.R.drawable.ic_dialog_alert);
                txtNombreLugar.setText(getString(R.string.app_name));
                txtDescripcion.setText(getString(R.string.no_info));
                txtUbicacion.setText("");
                txtHorarios.setText("");
                txtCostos.setText("");
                break;
        }
    }

    private boolean estaVisitado(String nombreLugar) {
        SharedPreferences prefs = getSharedPreferences("LugaresPrefs", Context.MODE_PRIVATE);
        return prefs.getStringSet("lugaresVisitados", new HashSet<>()).contains(nombreLugar);
    }

    private void toggleVisitado(String nombreLugar) {
        SharedPreferences prefs = getSharedPreferences("LugaresPrefs", Context.MODE_PRIVATE);
        Set<String> visitados = new HashSet<>(prefs.getStringSet("lugaresVisitados", new HashSet<>()));

        if (visitados.contains(nombreLugar)) {
            visitados.remove(nombreLugar);
            Toast.makeText(this, getString(R.string.eliminarVisitado), Toast.LENGTH_SHORT).show();
        } else {
            visitados.add(nombreLugar);
            Toast.makeText(this, getString(R.string.visitado), Toast.LENGTH_SHORT).show();
        }

        prefs.edit().putStringSet("lugaresVisitados", visitados).apply();
        actualizarTextoBotonVisitado(nombreLugar);
    }

    private void actualizarTextoBotonVisitado(String nombreLugar) {
        btnMarcarVisitado.setText(estaVisitado(nombreLugar)
                ? getString(R.string.eliminarVisitado)
                : getString(R.string.visitado));
    }

    private boolean estaFavorito(String nombreLugar) {
        SharedPreferences prefs = getSharedPreferences("LugaresPrefs", Context.MODE_PRIVATE);
        return prefs.getStringSet("lugaresFavoritos", new HashSet<>()).contains(nombreLugar);
    }

    private void toggleFavorito(String nombreLugar) {
        SharedPreferences prefs = getSharedPreferences("LugaresPrefs", Context.MODE_PRIVATE);
        Set<String> favoritos = new HashSet<>(prefs.getStringSet("lugaresFavoritos", new HashSet<>()));

        if (favoritos.contains(nombreLugar)) {
            favoritos.remove(nombreLugar);
            Toast.makeText(this, getString(R.string.eliminarFavorito), Toast.LENGTH_SHORT).show();
        } else {
            favoritos.add(nombreLugar);
            Toast.makeText(this, getString(R.string.favorito), Toast.LENGTH_SHORT).show();
        }

        prefs.edit().putStringSet("lugaresFavoritos", favoritos).apply();
        actualizarTextoBotonFavorito(nombreLugar);
    }

    private void actualizarTextoBotonFavorito(String nombreLugar) {
        btnMarcarFavorito.setText(estaFavorito(nombreLugar)
                ? getString(R.string.eliminarFavorito)
                : getString(R.string.favorito));
    }
}

