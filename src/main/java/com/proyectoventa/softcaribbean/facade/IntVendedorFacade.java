package com.proyectoventa.softcaribbean.facade;

import com.proyectoventa.softcaribbean.dto.Vendedor;
import com.proyectoventa.softcaribbean.exception.FacadeException;

import java.util.List;

public interface IntVendedorFacade {
    public void Process(Vendedor v) throws FacadeException;
    public void Delete(Vendedor v) throws FacadeException;
    public List<Vendedor> SelectAll()throws FacadeException;
}
