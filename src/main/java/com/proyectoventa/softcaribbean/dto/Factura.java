package com.proyectoventa.softcaribbean.dto;

import java.sql.Date;

public class Factura {

    private int nmfactura;
    private String cdfactura;
    private Vendedor vendedorDTO;
    private Cliente clienteDTO;
    private Date fefactura;



    public int getNmfactura() {
        return nmfactura;
    }

    public void setNmfactura(int nmfactura) {
        this.nmfactura = nmfactura;
    }

    public String getCdfactura() {
        return cdfactura;
    }

    public void setCdfactura(String cdfactura) {
        this.cdfactura = cdfactura;
    }

    public Vendedor getVendedorDTO() {
        return vendedorDTO;
    }

    public void setVendedorDTO(Vendedor vendedorDTO) {
        this.vendedorDTO = vendedorDTO;
    }

    public Cliente getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(Cliente clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public Date getFefactura() {
        return fefactura;
    }

    public void setFefactura(Date fefactura) {
        this.fefactura = fefactura;
    }
}
