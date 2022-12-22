package com.proyectoventa.softcaribbean.mgr;

import com.proyectoventa.softcaribbean.dto.Cliente;
import com.proyectoventa.softcaribbean.exception.DaoException;

import java.util.List;

public interface IntClienteMgr {

    public void Save(Cliente c) throws DaoException;
    public void Delete(Cliente c)throws DaoException;
    public List<Cliente> SelectAll()throws DaoException;
}
