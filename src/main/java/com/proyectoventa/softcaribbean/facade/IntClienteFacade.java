package com.proyectoventa.softcaribbean.facade;

import com.proyectoventa.softcaribbean.dto.Cliente;

import com.proyectoventa.softcaribbean.exception.FacadeException;

import java.util.List;

public interface IntClienteFacade {

    public void Process(Cliente c) throws FacadeException;
    public void Delete(Cliente c) throws FacadeException;
    public List<Cliente> SelectAll()throws FacadeException;
}
