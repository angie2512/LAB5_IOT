package com.example.lab5_iot;

import static android.Manifest.permission.POST_NOTIFICATIONS;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.example.lab5_iot.Trabajador.Vistatrabajador;
import com.example.lab5_iot.Tutor.Vistatutor;
import com.example.lab5_iot.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonTrabajador.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Vistatrabajador.class);
            startActivity(intent);
        });

        binding.buttonTutor.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Vistatutor.class);
            startActivity(intent);
        });


    }


}