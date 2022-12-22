package com.proyectoventa.softcaribbean.facade;

import com.proyectoventa.softcaribbean.dto.Factura;
import com.proyectoventa.softcaribbean.exception.FacadeException;

import java.util.List;

public interface IntFacturaFacade {
    public void Process(Factura f) throws FacadeException;
    public void Delete(Factura f) throws FacadeException;
    public List<Factura> SelectAll()throws FacadeException;
}
