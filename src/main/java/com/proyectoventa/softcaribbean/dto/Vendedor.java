package com.proyectoventa.softcaribbean.dto;

public class Vendedor {
    private int nmvendedor;
    private String documento;
    private String dsnombres;
    private String desapellidos;
    private String dsdireccion;


    public int getNmvendedor() {
        return nmvendedor;
    }

    public void setNmvendedor(int nmvendedor) {
        this.nmvendedor = nmvendedor;
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

    public String getDesapellidos() {
        return desapellidos;
    }

    public void setDesapellidos(String desapellidos) {
        this.desapellidos = desapellidos;
    }

    public String getDsdireccion() {
        return dsdireccion;
    }

    public void setDsdireccion(String dsdireccion) {
        this.dsdireccion = dsdireccion;
    }
}
