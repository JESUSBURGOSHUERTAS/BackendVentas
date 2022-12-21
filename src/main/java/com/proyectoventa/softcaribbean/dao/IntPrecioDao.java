package com.proyectoventa.softcaribbean.dao;

import com.proyectoventa.softcaribbean.dto.Precio;
import com.proyectoventa.softcaribbean.exception.DaoException;

import java.util.List;

public interface IntPrecioDao {
    public void Insert(Precio m)throws DaoException;
    public void Update(Precio m)throws DaoException;
    public void Delete(Precio m)throws DaoException;
    public List<Precio> SelectAll()throws DaoException;
    public Precio SelectById (Precio m) throws DaoException;
}
