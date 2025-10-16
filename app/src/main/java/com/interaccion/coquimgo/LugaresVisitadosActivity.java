package com.interaccion.coquimgo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.HashSet;
import java.util.Set;

public class LugaresVisitadosActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private Spinner spinnerFiltro;

    private CardView cardfuertelambert, cardcruztercermilenio, cardpueblitopeñuelas,
            cardavenidadelmar, cardlamezquita, cardelfaro, cardparquejapones;

    private Set<String> lugaresVisitados = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares_visitados);

        // 🔹 Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 🔹 Navigation Drawer
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        spinnerFiltro = findViewById(R.id.spinnerFiltro);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        // 🔹 Referencias a las CardViews
        cardfuertelambert = findViewById(R.id.cardfuertelambert);
        cardcruztercermilenio = findViewById(R.id.cardcruztercermilenio);
        cardpueblitopeñuelas = findViewById(R.id.cardpueblitopeñuelas);
        cardavenidadelmar = findViewById(R.id.cardavenidadelmar);
        cardlamezquita = findViewById(R.id.cardlamezquita);
        cardelfaro = findViewById(R.id.cardelfaro);
        cardparquejapones = findViewById(R.id.cardparquejapones);

        // 🔹 Cargar lugares visitados desde SharedPreferences
        SharedPreferences prefs = getSharedPreferences("LugaresPrefs", Context.MODE_PRIVATE);
        lugaresVisitados = prefs.getStringSet("lugaresVisitados", new HashSet<>());

        // 🔹 Mostrar solo los lugares visitados
        actualizarLugaresVisitados();

        // 🔹 Filtro
        spinnerFiltro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = parent.getItemAtPosition(position).toString();
                aplicarFiltro(seleccion);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        // 🔹 Clicks para abrir la información del lugar
        cardfuertelambert.setOnClickListener(v -> abrirInformacionLugar("Fuerte Lambert"));
        cardcruztercermilenio.setOnClickListener(v -> abrirInformacionLugar("Cruz del tercer milenio"));
        cardpueblitopeñuelas.setOnClickListener(v -> abrirInformacionLugar("Pueblito Peñuelas"));
        cardavenidadelmar.setOnClickListener(v -> abrirInformacionLugar("Avenida del mar"));
        cardlamezquita.setOnClickListener(v -> abrirInformacionLugar("La mezquita"));
        cardelfaro.setOnClickListener(v -> abrirInformacionLugar("El faro"));
        cardparquejapones.setOnClickListener(v -> abrirInformacionLugar("Parque japones"));
    }

    // 🔸 Muestra solo las cardviews que estén marcadas como visitadas
    private void actualizarLugaresVisitados() {
        cardfuertelambert.setVisibility(lugaresVisitados.contains("Fuerte Lambert") ? View.VISIBLE : View.GONE);
        cardcruztercermilenio.setVisibility(lugaresVisitados.contains("Cruz del tercer milenio") ? View.VISIBLE : View.GONE);
        cardpueblitopeñuelas.setVisibility(lugaresVisitados.contains("Pueblito Peñuelas") ? View.VISIBLE : View.GONE);
        cardavenidadelmar.setVisibility(lugaresVisitados.contains("Avenida del mar") ? View.VISIBLE : View.GONE);
        cardlamezquita.setVisibility(lugaresVisitados.contains("La mezquita") ? View.VISIBLE : View.GONE);
        cardelfaro.setVisibility(lugaresVisitados.contains("El faro") ? View.VISIBLE : View.GONE);
        cardparquejapones.setVisibility(lugaresVisitados.contains("Parque japones") ? View.VISIBLE : View.GONE);
    }

    // 🔸 Aplica un filtro solo sobre los lugares visibles (visitados)
    private void aplicarFiltro(String filtro) {
        actualizarLugaresVisitados(); // Restablece antes del filtro

        switch (filtro) {
            case "Playa":
                ocultarExcepto("Avenida del mar");
                break;
            case "Cultural":
                ocultarExcepto("Fuerte Lambert", "Cruz del tercer milenio", "Pueblito Peñuelas");
                break;
            case "Religioso":
                ocultarExcepto("La mezquita");
                break;
            case "Parques":
                ocultarExcepto("Parque japones");
                break;
        }
    }

    // 🔸 Oculta todas menos las especificadas, si están marcadas como visitadas
    private void ocultarExcepto(String... visibles) {
        Set<String> visiblesSet = new HashSet<>();
        for (String nombre : visibles) visiblesSet.add(nombre);

        if (!lugaresVisitados.contains("Fuerte Lambert") || !visiblesSet.contains("Fuerte Lambert"))
            cardfuertelambert.setVisibility(View.GONE);
        if (!lugaresVisitados.contains("Cruz del tercer milenio") || !visiblesSet.contains("Cruz del tercer milenio"))
            cardcruztercermilenio.setVisibility(View.GONE);
        if (!lugaresVisitados.contains("Pueblito Peñuelas") || !visiblesSet.contains("Pueblito Peñuelas"))
            cardpueblitopeñuelas.setVisibility(View.GONE);
        if (!lugaresVisitados.contains("Avenida del mar") || !visiblesSet.contains("Avenida del mar"))
            cardavenidadelmar.setVisibility(View.GONE);
        if (!lugaresVisitados.contains("La mezquita") || !visiblesSet.contains("La mezquita"))
            cardlamezquita.setVisibility(View.GONE);
        if (!lugaresVisitados.contains("El faro") || !visiblesSet.contains("El faro"))
            cardelfaro.setVisibility(View.GONE);
        if (!lugaresVisitados.contains("Parque japones") || !visiblesSet.contains("Parque japones"))
            cardparquejapones.setVisibility(View.GONE);
    }

    private void abrirInformacionLugar(String nombreLugar) {
        Intent intent = new Intent(this, InformacionLugarActivity.class);
        intent.putExtra("nombreLugar", nombreLugar);
        intent.putExtra("origen", "lugares_visitados");
        startActivity(intent);
    }

    // 🔸 Navegación Drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_lugares_turisticos) {
            Intent intent = new Intent(this, LugaresTuristicosActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        return false;
    }
}


