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

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Tutorías Laborales");

        creacionDeNotificacionTrabajador();
        creacionDeNotificacionTutor();
    }

    String channelId1 = "trabajadorChannelHighPriority";
    String channelId2 = "tutorChannelHighPriority";
    public void askPermission(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU &&
                ActivityCompat.checkSelfPermission(this, POST_NOTIFICATIONS) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{POST_NOTIFICATIONS}, 101);
        }
    }
    public void creacionDeNotificacionTrabajador(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel =new NotificationChannel(channelId1, "Canal notificaciones High", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Canal para notificaciones con prioridad Alta");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            askPermission();
        }
    }

    public void creacionDeNotificacionTutor(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel =new NotificationChannel(channelId2, "Canal notificaciones High", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Canal para notificaciones con prioridad Alta");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            askPermission();
        }
    }
}