package com.proyectoventa.softcaribbean.dto;

public class Vendedor {
    private String nmvendedor;
    private String documento;
    private String dsnombres;
    private String desapellidos;
    private String dsdireccion;

    public String getNmvendedor() {
        return nmvendedor;
    }

    public void setNmvendedor(String nmvendedor) {
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
