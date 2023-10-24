package com.example.lab5_iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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