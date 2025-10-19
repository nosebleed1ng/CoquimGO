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
<<<<<<< HEAD
import java.util.Locale;
=======
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
import java.util.Set;

public class InformacionLugarActivity extends AppCompatActivity {

    private ImageView imgLugar;
    private TextView txtNombreLugar, txtDescripcion, txtUbicacion, txtHorarios, txtCostos;
<<<<<<< HEAD
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
=======
    private Button btnVolver, btnMarcarVisitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_lugar);

        // Referencias al XML
        imgLugar = findViewById(R.id.imglugar);
        txtNombreLugar = findViewById(R.id.txtombreLugar);
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
        txtDescripcion = findViewById(R.id.txtdescripcion);
        txtUbicacion = findViewById(R.id.txtubicacion);
        txtHorarios = findViewById(R.id.txthorarios);
        txtCostos = findViewById(R.id.txtcostos);
        btnVolver = findViewById(R.id.btnvolver);
        btnMarcarVisitado = findViewById(R.id.btnmarcarvisitado);
<<<<<<< HEAD
        btnMarcarFavorito = findViewById(R.id.btnmarcarfavorito);

        // Textos traducibles
        btnVolver.setText(getString(R.string.volver));
        btnMarcarVisitado.setText(getString(R.string.visitado));
        btnMarcarFavorito.setText(getString(R.string.favorito));

        // Detectar origen
=======

        // Botón volver
        Button btnVolver = findViewById(R.id.btnvolver);

>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
        String origen = getIntent().getStringExtra("origen");

        btnVolver.setOnClickListener(v -> {
            if ("lugares_visitados".equals(origen)) {
<<<<<<< HEAD
                startActivity(new Intent(this, LugaresVisitadosActivity.class));
            } else if ("lugares_favoritos".equals(origen)) {
                startActivity(new Intent(this, LugaresFavoritosActivity.class));
            } else {
                startActivity(new Intent(this, LugaresTuristicosActivity.class));
=======
                Intent intent = new Intent(this, LugaresVisitadosActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, LugaresTuristicosActivity.class);
                startActivity(intent);
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
            }
            finish();
        });

<<<<<<< HEAD
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
=======

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
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
    }

    private void toggleVisitado(String nombreLugar) {
        SharedPreferences prefs = getSharedPreferences("LugaresPrefs", Context.MODE_PRIVATE);
<<<<<<< HEAD
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
=======
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
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
    }
}

