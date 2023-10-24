package com.example.lab5_iot.DTOs;

import com.example.lab5_iot.Entidades.Employees;

import java.util.List;

public class DtoBuscarTrabajadores {
    private String respuesta;
    private List<Employees> empleado;

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public List<Employees> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<Employees> empleado) {
        this.empleado = empleado;
    }
}
