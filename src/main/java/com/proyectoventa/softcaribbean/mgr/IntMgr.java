package com.proyectoventa.softcaribbean.mgr;

import com.proyectoventa.softcaribbean.dto.Productos;
import com.proyectoventa.softcaribbean.exception.DaoException;

import java.util.List;

public interface IntMgr {
    public void Save(Productos p) throws DaoException;
    public void Delete(Productos p)throws DaoException;
    public List<Productos> SelectAll()throws DaoException;
}
