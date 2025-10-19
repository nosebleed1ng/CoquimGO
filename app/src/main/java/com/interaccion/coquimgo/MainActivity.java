package com.interaccion.coquimgo;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
=======

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_main);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Drawer (menú lateral)
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Toggle (ícono del menú hamburguesa)
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.open_nav, R.string.close_nav
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Seleccionar item por defecto
        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.nav_mapa);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_mapa) {
            // Aquí puedes abrir tu Activity del mapa
            // startActivity(new Intent(this, MapaActivity.class));

        } else if (id == R.id.nav_lugares_turisticos) {
            startActivity(new Intent(this, LugaresTuristicosActivity.class));

        } else if (id == R.id.nav_lugares_visitados) {
            startActivity(new Intent(this, LugaresVisitadosActivity.class));

        } else if (id == R.id.nav_lugares_favoritos) {
            startActivity(new Intent(this, LugaresFavoritosActivity.class));

        } else if (id == R.id.nav_configuracion) {
            // ✅ Abrir Configuración
            startActivity(new Intent(this, ConfiguracionActivity.class));
        }

        // Cierra el Drawer después de la selección
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
=======
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }
}
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
