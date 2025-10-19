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

<<<<<<< HEAD
/**
 * Activity que muestra los lugares visitados por el usuario.
 * - Aplica idioma con LocaleHelper
 * - Filtrado dinámico
 * - Drawer funcional
 * - Carga dinámica desde SharedPreferences
 */
=======
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
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
<<<<<<< HEAD
        SharedPreferences prefsConfig = getSharedPreferences("config", MODE_PRIVATE);
        String idioma = prefsConfig.getString("idioma", "es");
        LocaleHelper.setLocale(this, idioma);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares_visitados);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(getString(R.string.lugaresVisitados));

=======
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares_visitados);

        // 🔹 Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 🔹 Navigation Drawer
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        spinnerFiltro = findViewById(R.id.spinnerFiltro);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

<<<<<<< HEAD
=======
        // 🔹 Referencias a las CardViews
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
        cardfuertelambert = findViewById(R.id.cardfuertelambert);
        cardcruztercermilenio = findViewById(R.id.cardcruztercermilenio);
        cardpueblitopeñuelas = findViewById(R.id.cardpueblitopeñuelas);
        cardavenidadelmar = findViewById(R.id.cardavenidadelmar);
        cardlamezquita = findViewById(R.id.cardlamezquita);
        cardelfaro = findViewById(R.id.cardelfaro);
        cardparquejapones = findViewById(R.id.cardparquejapones);

<<<<<<< HEAD
        SharedPreferences prefs = getSharedPreferences("LugaresPrefs", Context.MODE_PRIVATE);
        lugaresVisitados = prefs.getStringSet("lugaresVisitados", new HashSet<>());

        actualizarLugaresVisitados();

=======
        // 🔹 Cargar lugares visitados desde SharedPreferences
        SharedPreferences prefs = getSharedPreferences("LugaresPrefs", Context.MODE_PRIVATE);
        lugaresVisitados = prefs.getStringSet("lugaresVisitados", new HashSet<>());

        // 🔹 Mostrar solo los lugares visitados
        actualizarLugaresVisitados();

        // 🔹 Filtro
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
        spinnerFiltro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = parent.getItemAtPosition(position).toString();
                aplicarFiltro(seleccion);
            }

            @Override
<<<<<<< HEAD
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        cardfuertelambert.setOnClickListener(v -> abrirInformacionLugar("Fuerte Lambert"));
        cardcruztercermilenio.setOnClickListener(v -> abrirInformacionLugar("Cruz del Tercer Milenio"));
        cardpueblitopeñuelas.setOnClickListener(v -> abrirInformacionLugar("Pueblito Peñuelas"));
        cardavenidadelmar.setOnClickListener(v -> abrirInformacionLugar("Avenida del Mar"));
        cardlamezquita.setOnClickListener(v -> abrirInformacionLugar("La Mezquita"));
        cardelfaro.setOnClickListener(v -> abrirInformacionLugar("El Faro"));
        cardparquejapones.setOnClickListener(v -> abrirInformacionLugar("Parque Japonés"));
    }

    private void actualizarLugaresVisitados() {
        cardfuertelambert.setVisibility(lugaresVisitados.contains("Fuerte Lambert") ? View.VISIBLE : View.GONE);
        cardcruztercermilenio.setVisibility(lugaresVisitados.contains("Cruz del Tercer Milenio") ? View.VISIBLE : View.GONE);
        cardpueblitopeñuelas.setVisibility(lugaresVisitados.contains("Pueblito Peñuelas") ? View.VISIBLE : View.GONE);
        cardavenidadelmar.setVisibility(lugaresVisitados.contains("Avenida del Mar") ? View.VISIBLE : View.GONE);
        cardlamezquita.setVisibility(lugaresVisitados.contains("La Mezquita") ? View.VISIBLE : View.GONE);
        cardelfaro.setVisibility(lugaresVisitados.contains("El Faro") ? View.VISIBLE : View.GONE);
        cardparquejapones.setVisibility(lugaresVisitados.contains("Parque Japonés") ? View.VISIBLE : View.GONE);
    }

    private void aplicarFiltro(String filtro) {
        actualizarLugaresVisitados();

        switch (filtro) {
            case "Playa":
                ocultarExcepto("Avenida del Mar");
                break;
            case "Cultural":
                ocultarExcepto("Fuerte Lambert", "Cruz del Tercer Milenio", "Pueblito Peñuelas");
                break;
            case "Religioso":
                ocultarExcepto("La Mezquita");
                break;
            case "Parques":
                ocultarExcepto("Parque Japonés");
=======
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
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
                break;
        }
    }

<<<<<<< HEAD
    private void ocultarExcepto(String... visibles) {
        Set<String> visiblesSet = new HashSet<>();
        for (String n : visibles) visiblesSet.add(n);

        if (!visiblesSet.contains("Fuerte Lambert")) cardfuertelambert.setVisibility(View.GONE);
        if (!visiblesSet.contains("Cruz del Tercer Milenio")) cardcruztercermilenio.setVisibility(View.GONE);
        if (!visiblesSet.contains("Pueblito Peñuelas")) cardpueblitopeñuelas.setVisibility(View.GONE);
        if (!visiblesSet.contains("Avenida del Mar")) cardavenidadelmar.setVisibility(View.GONE);
        if (!visiblesSet.contains("La Mezquita")) cardlamezquita.setVisibility(View.GONE);
        if (!visiblesSet.contains("El Faro")) cardelfaro.setVisibility(View.GONE);
        if (!visiblesSet.contains("Parque Japonés")) cardparquejapones.setVisibility(View.GONE);
    }

    private void abrirInformacionLugar(String nombreLugar) {
        Intent i = new Intent(this, InformacionLugarActivity.class);
        i.putExtra("nombreLugar", nombreLugar);
        i.putExtra("origen", "lugares_visitados");
        startActivity(i);
    }

=======
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
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

<<<<<<< HEAD
        if (id == R.id.nav_lugares_turisticos)
            startActivity(new Intent(this, LugaresTuristicosActivity.class));
        else if (id == R.id.nav_lugares_favoritos)
            startActivity(new Intent(this, LugaresFavoritosActivity.class));
        else if (id == R.id.nav_configuracion)
            startActivity(new Intent(this, ConfiguracionActivity.class));

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
=======
        if (id == R.id.nav_lugares_turisticos) {
            Intent intent = new Intent(this, LugaresTuristicosActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        return false;
    }
}


>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
