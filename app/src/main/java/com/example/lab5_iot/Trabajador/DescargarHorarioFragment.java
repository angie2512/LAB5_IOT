package com.example.lab5_iot.Trabajador;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab5_iot.DTOs.DtoBuscarTrabajador;
import com.example.lab5_iot.Entidades.Employees;
import com.example.lab5_iot.Entidades.ServiceTrabajador;
import com.example.lab5_iot.R;
import com.example.lab5_iot.databinding.FragmentDescargarHorarioBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
            String id = binding.TextEditID.getText().toString();
            binding.textViewError.setText("");
            if (!id.equals("")){
                try {
                    int idTrabajador = Integer.parseInt(id);
                    serviceTrabajador.buscarTrabPorId(idTrabajador).enqueue(new Callback<DtoBuscarTrabajador>() {
                        @Override
                        public void onResponse(Call<DtoBuscarTrabajador> call, Response<DtoBuscarTrabajador> response) {
                            if (response.isSuccessful()) {
                                DtoBuscarTrabajador dtoBuscarTrabajador = response.body();
                                if (dtoBuscarTrabajador.getRespuesta().equals("No se encontró")) {
                                    binding.textViewError.setText("No existe el empleado");

                                } else {
                                    Employees trabajador = dtoBuscarTrabajador.getEmpleado();
                                    if (trabajador.getMeeting() == 1) {

                                        Context context = getActivity();
                                        String permission = Manifest.permission.WRITE_EXTERNAL_STORAGE;

                                        binding.textViewError.setText("Descarga exitosa, descargue los horarios disponibles");
                                        binding.textViewError.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


                                    }
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<DtoBuscarTrabajador> call, Throwable t) {

                        }
                    });
                }
            }
        });


        return inflater.inflate(R.layout.fragment_descargar_horario, container, false);
    }


}