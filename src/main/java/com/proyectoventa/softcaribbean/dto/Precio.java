package com.proyectoventa.softcaribbean.dto;

import java.sql.Date;

public class Precio {
    public int getNmprecio() {
        return nmprecio;
    }

    public void setNmprecio(int nmprecio) {
        this.nmprecio = nmprecio;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFedesde() {
        return fedesde;
    }

    public void setFedesde(Date fedesde) {
        this.fedesde = fedesde;
    }

    public Date getFehasta() {
        return fehasta;
    }

    public void setFehasta(Date fehasta) {
        this.fehasta = fehasta;
    }

    private int nmprecio;
    private String sku;
    private int precio;
    private Date fedesde;
    private Date fehasta;

}
