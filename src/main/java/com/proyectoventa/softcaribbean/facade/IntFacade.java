package com.proyectoventa.softcaribbean.facade;

import com.proyectoventa.softcaribbean.dto.Productos;
import com.proyectoventa.softcaribbean.exception.FacadeException;

import java.util.List;

public interface IntFacade {
    public void Process(Productos p)throws FacadeException;
    public void Delete(Productos p)throws FacadeException;
    public List<Productos> SelectAll()throws FacadeException;
}
