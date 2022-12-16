package com.proyectoventa.softcaribbean.dto;

public class Productos {
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDsproducto() {
        return dsproducto;
    }

    public void setDsproducto(String dsproducto) {
        this.dsproducto = dsproducto;
    }

    private String sku;
    private String dsproducto;
}
