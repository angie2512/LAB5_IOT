package com.example.lab5_iot.Trabajador;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab5_iot.Entidades.ServiceTrabajador;
import com.example.lab5_iot.R;
import com.example.lab5_iot.databinding.FragmentDescargarHorarioBinding;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DescargarHorarioFragment extends Fragment {


    FragmentDescargarHorarioBinding binding;

    ServiceTrabajador serviceTrabajador = new Retrofit.Builder()
            .baseUrl("http://10.0.1.1:8081")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServiceTrabajador.class);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentDescargarHorarioBinding.inflate(inflater, container, false);
        binding.buttonDescargarHorario.setOnClickListener(view -> {

        });


        return inflater.inflate(R.layout.fragment_descargar_horario, container, false);
    }


}