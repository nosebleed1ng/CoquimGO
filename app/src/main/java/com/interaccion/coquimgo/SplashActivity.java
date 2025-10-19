package com.interaccion.coquimgo;

import android.content.Intent;
<<<<<<< HEAD
import android.content.SharedPreferences;
=======
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.interaccion.coquimgo.databinding.ActivitySplashBinding;

<<<<<<< HEAD
import java.util.Locale;

=======
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

<<<<<<< HEAD
        // 🔹 Aplicar idioma guardado globalmente antes de mostrar la pantalla
        SharedPreferences prefs = getSharedPreferences("config", MODE_PRIVATE);
        String idiomaGuardado = prefs.getString("idioma", "es"); // por defecto español

        Locale locale = new Locale(idiomaGuardado);
        Locale.setDefault(locale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        // Inflar la vista normalmente
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Botón Iniciar → abre LugaresTuristicosActivity
=======
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Botón Iniciar abre LugaresTuristicosActivity
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
        binding.btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, LugaresTuristicosActivity.class);
                startActivity(intent);
<<<<<<< HEAD
                finish(); // Evita volver al splash con el botón atrás
=======
                finish(); // metodo para no poder volver con el boton atras a splashactivity
>>>>>>> 517a9a7cfb7dc8fae6aa412ddc4fa11cae9b6a65
            }
        });
    }
}
