package com.ucv.menuapp;

public class Form2 {

    String idregistro, nombres, apellidos, celular, email, solicitud, domicilio, referencia, servicio, departamento, provincia, distrito, ubicacion;

    public Form2(String idregistro, String nombres, String apellidos, String celular, String email, String solicitud, String domicilio, String referencia, String servicio, String departamento, String provincia, String distrito, String ubicacion) {
        this.idregistro = idregistro;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.email = email;
        this.solicitud = solicitud;
        this.domicilio = domicilio;
        this.referencia = referencia;
        this.servicio = servicio;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.ubicacion = ubicacion;
    }

    public String getIdregistro() {
        return idregistro;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public String getSolicitud() {
        return solicitud;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getServicio() {
        return servicio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}



