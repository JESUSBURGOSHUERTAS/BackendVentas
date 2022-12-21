package com.proyectoventa.softcaribbean.facade;

import com.proyectoventa.softcaribbean.dto.Precio;

import com.proyectoventa.softcaribbean.dto.Vendedor;
import com.proyectoventa.softcaribbean.exception.FacadeException;

import java.util.List;

public interface IntPrecioFacade {
    public void Process(Precio m) throws FacadeException;
    public void Delete(Precio m) throws FacadeException;
    public List<Precio> SelectAll()throws FacadeException;
}
