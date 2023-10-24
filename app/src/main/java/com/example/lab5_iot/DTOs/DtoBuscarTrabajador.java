package com.example.lab5_iot.DTOs;

import com.example.lab5_iot.Entidades.Employees;

public class DtoBuscarTrabajador {
    private Employees empleado;
    private String respuesta;

    public Employees getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Employees empleado) {
        this.empleado = empleado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
