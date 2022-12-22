package com.proyectoventa.softcaribbean.dto;

public class Cliente {
   private int nmcliente;
    private String documento;
    private String dsnombres;
    private String dsapellidos;
    private String dsdireccion;

    public int getNmcliente() {
        return nmcliente;
    }

    public void setNmcliente(int nmcliente) {
        this.nmcliente = nmcliente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDsnombres() {
        return dsnombres;
    }

    public void setDsnombres(String dsnombres) {
        this.dsnombres = dsnombres;
    }

    public String getDsapellidos() {
        return dsapellidos;
    }

    public void setDsapellidos(String dsapellidos) {
        this.dsapellidos = dsapellidos;
    }

    public String getDsdireccion() {
        return dsdireccion;
    }

    public void setDsdireccion(String dsdireccion) {
        this.dsdireccion = dsdireccion;
    }
}
