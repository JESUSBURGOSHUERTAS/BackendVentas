package com.proyectoventa.softcaribbean.mgr;

import com.proyectoventa.softcaribbean.dto.Precio;

import com.proyectoventa.softcaribbean.exception.DaoException;

import java.util.List;

public interface IntPrecioMgr {
    public void Save(Precio m) throws DaoException;
    public void Delete(Precio m)throws DaoException;
    public List<Precio> SelectAll()throws DaoException;
}
